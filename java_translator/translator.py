import os
import re
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

def clean_standard_output(code: str) -> str:
    """Sanitiza la salida del LLM en modo 'standard' para garantizar código plano.

    Elimina:
    - Bloques de código Markdown (```lang ... ```)
    - Formato de comillas y concatenaciones tipo Java (ej. "def sumar():\\n" +)
    - Saltos de línea o comillas escapadas explícitamente (\\n, \\")

    Args:
        code: Texto devuelto por el LLM.

    Returns:
        Código fuente limpio como string plano con saltos de línea normales.
    """
    if not code:
        return ""

    # 1. Remover bloques Markdown (```lang\n...\n```)
    code = re.sub(r"```[a-zA-Z]*\n?", "", code)
    code = re.sub(r"```", "", code)

    stripped = code.strip()

    # 2. Si el texto viene envuelto en formato de concatenación de Java
    #    (ej. "def sumar():\n" + o líneas rodeadas por comillas con signo +)
    if '"+' in stripped or '+\n"' in stripped or (stripped.startswith('"') and ('+' in stripped or stripped.endswith('"'))):
        clean_lines = []
        for line in stripped.splitlines():
            l = line.strip()
            # Eliminar comilla inicial
            l = re.sub(r'^\s*"', '', l)
            # Eliminar comilla final, salto de línea escapado y signo + si existen
            l = re.sub(r'(?:\\n)?\s*"\s*\+?\s*$', '', l)
            clean_lines.append(l)
        stripped = "\n".join(clean_lines)

    # 3. Reemplazar saltos de línea y comillas escapadas explícitas si quedaron literales
    stripped = stripped.replace("\\n", "\n").replace('\\"', '"')

    return stripped.strip()


def translate_code(java_code: str, target_language: str, api_key: str = None, mode: str = "polyglot") -> dict:
    """
    Traduce código Java a un lenguaje destino soportando múltiples proveedores de manera dinámica.
    Detecta automáticamente el proveedor basado en el prefijo de la API Key.

    Args:
        java_code: Código fuente Java a traducir.
        target_language: Lenguaje destino (ej. 'python', 'javascript').
        api_key: API Key del proveedor LLM. Si es None, se lee del entorno.
        mode: Modo de traducción — 'standard' para código plano ejecutable,
              'polyglot' para cadenas concatenadas de Java (envoltorio GraalVM).

    Returns:
        Diccionario con claves 'code' (str) y 'tokens' (dict) o 'error' (str).
    """
    # 1. Recuperar la API Key (de los parámetros o del entorno)
    key = api_key or os.getenv("GROQ_API_KEY") or os.getenv("OPENAI_API_KEY")
    if not key:
        raise ValueError("No se proporcionó ninguna API Key válida.")

    # 2. Preparar los prompts estructurados según el modo solicitado
    system_prompt = get_system_prompt(target_language, mode=mode)
    user_prompt = get_user_prompt(java_code, target_language, mode=mode)

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

        # 4. Post-procesamiento según el modo
        if mode == "standard":
            # Aplicar sanitización completa: elimina Markdown y concatenaciones Java
            translated_clean = clean_standard_output(codigo_traducido)
        else:
            # Modo polyglot: solo limpiar posibles bloques Markdown sobrantes
            translated_clean = _clean_markdown(codigo_traducido)

        return {
            "code": translated_clean,
            "tokens": tokens_info
        }

    except Exception as e:
        return {"code": "", "error": f"Error procesando con el proveedor: {str(e)}", "tokens": tokens_info}