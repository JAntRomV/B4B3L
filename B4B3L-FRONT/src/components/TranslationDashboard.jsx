import { useState } from "react";
import ApiKeyInput from "./ApiKeyInput";
import TranslationForm from "./TranslationForm";
import TranslationOutput from "./TranslationOutput";
import {
  LuLanguages,
  LuLayoutDashboard,
  LuFileCode,
  LuServer,
  LuCopyright,
  LuGithub,
  LuSparkles,
} from "react-icons/lu";

export default function TranslationDashboard() {
  // El apiKey se gestiona aquí porque tanto el header (ApiKeyInput)
  // como el panel de formulario (TranslationForm → contexto) lo necesitan.
  const [apiKey, setApiKey] = useState("");

  return (
    <div className="min-h-screen flex flex-col bg-slate-50 text-slate-800 font-inter">
      {/* ── TopNavBar ──────────────────────────────────────────────────────── */}
      <header className="bg-white border-b border-slate-200 sticky top-0 z-50 shadow-xs">
        <div className="flex justify-between items-center w-full px-8 max-w-7xl mx-auto h-16">
          {/* Logo + Navegación */}
          <div className="flex items-center gap-8">
            <span className="text-xl font-extrabold text-indigo-600 tracking-tight flex items-center gap-2">
              <LuLanguages className="text-2xl" />
              B4B3L Traductor
            </span>
            <nav
              className="hidden md:flex items-center gap-3"
              aria-label="Navegación principal"
            >
              <a
                href="#"
                className="text-xs font-bold uppercase tracking-wider transition-all duration-200 cursor-pointer flex items-center gap-1.5 rounded-md px-3 py-1.5 bg-indigo-50/50 text-indigo-600"
              >
                <LuLayoutDashboard className="text-sm" />
                DASHBOARD
              </a>
              <a
                href="https://b4b3l.onrender.com/docs"
                target="_blank"
                rel="noopener noreferrer"
                className="text-xs font-bold uppercase tracking-wider transition-all duration-200 cursor-pointer flex items-center gap-1.5 rounded-md px-3 py-1.5 text-slate-500 hover:text-indigo-600 hover:bg-slate-50"
              >
                <LuFileCode className="text-sm" />
                API DOCS
              </a>
              <a
                href="https://github.com/JAntRomV/B4B3L"
                target="_blank"
                rel="noopener noreferrer"
                className="text-xs font-bold uppercase tracking-wider transition-all duration-200 cursor-pointer flex items-center gap-1.5 rounded-md px-3 py-1.5 text-slate-500 hover:text-indigo-600 hover:bg-slate-50"
              >
                <LuGithub className="text-sm" />
                REPO
              </a>
            </nav>
          </div>

          {/* Acciones del header */}
          <div className="flex items-center gap-4">
            {/* API Key Input — componente atómico */}
            <ApiKeyInput value={apiKey} onChange={setApiKey} />
          </div>
        </div>
      </header>

      {/* ── Main Content ───────────────────────────────────────────────────── */}
      <main className="flex-1 max-w-7xl w-full mx-auto px-8 py-8 flex flex-col gap-8">
        {/* Banner de Introducción y Descripción */}
        <section className="bg-white rounded-xl border border-slate-200 p-6 shadow-xs relative overflow-hidden">
          <div className="absolute top-0 right-0 -mt-4 -mr-4 w-32 h-32 bg-indigo-50/80 rounded-full blur-2xl pointer-events-none" />
          <div className="flex flex-col md:flex-row md:items-center justify-between gap-4 relative z-10">
            <div className="space-y-2 max-w-3xl">
              <div className="flex items-center gap-2"></div>
              <h1 className="text-xl font-bold text-slate-900 tracking-tight">
                Bienvenido a B4B3L
              </h1>
              <p className="text-sm text-slate-600 leading-relaxed text-justify">
                B4B3L es un motor especializado en la traducción y conversión
                automatizada de código escrito en <strong>Java</strong> hacia
                otros lenguajes de programación como <strong>Python</strong> y{" "}
                <strong>JavaScript</strong>. Permite ingresar código
                directamente en el editor o subir archivos individuales{" "}
                <code className="bg-slate-100 px-1.5 py-0.5 rounded text-indigo-600 font-mono text-xs font-semibold">
                  .java
                </code>{" "}
                o carpetas de archivos Java comprimidos en archivos tipo{" "}
                <code className="bg-slate-100 px-1.5 py-0.5 rounded text-indigo-600 font-mono text-xs font-semibold">
                  .zip
                </code>
                , soportando modalidades de traducción <em>Estándar</em> y{" "}
                <em>Políglota</em>. Para comenzar, ingresa la{" "}
                <strong>API key de un modelo de IA</strong> en el campo ubicado
                en la esquina superior derecha. Una vez configurada, estarás
                listo para comenzar.
              </p>
            </div>
            <div className="flex items-center gap-3 shrink-0">
              <a
                href="https://github.com/JAntRomV/B4B3L"
                target="_blank"
                rel="noopener noreferrer"
                className="inline-flex items-center gap-2 px-4 py-2 rounded-lg bg-slate-900 text-white text-xs font-semibold hover:bg-slate-800 transition-colors shadow-xs"
              >
                <LuGithub className="text-base" />
                Ver Repositorio
              </a>
            </div>
          </div>
        </section>

        {/* Panel izquierdo: Formulario de entrada | Panel derecho: Resultados */}
        <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
          <TranslationForm apiKey={apiKey} />
          <TranslationOutput />
        </div>
      </main>

      {/* ── Footer ─────────────────────────────────────────────────────────── */}
      <footer className="bg-white border-t border-slate-200 py-4 mt-auto">
        <div className="max-w-7xl mx-auto w-full px-8 flex flex-col sm:flex-row items-center justify-between text-xs font-semibold text-slate-500 gap-4">
          <div className="flex flex-col sm:flex-row gap-2 sm:gap-6 items-center">
            <span className="flex items-center gap-1.5 text-indigo-600 font-bold">
              <span className="w-2.5 h-2.5 bg-indigo-600 rounded-full animate-pulse" />
              SISTEMA EN LÍNEA
            </span>
            <a
              href="https://b4b3l.onrender.com"
              target="_blank"
              rel="noopener noreferrer"
              className="hover:text-indigo-600 cursor-pointer transition-colors flex items-center gap-1"
            >
              <LuServer className="text-sm" />
              API: b4b3l.onrender.com
            </a>
          </div>
          <div className="flex items-center gap-1.5">
            <LuCopyright className="text-sm text-slate-400" />
            <span>2026 B4B3L. ALL RIGHTS RESERVED.</span>
          </div>
        </div>
      </footer>
    </div>
  );
}
