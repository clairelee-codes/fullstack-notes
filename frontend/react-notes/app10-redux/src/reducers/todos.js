// Sub Reducer
// todo를 위한 reducer 함수
const todos = (state = [], action) => {
  switch (action.type) {
    case "ADD_TODO":
      return [...state, action.text];
    case "DELETE_TODO":
      return state - 1;
    default:
      return state;
  }
};

export default todos;
