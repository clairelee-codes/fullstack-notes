import { combineReducers } from "redux";
import todos from "./todos";
import counter from "./counter";

// Sub Reducers 합치기
const rootReducer = combineReducers({
  todos: todos,
  counter: counter,
});

export default rootReducer;
