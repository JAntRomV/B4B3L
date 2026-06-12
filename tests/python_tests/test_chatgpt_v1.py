import os
import subprocess
import pytest

PY_OUTPUT_DIR = os.path.join("tests", "test_data", "ChatGPT", "v1", "Transcribed_PY")

def run_transcribed_script(script_name, inputs):
    """
    Función helper para ejecutar un script de Python de forma aislada 
    inyectando entradas simuladas en el stdin.
    """
    script_path = os.path.join(PY_OUTPUT_DIR, script_name)
    
    # Unimos los inputs con saltos de línea para simular los 'Enter' del usuario
    stdin_data = "\n".join(inputs) + "\n"
    
    # Ejecutamos el archivo de forma externa
    result = subprocess.run(
        ["python3", script_path],
        input=stdin_data,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True,
        check=False  # Permite capturar errores sin que colapse Pytest
    )
    return result

def test_suma_numeros_exitoso():
    respuestas_usuario = ["5", "3"]    
    result = run_transcribed_script("Suma.py", respuestas_usuario)
    assert "La suma es: 8" in result.stdout

def test_suma_numeros_error_letras():
    """Prueba que la función maneje el error si el usuario mete letras."""
    # Enviamos una "X" para forzar el error.
    respuestas_usuario = ["X"]
    
    result = run_transcribed_script("Suma.py", respuestas_usuario)
    
    assert "Error: Por favor ingrese un número válido" in result.stdout

def test_gestor_de_tareas_limite_maximo():
    """Prueba que el gestor se detenga automáticamente al llegar a 5 tareas."""
    # Simular que el usuario ingresa 5 tareas seguidas
    entradas = ["Estudiar", "Cocinar", "Gimnasio", "Programar", "Leer"]
    
    result = run_transcribed_script("Tareas.py", entradas)
    
    # Validar que las 5 tareas se hayan listado correctamente en la consola
    assert "Tareas guardadas:" in result.stdout
    assert "1. Estudiar" in result.stdout
    assert "5. Leer" in result.stdout

def test_gestor_de_tareas_salir_antes():
    """Prueba que el programa termine de inmediato si el usuario escribe 'salir'."""
    # Simular que el usuario ingresa 2 tareas y luego escribe 'salir'
    entradas = ["Comprar pan", "Lavar ropa", "salir"]
    
    result = run_transcribed_script("Tareas.py", entradas)
    
    # Validar que solo se guardaron las dos primeras y no esperó las 5
    assert "1. Comprar pan" in result.stdout
    assert "2. Lavar ropa" in result.stdout
    assert "3." not in result.stdout