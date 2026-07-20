import { B4b3lProvider } from "./context/B4b3lContext";
import TranslationDashboard from "./components/TranslationDashboard";

export default function App() {
  return (
    <B4b3lProvider>
      <TranslationDashboard />
    </B4b3lProvider>
  );
}
