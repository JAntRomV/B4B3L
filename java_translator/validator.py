import re

def validate_java_code(code: str) -> tuple[bool, str]:
    """
    Validación básica de código Java.
    Retorna (es_valido, mensaje_de_error)
    """
    if not code or not code.strip():
        return False, "El código no puede estar vacío"
    
    if len(code) > 50_000:
        return False, "El código es demasiado largo (máximo 50,000 caracteres)"

    # Indicadores básicos de que es Java
    java_patterns = [
        r'\bpublic\b|\bprivate\b|\bprotected\b',   # modificadores
        r'\bclass\b|\binterface\b|\benum\b',          # declaraciones
        r'\bvoid\b|\bint\b|\bString\b|\bboolean\b',  # tipos
        r'System\.out\.',                              # I/O típico
        r';$',                                         # fin de sentencias
    ]
    
    matches = sum(1 for p in java_patterns if re.search(p, code, re.MULTILINE))
    
    if matches < 2:
        return False, "El código no parece ser Java válido"
    
    return True, "OK"