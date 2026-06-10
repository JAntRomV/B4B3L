from dotenv import load_dotenv
load_dotenv()
# import anthropic
from groq import Groq
import os
from java_translator.prompts import get_system_prompt, get_user_prompt

client = Groq(api_key=os.getenv("GROQ_API_KEY"))

def translate_code(java_code: str, target_lang: str) -> dict:
    response = client.chat.completions.create(
        model="llama-3.3-70b-versatile",  # modelo gratuito y potente
        messages=[
            {
                "role": "system",
                "content": get_system_prompt(target_lang)   # <- desde prompts.py
            },
            {
                "role": "user",
                "content": get_user_prompt(java_code, target_lang)  # <- desde prompts.py
            }
        ],
        max_tokens=4096
    )

    translated = response.choices[0].message.content.strip()
    
    if translated.startswith("```"):
        lines = translated.split("\n")
        translated = "\n".join(lines[1:-1])

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