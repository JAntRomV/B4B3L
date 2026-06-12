import pytest
from java_translator.validator import validate_java_code

def test_validador_detecta_codigo_vacio():
    """Prueba que el motor B4B3L rechaza correctamente un archivo vacío."""
    codigo_vacio = ""
    is_valid, error_msg = validate_java_code(codigo_vacio)
    
    assert is_valid is False
    assert "vacío" in error_msg.lower() or "error" in error_msg.lower()