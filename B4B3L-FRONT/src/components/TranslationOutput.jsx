import { useState } from "react";
import { useB4b3l } from "../context/B4b3lContext";
import {
  LuTerminal,
  LuSparkles,
  LuCode,
  LuCopy,
  LuCheck,
  LuFolderArchive,
  LuFileCode,
  LuDownload,
  LuCircleCheck,
  LuTriangleAlert,
} from "react-icons/lu";

// ─── Estado: Placeholder ──────────────────────────────────────────────────────

function PlaceholderState() {
  return (
    <div className="flex-1 flex flex-col items-center justify-center text-center space-y-4 py-12">
      <div className="w-20 h-20 rounded-2xl bg-slate-50 border border-slate-200/60 flex items-center justify-center text-slate-400">
        <LuTerminal className="text-3xl" />
      </div>
      <div>
        <h3 className="text-lg font-bold text-slate-800">Listo para traducir</h3>
        <p className="text-sm text-slate-500 max-w-xs mx-auto mt-1">
          Ingresa tu código fuente y haz clic en Traducir para ver el motor B4B3L en acción.
        </p>
      </div>
    </div>
  );
}

// ─── Estado: Loading ──────────────────────────────────────────────────────────

function LoadingState() {
  return (
    <div className="flex-1 flex flex-col items-center justify-center gap-6 py-12">
      {/* Modern Loader */}
      <div className="relative w-20 h-20 flex items-center justify-center">
        <div className="absolute inset-0 rounded-full border-4 border-slate-100" />
        <div className="absolute inset-0 rounded-full border-4 border-t-indigo-600 border-r-transparent border-b-transparent border-l-transparent animate-spin" />
        <LuSparkles className="text-indigo-600 text-3xl animate-pulse" />
      </div>
      <div className="text-center">
        <p className="text-lg font-bold text-slate-800">Procesando...</p>
        <p className="text-sm text-slate-500 mt-1">
          El motor B4B3L está analizando tu código fuente
        </p>
      </div>
      {/* Progress Bar */}
      <div className="w-64 h-1.5 bg-slate-100 rounded-full overflow-hidden">
        <div className="h-full bg-indigo-600 rounded-full w-1/2 animate-[indeterminate_1.5s_ease-in-out_infinite]" />
      </div>
    </div>
  );
}

// ─── Estado: Resultado de texto ───────────────────────────────────────────────

/** Mapa de lenguajes a etiqueta de badge */
const LANG_BADGE = {
  python:     "PYTHON 3.10+",
  javascript: "JAVASCRIPT ESNEXT",
  rust:       "RUST",
  go:         "GO",
};

/** Mapa de lenguajes a extensión de archivo de salida */
const LANG_EXT = {
  python:     "main.py",
  javascript: "main.js",
  rust:       "main.rs",
  go:         "main.go",
};

function TextResultState({ result }) {
  const [copied, setCopied] = useState(false);

  const translatedCode =
    typeof result?.translated_code === "string"
      ? result.translated_code
      : JSON.stringify(result, null, 2);

  const targetLang   = result?.target_language || "python";
  const tokensIn     = result?.tokens?.input  ?? result?.usage?.prompt_tokens     ?? "—";
  const tokensOut    = result?.tokens?.output ?? result?.usage?.completion_tokens  ?? "—";

  const handleCopy = async () => {
    try {
      await navigator.clipboard.writeText(translatedCode);
      setCopied(true);
      setTimeout(() => setCopied(false), 2000);
    } catch {
      // Fallback para navegadores sin permisos de clipboard
      const el = document.createElement("textarea");
      el.value = translatedCode;
      document.body.appendChild(el);
      el.select();
      document.execCommand("copy");
      document.body.removeChild(el);
      setCopied(true);
      setTimeout(() => setCopied(false), 2000);
    }
  };

  return (
    <div className="flex-1 flex flex-col space-y-4">
      {/* Header */}
      <div className="flex items-center justify-between">
        <h2 className="text-lg font-bold text-slate-800 flex items-center gap-2">
          <LuCode className="text-indigo-600 text-xl" />
          Vista Previa
        </h2>
        <button
          id="copy-result-btn"
          onClick={handleCopy}
          className="flex items-center gap-2 text-xs font-bold uppercase tracking-wider px-4 py-2 bg-white border border-slate-200 rounded-lg hover:bg-slate-50 transition-all text-slate-700 shadow-xs cursor-pointer active:scale-95"
        >
          {copied ? (
            <LuCheck className="text-base text-emerald-600" />
          ) : (
            <LuCopy className="text-base text-slate-400" />
          )}
          {copied ? "¡Copiado!" : "Copiar Resultado"}
        </button>
      </div>

      {/* Panel de código */}
      <div className="bg-slate-50 rounded-xl border border-slate-200 flex-1 overflow-hidden flex flex-col min-h-[400px] shadow-inner">
        {/* Barra de título del editor */}
        <div className="bg-white px-4 py-2.5 border-b border-slate-200 flex items-center justify-between">
          <span className="text-xs font-semibold text-slate-500">
            {LANG_EXT[targetLang] || "output.txt"}
          </span>
          <span className="text-xs font-bold text-indigo-600">
            {LANG_BADGE[targetLang] || targetLang.toUpperCase()}
          </span>
        </div>

        {/* Código */}
        <div
          id="output-code"
          className="p-4 flex-1 overflow-auto text-sm font-mono text-slate-800 scrollbar-thin whitespace-pre select-all bg-slate-50/50"
        >
          {translatedCode}
        </div>

        {/* Footer con tokens */}
        <div className="bg-white px-4 py-2.5 border-t border-slate-200 flex justify-between items-center text-xs font-medium text-slate-500">
          <span>
            Tokens: {tokensIn} (Entrada) / {tokensOut} (Salida)
          </span>
          <span className="flex items-center gap-1.5 font-semibold text-indigo-600">
            <span className="w-2.5 h-2.5 rounded-full bg-indigo-600 animate-pulse" />
            Motor B4B3L
          </span>
        </div>
      </div>
    </div>
  );
}

// ─── Estado: Resultado de archivo ─────────────────────────────────────────────

function FileResultState({ result }) {
  const { blob, fileName } = result;

  const handleDownload = () => {
    const url = URL.createObjectURL(blob);
    const a   = document.createElement("a");
    a.href     = url;
    a.download = fileName;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    // Liberar la URL objeto para evitar memory leaks
    setTimeout(() => URL.revokeObjectURL(url), 10_000);
  };

  const isZip    = fileName.endsWith(".zip");
  const sizeMB   = (blob.size / (1024 * 1024)).toFixed(2);
  const sizeLabel = blob.size < 1024 * 1024
    ? `${(blob.size / 1024).toFixed(1)} KB`
    : `${sizeMB} MB`;

  return (
    <div className="flex-1 flex flex-col items-center justify-center py-6">
      <div className="bg-slate-50/50 border border-slate-200 p-8 rounded-2xl max-w-sm w-full text-center space-y-6 shadow-sm">
        {/* Ícono de éxito */}
        <div className="w-16 h-16 bg-emerald-50 rounded-full flex items-center justify-center mx-auto text-emerald-600 animate-[pulse_2s_ease-in-out_1]">
          <LuCircleCheck className="text-3xl" />
        </div>

        <div>
          <h3 className="text-lg font-bold text-slate-800">Paquete Listo</h3>
          <p className="text-sm text-slate-500 mt-2">
            {isZip
              ? "Tu proyecto Java ha sido traducido y empaquetado con éxito."
              : "Tu archivo Java ha sido traducido con éxito."}
          </p>
        </div>

        {/* Tarjeta de archivo */}
        <div className="bg-white border border-slate-200 rounded-xl p-4 text-left flex items-center gap-3 shadow-xs">
          <div className="w-10 h-10 rounded-lg bg-indigo-50 flex items-center justify-center text-indigo-600 flex-shrink-0">
            {isZip ? <LuFolderArchive className="text-xl" /> : <LuFileCode className="text-xl" />}
          </div>
          <div className="overflow-hidden">
            <p className="text-sm font-semibold text-slate-800 truncate">{fileName}</p>
            <p className="text-xs text-slate-500 font-medium">{sizeLabel}</p>
          </div>
        </div>

        {/* Botón de descarga */}
        <button
          id="download-translation-btn"
          onClick={handleDownload}
          className="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-3 rounded-xl flex items-center justify-center gap-2 shadow-sm transition-all duration-200 cursor-pointer active:scale-95"
        >
          <LuDownload className="text-lg" />
          Descargar Traducción
        </button>
      </div>
    </div>
  );
}

// ─── Estado: Error ────────────────────────────────────────────────────────────

function ErrorState({ message, onDismiss }) {
  return (
    <div className="flex-1 flex flex-col items-center justify-center py-6">
      <div className="bg-red-50 border border-red-100 p-6 rounded-2xl max-w-md w-full space-y-4 shadow-sm">
        <div className="flex items-start gap-4">
          <LuTriangleAlert className="text-red-600 text-3xl flex-shrink-0 mt-0.5" />
          <div>
            <h4 className="text-lg font-bold text-red-800">Traducción Fallida</h4>
            <p className="text-sm text-red-700 mt-1">{message}</p>
          </div>
        </div>
        <div className="flex justify-end gap-3">
          <button
            id="dismiss-error-btn"
            onClick={onDismiss}
            className="px-4 py-2 text-xs font-semibold text-slate-600 hover:bg-slate-100 rounded-lg transition-colors cursor-pointer active:scale-95"
          >
            Cerrar
          </button>
        </div>
      </div>
    </div>
  );
}

// ─── Componente principal ─────────────────────────────────────────────────────

/**
 * TranslationOutput
 * Renderiza el panel derecho del dashboard según el estado de `uiState`
 * obtenido del contexto B4b3l.
 */
export default function TranslationOutput() {
  const { uiState, textResult, fileResult, error, reset } = useB4b3l();

  return (
    <section
      className="w-full flex flex-col bg-white rounded-2xl border border-slate-200 shadow-sm overflow-hidden"
      aria-label="Panel de resultados"
    >
      <div className="p-6 h-full flex flex-col justify-between flex-1">
        {uiState === "placeholder" && <PlaceholderState />}
        {uiState === "loading"     && <LoadingState />}
        {uiState === "results-text" && textResult && (
          <TextResultState result={textResult} />
        )}
        {uiState === "results-file" && fileResult && (
          <FileResultState result={fileResult} />
        )}
        {uiState === "error" && (
          <ErrorState
            message={error || "Ha ocurrido un error desconocido."}
            onDismiss={reset}
          />
        )}
      </div>
    </section>
  );
}

