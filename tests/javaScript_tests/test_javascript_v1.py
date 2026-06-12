import os
import subprocess
import pytest

JS_OUTPUT_DIR = "tests/test_data/ChatGPT/v1/Transcribed_JS"

def get_js_files():
    if not os.path.exists(JS_OUTPUT_DIR):
        return []
    return [f for f in os.listdir(JS_OUTPUT_DIR) if f.endswith('.js')]

@pytest.mark.skipif(not os.path.exists(JS_OUTPUT_DIR) or not get_js_files(), 
                    reason="No hay archivos JS transcritos para validar aún.")
@pytest.mark.parametrize("js_file", get_js_files())
def test_javascript_file_execution(js_file):
    """Ejecuta cada archivo JS con Node.js en modo de chequeo sintáctico."""
    full_path = os.path.join(JS_OUTPUT_DIR, js_file)
    
    # El flag --check valida la sintaxis de Node sin ejecutar bucles o lógica pesada
    result = subprocess.run(
        ["node", "--check", full_path],
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )
    
    assert result.returncode == 0, f"Error de sintaxis en el JS generado ({js_file}):\n{result.stderr}"