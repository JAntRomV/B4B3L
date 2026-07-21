/**
 * @param {{ value: string, onChange: (v: string) => void }} props
 */

export default function CodeEditor({ value, onChange }) {
  return (
    <div className="bg-slate-50 border border-slate-200 rounded-xl p-4 min-h-96 relative shadow-inner focus-within:border-indigo-500 focus-within:ring-1 focus-within:ring-indigo-500 transition-all">
      <textarea
        id="code-editor-textarea"
        value={value}
        onChange={(e) => onChange(e.target.value)}
        placeholder={"// Pega tu código aquí..."}
        className="
          w-full h-full min-h-80 bg-transparent border-none
          focus:ring-0 text-sm font-mono text-slate-800
          resize-none placeholder-slate-400
          focus:outline-none
        "
        spellCheck={false}
        aria-label="Código fuente Java"
      />
      {/* Badge de lenguaje fuente */}
      <div className="absolute bottom-4 right-4 text-[10px] font-bold tracking-wider text-slate-500 bg-white border border-slate-200 px-3 py-1 rounded-full shadow-xs pointer-events-none">
        JAVA
      </div>
    </div>
  );
}
