import { useState } from "react";
import "./App.css";
import Use from "./components/use/Use";
import Action from "./components/action/Action";
import UseFormStatus from "./components/useFormStatus/UseFormStatus";
import UseActionState from "./components/useActionState/UseActionState";
import UseOptimistic from "./components/useOptimistic/UseOptimistic";

function App() {
  return (
    // <Use />
    // <Action />
    // <UseFormStatus />
    // <UseActionState />
    <UseOptimistic />
  );
}

export default App;
