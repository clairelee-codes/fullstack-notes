import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { applyMiddleware, createStore } from "redux";
import rootReducer from "./reducers";
import { Provider } from "react-redux";
import { loggerMiddleware } from "./middleware";

const root = ReactDOM.createRoot(document.getElementById("root"));

// 미들웨어 등록하기
const middleware = applyMiddleware(loggerMiddleware);
// redux store
const store = createStore(rootReducer, middleware);

// console.log(store.getState());

root.render(
  <React.StrictMode>
    {/* react redux package의 Privider로 리덕터 subscribe */}
    <Provider store={store}>
      <App
      // value={store.getState()}
      // onIncrement={() => store.dispatch({ type: "INCREMENT" })}
      // onDecrement={() => store.dispatch({ type: "DECREMENT" })}
      />
    </Provider>
  </React.StrictMode>,
);

// react redux package의 Privider 없이 리덕터 subscribe
// render();
// store.subscribe(render);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
