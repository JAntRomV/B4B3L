/**
 * B4b3lContext.jsx
 * ─────────────────────────────────────────────────────────────────────────────
 * Responsabilidad única: Capa de servicio y estado global de la aplicación.
 *
 * - Instancia centralizada de Axios apuntando a la API de producción.
 * - Funciones asíncronas puras para cada endpoint (texto y archivo).
 * - Context Provider que expone estados reactivos y acciones a toda la app.
 * - Custom hook `useB4b3l` como única interfaz de consumo.
 * ─────────────────────────────────────────────────────────────────────────────
 */

import { createContext, useContext, useState, useCallback } from "react";
import axios from "axios";

// ─── Instancia de Axios ───────────────────────────────────────────────────────

const apiClient = axios.create({
  baseURL: "https://b4b3l.onrender.com",
  timeout: 60000, // 60 s — el servidor puede tardar en despertar (Render free tier)
});

// ─── Funciones de servicio puras ──────────────────────────────────────────────

/**
 * translateText
 * Traduce código Java enviado como texto plano.
 *
 * @param {string} apiKey           - Token X-API-Key del usuario.
 * @param {{ code: string, target_language: string, mode: string }} payload
 * @returns {Promise<object>}       - Respuesta JSON de la API.
 */
async function translateText(apiKey, { code, target_language, mode }) {
  const response = await apiClient.post(
    "/api/v1/translate/text",
    { code, target_language, mode },
    { headers: { "X-API-Key": apiKey } }
  );
  return response.data;
}

/**
 * translateFile
 * Traduce un archivo .java o un ZIP con múltiples archivos.
 * La respuesta siempre se trata como BLOB para soportar descarga binaria.
 *
 * @param {string} apiKey           - Token X-API-Key del usuario.
 * @param {File}   file             - Archivo seleccionado por el usuario.
 * @param {string} target_language  - Lenguaje destino.
 * @param {string} mode             - Modo de traducción ('standard' | 'polyglot').
 * @returns {Promise<{ blob: Blob, fileName: string }>}
 */
async function translateFile(apiKey, file, target_language, mode) {
  const formData = new FormData();
  formData.append("file", file);

  const response = await apiClient.post("/api/v1/translate/file", formData, {
    headers: {
      "X-API-Key": apiKey,
      "Content-Type": "multipart/form-data",
    },
    params: { target_language, mode },
    responseType: "blob", // ← obligatorio para manejar binarios / ZIPs
  });

  // Intentar extraer el nombre del archivo de la cabecera Content-Disposition
  const disposition = response.headers["content-disposition"] || "";
  const match = disposition.match(/filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/);
  const fileName = match
    ? match[1].replace(/['"]/g, "")
    : `translated_${file.name}`;

  return { blob: response.data, fileName };
}

// ─── Contexto ─────────────────────────────────────────────────────────────────

const B4b3lContext = createContext(null);

/**
 * B4b3lProvider
 * Provee el estado global y las acciones de traducción a toda la aplicación.
 */
export function B4b3lProvider({ children }) {
  const [loading, setLoading]       = useState(false);
  const [error, setError]           = useState(null);       // string | null
  const [textResult, setTextResult] = useState(null);       // objeto de la API | null
  const [fileResult, setFileResult] = useState(null);       // { blob, fileName } | null
  const [uiState, setUiState]       = useState("placeholder"); // placeholder | loading | results-text | results-file | error

  /** Limpia todos los resultados y errores previos */
  const reset = useCallback(() => {
    setError(null);
    setTextResult(null);
    setFileResult(null);
    setUiState("placeholder");
  }, []);

  /**
   * submitTextTranslation
   * Orquesta la llamada al servicio de texto y actualiza el estado global.
   */
  const submitTextTranslation = useCallback(async (apiKey, payload) => {
    reset();
    setLoading(true);
    setUiState("loading");
    try {
      const result = await translateText(apiKey, payload);
      setTextResult(result);
      setUiState("results-text");
    } catch (err) {
      const message =
        err.response?.data?.detail ||
        err.response?.data?.message ||
        err.message ||
        "Error desconocido";
      setError(message);
      setUiState("error");
    } finally {
      setLoading(false);
    }
  }, [reset]);

  /**
   * submitFileTranslation
   * Orquesta la llamada al servicio de archivo y actualiza el estado global.
   */
  const submitFileTranslation = useCallback(async (apiKey, file, target_language, mode) => {
    reset();
    setLoading(true);
    setUiState("loading");
    try {
      const result = await translateFile(apiKey, file, target_language, mode);
      setFileResult(result);
      setUiState("results-file");
    } catch (err) {
      const message =
        err.response?.data?.detail ||
        err.response?.data?.message ||
        err.message ||
        "Error desconocido";
      setError(message);
      setUiState("error");
    } finally {
      setLoading(false);
    }
  }, [reset]);

  const value = {
    // Estado
    loading,
    error,
    textResult,
    fileResult,
    uiState,
    // Acciones
    submitTextTranslation,
    submitFileTranslation,
    reset,
  };

  return (
    <B4b3lContext.Provider value={value}>
      {children}
    </B4b3lContext.Provider>
  );
}

/**
 * useB4b3l
 * Custom hook — única interfaz de consumo del contexto B4B3L.
 * Lanza un error descriptivo si se usa fuera del Provider.
 */
export function useB4b3l() {
  const ctx = useContext(B4b3lContext);
  if (!ctx) {
    throw new Error("useB4b3l must be used within a <B4b3lProvider>");
  }
  return ctx;
}
