# B4B3L

Traductor de código **Java → Python / JavaScript** impulsado por IA, con soporte para ejecución políglota mediante **GraalVM**.

B4B3L automatiza la migración de lógica Java hacia lenguajes destino. Además de generar scripts traducidos, puede producir clases Java híbridas que ejecutan el código traducido en runtime usando la API Polyglot de GraalVM.

---

## Características

- Traducción de Java a **Python** o **JavaScript** con **Llama 3.3** (Groq).
- Dos modos de salida:
  - **`standard`**: código limpio en el lenguaje destino.
  - **`polyglot`**: clase Java ejecutable (`*Poliglota.java`) con `org.graalvm.polyglot`.
- **CLI** para archivos individuales o procesamiento por lotes.
- **API REST** (FastAPI) para integración con otros sistemas.
- Validación previa del código Java de entrada.
- Suite de pruebas con datasets de referencia (Abacus, ChatGPT, Gemini).

---

## Cómo funciona

```
.java  →  validación  →  Groq (Llama 3.3)  →  código traducido
                                              ↓
                              wrapper políglota (opcional)
                                              ↓
                              javac + java (GraalVM)
```

1. Se recibe código Java y se valida sintácticamente.
2. El modelo traduce la lógica usando prompts especializados por lenguaje destino.
3. En modo políglota, el resultado se envuelve en una clase Java que invoca `Context.eval()`.
4. La clase generada se compila y ejecuta con GraalVM.

---

## Estructura del proyecto

```
B4B3L/
├── java_translator/     # Motor de traducción (CLI + lógica core)
│   ├── translator.py    # Cliente Groq, wrapper GraalVM
│   ├── translator_service.py
│   ├── prompts.py       # Prompts por lenguaje destino
│   ├── validator.py
│   └── main.py          # Punto de entrada CLI
├── api/                 # API REST (FastAPI)
├── tests/               # Pruebas unitarias, integración y datasets
│   ├── test_integration_polyglot.py
│   ├── python_tests/
│   ├── javaScript_tests/
│   └── test_data/       # Casos de prueba (Abacus, ChatGPT, Gemini)
├── config-env/
│   └── requirements.txt
├── CONFIG_LOCAL.md      # Guía de configuración local paso a paso
└── README.md
```

---

## Inicio rápido

Para configurar el entorno (GraalVM, Groq, dependencias Python y pruebas), sigue la guía completa:

**[CONFIG_LOCAL.md](./CONFIG_LOCAL.md)**

Resumen:

```bash
# Dependencias
python -m venv .venv && source .venv/bin/activate
pip install -r config-env/requirements.txt
pip install groq pytest

# Credenciales
export GROQ_API_KEY="gsk_tu_clave_aqui"

# Verificar integración
pytest tests/test_integration_polyglot.py -v
```

---

## Uso

### CLI

Traducir un archivo a wrapper políglota Python:

```bash
python -m java_translator.main -i archivo.java -t python -o salida/ArchivoPoliglota.java
```

Traducir un directorio completo:

```bash
python -m java_translator.main -b tests/test_data/Abacus/v1/Rare -t python -o salida/
```

Compilar y ejecutar con GraalVM:

```bash
javac salida/ArchivoPoliglota.java
java -cp salida ArchivoPoliglota
```

### API REST

```bash
uvicorn api.main:app --reload --port 8000
```

| Endpoint | Descripción |
|---|---|
| `POST /api/v1/translate/text` | Traduce código Java enviado en JSON |
| `POST /api/v1/translate/file` | Traduce un `.java` o un lote `.zip` |

Documentación interactiva: `http://localhost:8000/docs`

Todas las peticiones requieren la cabecera `X-Groq-API-Key`.

**Ejemplo (modo polyglot):**

```json
POST /api/v1/translate/text
{
  "code": "public class Hola { public static void main(String[] args) { System.out.println(\"Hola\"); } }",
  "target_language": "python",
  "mode": "polyglot"
}
```

---

## Pruebas

```bash
# Integración políglota (traducción + javac + ejecución)
pytest tests/test_integration_polyglot.py -v

# Traducciones Python
pytest tests/python_tests/ -v

# Traducciones JavaScript
pytest tests/javaScript_tests/ -v
```

---

## Stack tecnológico

| Componente | Tecnología |
|---|---|
| Modelo IA | Llama 3.3 70B (`llama-3.3-70b-versatile`) vía Groq |
| Backend | Python 3.11+, FastAPI, python-dotenv |
| Runtime políglota | GraalVM JDK 17/21 + componente Python |
| Pruebas | pytest |

---

## Licencia

Este proyecto está bajo la licencia [Apache 2.0](./LICENSE).
