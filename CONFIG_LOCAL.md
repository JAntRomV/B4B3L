# Configuración local — B4B3L

Tutorial paso a paso para configurar el proyecto, conectar **Llama 3.3** vía **Groq** y ejecutar las pruebas con **GraalVM**.

---

## 1. Requisitos previos

### GraalVM (Java 17 o 21)

Descarga e instala GraalVM CE desde [graalvm.org/downloads](https://www.graalvm.org/downloads/).

Configura `JAVA_HOME` y añade GraalVM al `PATH`:

**Linux / macOS**

```bash
export JAVA_HOME="/ruta/a/graalvm-jdk-21"
export PATH="$JAVA_HOME/bin:$PATH"
```

**Windows (PowerShell)**

```powershell
$env:JAVA_HOME = "C:\Program Files\GraalVM\graalvm-jdk-21"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
```

Verifica:

```bash
java -version    # debe mostrar "GraalVM"
javac -version
```

### Componente Python de GraalVM

Necesario para ejecutar traducciones destino `python`:

```bash
gu install python
# o, si gu no está en PATH:
"$JAVA_HOME/bin/gu" install python
```

Comprueba:

```bash
gu list   # debe aparecer python
```

### Python del sistema (3.11+)

```bash
python --version
```

---

## 2. Configurar Groq (Llama 3.3)

El traductor usa el modelo `llama-3.3-70b-versatile` en `java_translator/translator.py` por su buen balance entre velocidad y calidad en traducciones modulares.

1. Crea una cuenta en [console.groq.com](https://console.groq.com).
2. Genera una API Key (`gsk_...`).
3. Exporta la variable de entorno:

**Linux / macOS**

```bash
export GROQ_API_KEY="gsk_tu_clave_aqui"
```

**Windows (PowerShell)**

```powershell
$env:GROQ_API_KEY = "gsk_tu_clave_aqui"
```

**Alternativa:** crea un archivo `.env` en la raíz del proyecto:

```env
GROQ_API_KEY=gsk_tu_clave_aqui
```

---

## 3. Instalar dependencias Python

Desde la raíz del repositorio:

```bash
python -m venv .venv
```

Activa el entorno:

```bash
# Linux / macOS
source .venv/bin/activate

# Windows (PowerShell)
.\.venv\Scripts\Activate.ps1
```

Instala dependencias:

```bash
pip install --upgrade pip
pip install -r config-env/requirements.txt
pip install groq pytest
```

---

## 4. Ejecutar el proyecto

### Traducir un archivo Java (CLI)

```bash
python -m java_translator.main -i ruta/archivo.java -t python -o salida/ArchivoPoliglota.java
```

Compilar y ejecutar el resultado con GraalVM:

```bash
cd salida
javac ArchivoPoliglota.java
java ArchivoPoliglota
```

### API REST (opcional)

```bash
uvicorn api.main:app --reload --port 8000
```

Docs: [http://localhost:8000/docs](http://localhost:8000/docs)  
Cabecera requerida: `X-Groq-API-Key: gsk_tu_clave_aqui`

---

## 5. Ejecutar las pruebas de integración

Valida el ciclo completo (traducción con Llama → compilación con `javac` → ejecución políglota):

```bash
pytest tests/test_integration_polyglot.py -v
```

**Antes de ejecutar, confirma:**

- `GROQ_API_KEY` está configurada.
- `java` y `javac` apuntan a GraalVM (`java -version`).
- El componente Python de GraalVM está instalado (`gu list`).

---

## Checklist rápido

```bash
java -version                              # GraalVM
gu list                                    # python instalado
export GROQ_API_KEY="gsk_..."              # o .env
python -m venv .venv && source .venv/bin/activate
pip install -r config-env/requirements.txt && pip install groq pytest
pytest tests/test_integration_polyglot.py -v
```
