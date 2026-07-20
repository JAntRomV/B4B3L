import { useState, useRef, useCallback } from "react";
import { LuCloudUpload, LuFileCode, LuFolderArchive, LuX, LuCircleAlert } from "react-icons/lu";


const ALLOWED_EXTENSIONS = [".java", ".zip"];
const MAX_SIZE_MB = 50;

/**
 * Valida que el archivo tenga extensión permitida y no supere el tamaño máximo.
 * @param {File} file
 * @returns {{ valid: boolean, error: string|null }}
 */
function validateFile(file) {
  const ext = "." + file.name.split(".").pop().toLowerCase();
  if (!ALLOWED_EXTENSIONS.includes(ext)) {
    return {
      valid: false,
      error: `Extensión no permitida. Solo: ${ALLOWED_EXTENSIONS.join(", ")}`,
    };
  }
  if (file.size > MAX_SIZE_MB * 1024 * 1024) {
    return { valid: false, error: `El archivo supera los ${MAX_SIZE_MB} MB.` };
  }
  return { valid: true, error: null };
}

/** Formatea bytes a una representación legible (KB / MB). */
function formatSize(bytes) {
  if (bytes < 1024) return `${bytes} B`;
  if (bytes < 1024 * 1024) return `${(bytes / 1024).toFixed(1)} KB`;
  return `${(bytes / (1024 * 1024)).toFixed(2)} MB`;
}

/**
 * @param {{ onFileSelected: (file: File|null) => void }} props
 */
export default function FileDropzone({ onFileSelected }) {
  const [isDragging, setIsDragging] = useState(false);
  const [selectedFile, setSelectedFile] = useState(null);
  const [validationError, setValidationError] = useState(null);
  const inputRef = useRef(null);

  const handleFile = useCallback(
    (file) => {
      const { valid, error } = validateFile(file);
      if (!valid) {
        setValidationError(error);
        setSelectedFile(null);
        onFileSelected(null);
        return;
      }
      setValidationError(null);
      setSelectedFile(file);
      onFileSelected(file);
    },
    [onFileSelected],
  );

  // ── Eventos de arrastre ──────────────────────────────────────────────────

  const onDragEnter = (e) => {
    e.preventDefault();
    setIsDragging(true);
  };
  const onDragLeave = (e) => {
    e.preventDefault();
    setIsDragging(false);
  };
  const onDragOver = (e) => {
    e.preventDefault();
  };

  const onDrop = (e) => {
    e.preventDefault();
    setIsDragging(false);
    const file = e.dataTransfer.files?.[0];
    if (file) handleFile(file);
  };

  // ── Selección vía clic ───────────────────────────────────────────────────

  const onInputChange = (e) => {
    const file = e.target.files?.[0];
    if (file) handleFile(file);
    // Resetear el input para permitir volver a seleccionar el mismo archivo
    e.target.value = "";
  };

  const clearFile = () => {
    setSelectedFile(null);
    setValidationError(null);
    onFileSelected(null);
  };

  // ── Renderizado ──────────────────────────────────────────────────────────

  if (selectedFile) {
    const isZip = selectedFile.name.endsWith(".zip");
    return (
      <div className="border border-slate-200 rounded-xl p-5 bg-slate-50 flex items-center gap-4 shadow-sm">
        <div className="w-12 h-12 rounded-lg bg-indigo-50 flex items-center justify-center flex-shrink-0">
          {isZip ? (
            <LuFolderArchive className="text-2xl text-indigo-600" />
          ) : (
            <LuFileCode className="text-2xl text-indigo-600" />
          )}
        </div>
        <div className="flex-1 overflow-hidden">
          <p className="text-sm font-semibold text-slate-800 truncate">
            {selectedFile.name}
          </p>
          <p className="text-xs text-slate-500 font-medium">
            {formatSize(selectedFile.size)}
          </p>
        </div>
        <button
          type="button"
          onClick={clearFile}
          aria-label="Eliminar archivo seleccionado"
          className="text-slate-400 hover:text-red-500 hover:bg-slate-100 rounded-full p-2 transition-all cursor-pointer flex items-center justify-center"
        >
          <LuX className="text-lg" />
        </button>
      </div>
    );
  }

  return (
    <div className="space-y-2">
      {/* Zona de arrastre */}
      <div
        role="button"
        tabIndex={0}
        aria-label="Zona de carga de archivos"
        onClick={() => inputRef.current?.click()}
        onKeyDown={(e) => e.key === "Enter" && inputRef.current?.click()}
        onDragEnter={onDragEnter}
        onDragLeave={onDragLeave}
        onDragOver={onDragOver}
        onDrop={onDrop}
        className={`
          border-2 border-dashed rounded-xl p-12 cursor-pointer
          flex flex-col items-center justify-center gap-4
          transition-all duration-200 group
          ${
            isDragging
              ? "border-indigo-500 bg-indigo-50/30"
              : "border-slate-200 bg-slate-50/50 hover:border-indigo-500 hover:bg-indigo-50/10"
          }
        `}
      >
        <div
          className={`
            w-16 h-16 rounded-xl bg-white border border-slate-100 flex items-center justify-center shadow-xs
            transition-all duration-200
            ${isDragging ? "text-indigo-600 border-indigo-200" : "text-slate-400 group-hover:text-indigo-600 group-hover:border-indigo-100"}
          `}
        >
          <LuCloudUpload className="text-3xl" />
        </div>
        <div className="text-center">
          <p className="text-sm font-semibold text-slate-700">
            {isDragging
              ? "Suelta el archivo aquí"
              : "Arrastra archivos .java o .zip aquí"}
          </p>
          <p className="text-xs text-slate-500 mt-1">
            o haz clic para seleccionar - Máximo {MAX_SIZE_MB}MB
          </p>
        </div>
      </div>

      {/* Mensaje de error de validación */}
      {validationError && (
        <p className="text-xs font-semibold text-red-500 flex items-center gap-1.5 mt-2">
          <LuCircleAlert className="text-base" />
          {validationError}
        </p>
      )}

      {/* Input oculto */}
      <input
        ref={inputRef}
        type="file"
        accept=".java,.zip"
        className="hidden"
        onChange={onInputChange}
        aria-hidden="true"
      />
    </div>
  );
}

