import pytest
from tests.test_data.ChatGPT.v1.Transcribed.Suma import suma_numeros
from tests.test_data.ChatGPT.v1.Transcribed.Tareas import gestor_de_tareas

def test_suma_numeros_exitoso(monkeypatch, capsys):
    """Prueba que la función sume correctamente simulando entradas de teclado."""
    
    # 1. SIMULAR TECLADO: Creamos una lista con las entradas que metería el usuario
    respuestas_usuario = iter(["5", "3"])
    monkeypatch.setattr("builtins.input", lambda _: next(respuestas_usuario))
    
    # 2. EJECUTAR: Llamamos a la función de la IA
    suma_numeros()
    
    # 3. CAPTURAR PANTALLA: Leemos lo que la función imprimió con 'print'
    captura = capsys.readouterr()
    
    # 4. VALIDAR: Verificamos que la salida en pantalla contenga el resultado esperado
    assert "La suma es: 8" in captura.out

def test_suma_numeros_error_letras(monkeypatch, capsys):
    """Prueba que la función maneje el error si el usuario mete letras."""
    
    # Simulamos que el usuario mete una "X" en el primer número
    respuestas_usuario = iter(["X", "3"])
    monkeypatch.setattr("builtins.input", lambda _: next(respuestas_usuario))
    
    suma_numeros()
    
    captura = capsys.readouterr()
    
    # Verificamos que se haya ejecutado el bloque 'except ValueError'
    assert "Error: Debe ingresar un número" in captura.out

def test_gestor_de_tareas_limite_maximo(monkeypatch, capsys):
    """Prueba que el gestor se detenga automáticamente al llegar a 5 tareas."""
    # 1. Simular que el usuario ingresa 5 tareas seguidas
    entradas = iter(["Estudiar", "Cocinar", "Gimnasio", "Programar", "Leer"])
    monkeypatch.setattr("builtins.input", lambda _: next(entradas))
    
    # 2. Ejecutar la función
    gestor_de_tareas()
    
    # 3. Capturar la salida de la consola
    captura = capsys.readouterr()
    
    # 4. Validar que las 5 tareas se hayan listado correctamente
    assert "Tareas guardadas:" in captura.out
    assert "1. Estudiar" in captura.out
    assert "5. Leer" in captura.out

def test_gestor_de_tareas_salir_antes(monkeypatch, capsys):
    """Prueba que el programa termine de inmediato si el usuario escribe 'salir'."""
    # Simular que el usuario ingresa 2 tareas y luego escribe 'salir'
    entradas = iter(["Comprar pan", "Lavar ropa", "salir"])
    monkeypatch.setattr("builtins.input", lambda _: next(entradas))
    
    gestor_de_tareas()
    
    captura = capsys.readouterr()
    
    # Validar que solo se guardaron las dos primeras y no esperó las 5
    assert "1. Comprar pan" in captura.out
    assert "2. Lavar ropa" in captura.out
    assert "3." not in captura.out