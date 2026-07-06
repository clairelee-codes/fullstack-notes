import { useEffect, useState } from "react";
import "./App.css";
import { useDispatch, useSelector } from "react-redux";
import axios from "axios";

function App(/*{ value, onIncrement, onDecrement }*/) {
  const counter = useSelector((state) => state.counter);
  const todos = useSelector((state) => state.todos);
  const posts = useSelector((state) => state.posts);
  // console.log(counter);
  const dispatch = useDispatch();

  const [todoValue, setTodoValue] = useState("");

  useEffect(() => {
    fetchPaths();
  }, []);

  async function fetchPaths() {
    const response = await axios.get(
      "https://jsonplaceholder.typicode.com/posts",
    );
    console.log(response);
    dispatch({ type: "FETCH_POSTS", payload: response.data });
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch({ type: "ADD_TODO", text: todoValue });
  };
  const hadnleIncrement = () => {
    dispatch({ type: "INCREMENT" });
  };
  const hadnleDecrement = () => {
    dispatch({ type: "DECREMENT" });
  };

  return (
    <div className="App">
      <div>
        <ul>
          {posts.map((post) => (
            <li key={post.id}>{post.title}</li>
          ))}
        </ul>
      </div>
      <div>
        <ul>
          {todos.map((todo, index) => (
            <li key={index}>{todo}</li>
          ))}
        </ul>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            value={todoValue}
            onChange={(e) => setTodoValue(e.target.value)}
          />
          <input type="submit" />
        </form>
      </div>
      <div>
        Clicked: {counter} times <button onClick={hadnleIncrement}>+</button>{" "}
        <button onClick={hadnleDecrement}>-</button>
      </div>
    </div>
  );
}

export default App;
