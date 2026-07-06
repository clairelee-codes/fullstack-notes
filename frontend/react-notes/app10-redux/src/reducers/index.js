import { combineReducers } from "redux";
import todos from "./todos";
import counter from "./counter";
import posts from "./posts";

// Sub Reducers 합치기
const rootReducer = combineReducers({
  todos: todos,
  counter: counter,
  posts: posts,
});

export default rootReducer;
