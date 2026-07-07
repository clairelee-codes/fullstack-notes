import { useEffect, useState } from "react";
import "./App.css";
import Use from "./components/use/Use";
import Action from "./components/action/Action";
import UseFormStatus from "./components/useFormStatus/UseFormStatus";
import UseActionState from "./components/useActionState/UseActionState";
import UseOptimistic from "./components/useOptimistic/UseOptimistic";

function App() {
  // "use memo";
  const [count, setCount] = useState(0);
  const [text, setText] = useState("");
  console.log("App is rendering");

  const aObject = { a: "a", text };

  useEffect(() => {
    console.log("useEffect Called");
  }, [aObject]);

  return (
    <>
      <button onClick={() => setCount((count) => count + 1)}>
        count is {count}
      </button>
      <input value={text} onChange={(e) => setText(e.target.value)} />
      <Text text={text} />
      {/* <Use />
      <Action /> 
      <UseFormStatus />
      <UseActionState />
      <UseOptimistic /> */}
    </>
  );
}

export default App;

// React Compiler 최적화 확인
// 불필요한 재렌더링 방지
const Text = ({ text }) => {
  console.log("Text is rendering");
  return <div>{text}</div>;
};
