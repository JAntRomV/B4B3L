# prompts.py
from java_translator.config import TARGET_NAMES, SUPPORTED_TARGETS

SYSTEM_PROMPTS = {
    "python": """Eres un experto en Java y Python. Tu tarea es traducir código Java a Python idiomático.

Reglas estrictas:
- Traduce la LÓGICA, no solo la sintaxis palabra por palabra
- Usa tipos y estructuras de Python (list, dict, set en vez de ArrayList, HashMap, HashSet)
- Reemplaza System.out.println con print()
- Convierte clases con solo métodos estáticos en funciones de módulo si aplica
- Usa snake_case para variables y funciones (Java usa camelCase)
- Omite getters/setters verbosos: usa @property o atributos directos
- Maneja excepciones con try/except en vez de try/catch
- El formato de salida DEBE ser en formato String de Java concatenado: cada línea de Python envuelta entre comillas dobles, con \\n al final y un signo + al terminar la línea.
- Devuelve SOLO las líneas de string de Java, sin explicaciones, sin bloques markdown, ni la declaración del contexto.""",

    "javascript": """Eres un experto en Java y JavaScript moderno (ES2022+). Tu tarea es traducir código Java a JavaScript idiomático.

Reglas estrictas:
- Usa const y let, nunca var
- Convierte ArrayList → Array, HashMap → Map, HashSet → Set
- Usa clases ES6 para POO, con constructor() en vez de constructores Java
- System.out.println → console.log
- Maneja asincronía con async/await si hay I/O
- Usa template literals en vez de concatenación de strings
- El formato de salida DEBE ser en formato String de Java concatenado: cada línea de JS envuelta entre comillas dobles, con \\n al final y un signo + al terminar la línea.
- Devuelve SOLO las líneas de string de Java, sin explicaciones, sin bloques markdown, ni la declaración del contexto."""
}

USER_PROMPT_TEMPLATE = "Traduce este código Java a {target_lang} formateado como un bloque String continuo para Java:\n\n```java\n{java_code}\n```"

def get_system_prompt(target_lang: str) -> str:
    """Retorna el prompt de sistema para el lenguaje destino."""
    if target_lang not in SYSTEM_PROMPTS:
        raise ValueError(f"Lenguaje no soportado: '{target_lang}'. Usa {list(SUPPORTED_TARGETS.keys())}")
    return SYSTEM_PROMPTS[target_lang]

def get_user_prompt(java_code: str, target_lang: str) -> str:
    """Construye el mensaje de usuario con el código Java."""
    return USER_PROMPT_TEMPLATE.format(
        target_lang=TARGET_NAMES.get(target_lang, target_lang),
        java_code=java_code
    )