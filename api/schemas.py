from pydantic import BaseModel, Field

class TranslationRequest(BaseModel):
    code: str = Field(..., description="Código fuente Java a traducir")
    target_language: str = Field(..., description="Lenguaje destino ('python' o 'javascript')")
    mode: str = Field("standard", description="Modo de traducción: 'standard' o 'polyglot'")