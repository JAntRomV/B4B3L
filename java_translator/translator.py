import os
from dotenv import load_dotenv
from groq import Groq
from openai import OpenAI
import anthropic
from google import genai
from java_translator.prompts import get_system_prompt, get_user_prompt

load_dotenv()

# Cliente por defecto de Groq (mantenido por compatibilidad global si se requiere)
default_groq_client = Groq(api_key=os.getenv("GROQ_API_KEY"))

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

def _clean_markdown(code_text: str) -> str:
    """Limpia los bloques de código con triple backticks si el LLM los incluye."""
    cleaned = code_text.strip()
    if cleaned.startswith("```"):
        lines = cleaned.split("\n")
        # Quita la primera línea (ej. ```python) y la última (```)
        cleaned = "\n".join(lines[1:-1]).strip()
    return cleaned

def translate_code(java_code: str, target_language: str, api_key: str = None) -> dict:
    """
    Traduce código Java a un lenguaje destino soportando múltiples proveedores de manera dinámica.
    Detecta automáticamente el proveedor basado en el prefijo de la API Key.
    """
    # 1. Recuperar la API Key (de los parámetros o del entorno)
    key = api_key or os.getenv("GROQ_API_KEY") or os.getenv("OPENAI_API_KEY")
    if not key:
        raise ValueError("No se proporcionó ninguna API Key válida.")

    # 2. Preparar los prompts estructurados del proyecto
    system_prompt = get_system_prompt(target_language)
    user_prompt = get_user_prompt(java_code, target_language)
    
    codigo_traducido = ""
    tokens_info = {"input": 0, "output": 0}

    # 3. Enrutamiento dinámico según el proveedor
    try:
        # === CASO 1: ANTHROPIC (Claude) ===
        if key.startswith("sk-ant"):
            client = anthropic.Anthropic(api_key=key)
            message = client.messages.create(
                model="claude-3-5-sonnet-latest",
                max_tokens=4096,
                system=system_prompt,
                messages=[{"role": "user", "content": user_prompt}]
            )
            codigo_traducido = message.content[0].text
            tokens_info = {
                "input": message.usage.input_tokens,
                "output": message.usage.output_tokens
            }

        # === CASO 2: GEMINI (Google - SDK Moderno google-genai) ===
        elif key.startswith("AIzaSy") or key.startswith("AQ."):
            client = genai.Client(api_key=key)
            response = client.models.generate_content(
                model="gemini-2.5-flash",
                contents=user_prompt,
                config={"system_instruction": system_prompt}
            )
            codigo_traducido = response.text
            if hasattr(response, 'usage_metadata') and response.usage_metadata:
                tokens_info = {
                    "input": response.usage_metadata.prompt_token_count,
                    "output": response.usage_metadata.candidates_token_count
                }

        # === CASO 3: OPENAI (ChatGPT) ===
        elif key.startswith("sk-") and not key.startswith("sk-ant"):
            client = OpenAI(api_key=key)
            response = client.chat.completions.create(
                model="gpt-4o-mini",
                messages=[
                    {"role": "system", "content": system_prompt},
                    {"role": "user", "content": user_prompt}
                ]
            )
            codigo_traducido = response.choices[0].message.content
            tokens_info = {
                "input": response.usage.prompt_tokens,
                "output": response.usage.completion_tokens
            }

        # === CASO 4: GROQ (Llama 3.3 - Por defecto) ===
        else:
            client = Groq(api_key=key)
            response = client.chat.completions.create(
                model="llama-3.3-70b-versatile",
                messages=[
                    {"role": "system", "content": system_prompt},
                    {"role": "user", "content": user_prompt}
                ],
                max_tokens=4096
            )
            codigo_traducido = response.choices[0].message.content
            tokens_info = {
                "input": response.usage.prompt_tokens,
                "output": response.usage.completion_tokens
            }

        # 4. Limpieza del código de salida y retorno estructurado
        translated_clean = _clean_markdown(codigo_traducido)
        
        return {
            "code": translated_clean,
            "tokens": tokens_info
        }

    except Exception as e:
        return {"code": "", "error": f"Error procesando con el proveedor: {str(e)}", "tokens": tokens_info}