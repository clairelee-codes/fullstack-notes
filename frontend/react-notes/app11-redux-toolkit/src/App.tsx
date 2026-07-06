import { useState } from "react"
import "./App.css"
import { Counter } from "./features/counter/Counter"
import Test from "./features/counter/test"

export function App() {
  const [isTestOpen, setIsTestOpen] = useState(true)
  return (
    <div className="App">
      <header className="App-header">
        <button onClick={() => setIsTestOpen(prev => !prev)}>Toggle</button>
        {isTestOpen && <Test />}
        <Counter />
      </header>
    </div>
  )
}
