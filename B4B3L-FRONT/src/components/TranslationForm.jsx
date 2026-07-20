import { useState } from "react";
import { useB4b3l } from "../context/B4b3lContext";
import CodeEditor from "./CodeEditor";
import FileDropzone from "./FileDropzone";
import { LuCode, LuFileUp, LuSparkles, LuTriangleAlert } from "react-icons/lu";

// ─── Opciones de configuración ────────────────────────────────────────────────

const LANGUAGES = [
  { value: "python", label: "Python" },
  { value: "javascript", label: "JavaScript" },
];

const MODES = [
  { value: "standard", label: "Estándar" },
  { value: "polyglot", label: "Políglota" },
];

// ─── Sub-componente: Selector de modo (radio groups) ─────────────────────────

function ModeSelector({ value, onChange }) {
  return (
    <div className="flex gap-2 p-1 bg-slate-100 rounded-lg">
      {MODES.map((mode) => (
        <label
          key={mode.value}
          className={`flex-1 flex items-center justify-center gap-2 cursor-pointer py-1.5 rounded-md transition-all duration-200 ${
            value === mode.value
              ? "bg-white shadow-xs text-indigo-600 font-semibold"
              : "text-slate-500 hover:text-slate-800"
          }`}
        >
          <input
            type="radio"
            name="translation-mode"
            value={mode.value}
            checked={value === mode.value}
            onChange={(e) => onChange(e.target.value)}
            className="hidden"
          />
          <span
            className={`w-2.5 h-2.5 rounded-full border transition-all ${
              value === mode.value
                ? "bg-indigo-600 border-indigo-600 scale-110 shadow-xs"
                : "border-slate-300 bg-transparent"
            }`}
          />
          <span className="text-xs uppercase tracking-wider">{mode.label}</span>
        </label>
      ))}
    </div>
  );
}

// ─── Componente principal ─────────────────────────────────────────────────────

/**
 * @param {{ apiKey: string }} props
 *   apiKey — El token X-API-Key gestionado por el padre (TranslationDashboard).
 */
export default function TranslationForm({ apiKey }) {
  const { submitTextTranslation, submitFileTranslation, loading } = useB4b3l();

  // Estado local del formulario
  const [activeTab, setActiveTab] = useState("text");
  const [sourceCode, setSourceCode] = useState("");
  const [selectedFile, setSelectedFile] = useState(null);
  const [targetLanguage, setTargetLanguage] = useState("python");
  const [translationMode, setTranslationMode] = useState("standard");
  const [localError, setLocalError] = useState(null);

  // ── Validación y submit ────────────────────────────────────────────────────

  const handleSubmit = async () => {
    setLocalError(null);

    if (!apiKey || apiKey.trim().length < 5) {
      setLocalError("Ingresa un X-API-Key válido (mínimo 5 caracteres).");
      return;
    }

    if (activeTab === "text") {
      if (!sourceCode.trim()) {
        setLocalError("El área de código no puede estar vacía.");
        return;
      }
      await submitTextTranslation(apiKey.trim(), {
        code: sourceCode,
        target_language: targetLanguage,
        mode: translationMode,
      });
    } else {
      if (!selectedFile) {
        setLocalError("Selecciona un archivo .java o .zip para traducir.");
        return;
      }
      await submitFileTranslation(
        apiKey.trim(),
        selectedFile,
        targetLanguage,
        translationMode,
      );
    }
  };

  // ── Renderizado ────────────────────────────────────────────────────────────

  return (
    <section
      className="w-full flex flex-col bg-white rounded-2xl border border-slate-200 shadow-sm overflow-hidden"
      aria-label="Panel de entrada"
    >
      <div className="p-6 space-y-6 flex-1 flex flex-col justify-between">
        <div className="space-y-6">
          {/* Header + Tabs */}
          <div className="flex items-center justify-between">
            <h2 className="text-lg font-bold text-slate-800 flex items-center gap-2">
              <LuCode className="text-indigo-600 text-xl" />
              Código Fuente
            </h2>

            {/* Selector de pestaña */}
            <div
              className="flex bg-slate-100 rounded-lg p-1 gap-1"
              role="tablist"
            >
              {[
                { id: "text", label: "TEXTO" },
                { id: "file", label: "ARCHIVO" },
              ].map((tab) => (
                <button
                  key={tab.id}
                  role="tab"
                  aria-selected={activeTab === tab.id}
                  id={`tab-${tab.id}`}
                  onClick={() => setActiveTab(tab.id)}
                  className={`
                    px-4 py-1.5 rounded-md text-xs font-bold uppercase tracking-wider transition-all flex items-center gap-1.5 cursor-pointer
                    ${
                      activeTab === tab.id
                        ? "bg-white text-slate-800 shadow-sm border border-slate-200/50"
                        : "text-slate-500 hover:text-slate-800 hover:bg-slate-50/50"
                    }
                  `}
                >
                  {tab.id === "text" ? (
                    <LuCode className="text-sm" />
                  ) : (
                    <LuFileUp className="text-sm" />
                  )}
                  {tab.label}
                </button>
              ))}
            </div>
          </div>

          {/* Panel de código o dropzone según la pestaña activa */}
          {activeTab === "text" ? (
            <CodeEditor value={sourceCode} onChange={setSourceCode} />
          ) : (
            <FileDropzone onFileSelected={setSelectedFile} />
          )}

          {/* Configuración de traducción */}
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6 pt-2">
            {/* Selector de lenguaje destino */}
            <div className="space-y-2">
              <label
                htmlFor="target-language-select"
                className="text-xs font-bold text-slate-500 uppercase tracking-wider block"
              >
                Lenguaje Destino
              </label>
              <select
                id="target-language-select"
                value={targetLanguage}
                onChange={(e) => setTargetLanguage(e.target.value)}
                className="
                  w-full bg-white border border-slate-200
                  rounded-lg px-4 py-2.5 focus:border-indigo-500 focus:ring-1 focus:ring-indigo-500 outline-none
                  text-sm text-slate-800 transition-colors cursor-pointer
                "
              >
                {LANGUAGES.map((lang) => (
                  <option key={lang.value} value={lang.value}>
                    {lang.label}
                  </option>
                ))}
              </select>
            </div>

            {/* Selector de modo */}
            <div className="space-y-2">
              <span className="text-xs font-bold text-slate-500 uppercase tracking-wider block">
                Modo de Traducción
              </span>
              <ModeSelector
                value={translationMode}
                onChange={setTranslationMode}
              />
            </div>
          </div>
        </div>

        <div className="space-y-4 pt-6">
          {/* Error de validación local */}
          {localError && (
            <div className="flex items-center gap-2 text-xs font-semibold text-red-600 bg-red-50 border border-red-100 rounded-lg px-4 py-3">
              <LuTriangleAlert className="text-base" />
              {localError}
            </div>
          )}

          {/* Botón de traducción */}
          <button
            id="translate-submit-btn"
            onClick={handleSubmit}
            disabled={loading}
            className="
              w-full bg-indigo-600 hover:bg-indigo-700 text-white font-semibold
              py-4 rounded-xl flex items-center justify-center gap-2 shadow-sm
              transition-all duration-200 cursor-pointer disabled:bg-slate-100
              disabled:text-slate-400 disabled:cursor-not-allowed active:scale-[0.98]
            "
          >
            <LuSparkles className={loading ? "animate-pulse" : ""} />
            <span>{loading ? "Procesando..." : "Traducir"}</span>
            {loading && <div className="loading-spinner ml-2" />}
          </button>
        </div>
      </div>
    </section>
  );
}
