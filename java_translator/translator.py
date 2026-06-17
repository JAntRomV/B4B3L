from dotenv import load_dotenv
from groq import Groq
import os
from java_translator.prompts import get_system_prompt, get_user_prompt

load_dotenv()

client = Groq(api_key=os.getenv("GROQ_API_KEY"))

def build_polyglot_wrapper(class_name: str, target_lang: str, raw_translated_string: str) -> str:
    """Envuelve las líneas de string traducidas dentro del cascarón Java ejecutable de GraalVM."""
    wrapper = f"""import org.graalvm.polyglot.*;

public class {class_name}Poliglota {{
    public static void main(String[] args) {{
        System.out.println("=== Iniciando Ejecución Políglota de {class_name} en {target_lang.upper()} ===");
        
        try (Context context = Context.create()) {{
            // Ejecución del bloque traducido usando GraalVM Truffle
            Value result = context.eval("{target_lang}",
{raw_translated_string}
            );
            
            if (!result.isNull()) {{
                System.out.println("\\n-> Resultado final devuelto a Java: " + result);
            }}
        }} catch (Exception e) {{
            System.err.println("❌ Error en la ejecución políglota: " + e.getMessage());
            e.printStackTrace();
        }}
    }}
}}
"""
    return wrapper

def translate_code(java_code: str, target_lang: str) -> dict:
    response = client.chat.completions.create(
        model="llama-3.3-70b-versatile",
        messages=[
            {
                "role": "system",
                "content": get_system_prompt(target_lang)
            },
            {
                "role": "user",
                "content": get_user_prompt(java_code, target_lang)
            }
        ],
        max_tokens=4096
    )

    translated = response.choices[0].message.content.strip()
    
    # Limpieza de markdown si el LLM lo ignora
    if translated.startswith("```"):
        lines = translated.split("\n")
        translated = "\n".join(lines[1:-1]).strip()

    return {
        "code": translated,
        "tokens": {
            "input": response.usage.prompt_tokens,
            "output": response.usage.completion_tokens
        }
    }

#CODE FOR ANTHROPIC $$$
# def translate_code(java_code: str, target_lang: str) -> dict:
#     """
#     Traduce código Java al lenguaje destino usando Claude como agente.
    
#     Args:
#         java_code: Código fuente en Java
#         target_lang: 'python' o 'javascript'
    
#     Returns:
#         dict con 'code' (traducción) y 'tokens' (uso de la API)
#     """
#     if target_lang not in SYSTEM_PROMPTS:
#         raise ValueError(f"Lenguaje no soportado: {target_lang}. Usa 'python' o 'javascript'")

#     message = client.messages.create(
#         model="claude-opus-4-6",
#         max_tokens=4096,
#         system=SYSTEM_PROMPTS[target_lang],
#         messages=[
#             {
#                 "role": "user",
#                 "content": f"Traduce este código Java a {target_lang}:\n\n```java\n{java_code}\n```"
#             }
#         ]
#     )

#     translated = message.content[0].text.strip()
    
#     # Limpia bloques de código si el modelo los incluyó de todas formas
#     if translated.startswith("```"):
#         lines = translated.split("\n")
#         translated = "\n".join(lines[1:-1])

#     return {
#         "code": translated,
#         "tokens": {
#             "input": message.usage.input_tokens,
#             "output": message.usage.output_tokens
#         }
#     }