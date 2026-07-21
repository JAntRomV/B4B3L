import { useState } from "react";
import { LuEye, LuEyeOff } from "react-icons/lu";

/**
 * @param {{ value: string, onChange: (v: string) => void }} props
 */
export default function ApiKeyInput({ value, onChange }) {
  const [showKey, setShowKey] = useState(false);

  return (
    <div className="relative">
      <input
        id="api-key-input"
        type={showKey ? "text" : "password"}
        value={value}
        onChange={(e) => onChange(e.target.value)}
        placeholder="X-API-Key"
        autoComplete="off"
        className="
          bg-slate-50 border border-slate-200
          rounded-lg px-4 py-1.5 text-sm text-slate-800
          placeholder-slate-400 focus:border-indigo-500 focus:ring-1 focus:ring-indigo-500
          focus:bg-white outline-none transition-all
          w-48 pr-10 cursor-text
        "
      />
      <button
        type="button"
        aria-label={showKey ? "Ocultar API Key" : "Mostrar API Key"}
        onClick={() => setShowKey((prev) => !prev)}
        className="absolute right-3 top-1/2 -translate-y-1/2 text-slate-400 hover:text-indigo-600 transition-colors cursor-pointer flex items-center justify-center"
      >
        {showKey ? <LuEyeOff size={16} /> : <LuEye size={16} />}
      </button>
    </div>
  );
}

