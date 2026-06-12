import pytest
from java_translator.prompts import get_system_prompt

def test_javascript_prompt_generation():
    """Asegura que el motor de prompts devuelva las reglas de JavaScript estrictas."""
    prompt = get_system_prompt("javascript")
    assert "console.log" in prompt
    assert "const y let" in prompt
    assert "Array" in prompt