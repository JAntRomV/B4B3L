import os
from fastapi import Header, HTTPException

def verify_groq_api_key(x_groq_api_key: str = Header(..., description="Clave de API de Groq válida (gsk_...)")) -> str:
    """Valida la estructura de la API key e inyecta la credencial en el entorno."""
    if not x_groq_api_key.startswith("gsk_"):
        raise HTTPException(
            status_code=401, 
            detail="La cabecera 'X-Groq-API-Key' provista no es una clave válida."
        )
    os.environ["GROQ_API_KEY"] = x_groq_api_key
    return x_groq_api_key