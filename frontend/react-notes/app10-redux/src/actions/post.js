import axios from "axios";

export const fetchPosts = () =>
  // Thunk 미들웨어
  async function fethPostsThunk(dispatch, getState) {
    const response = await axios.get(
      "https://jsonplaceholder.typicode.com/posts",
    );
    console.log(response);
    // 리액트 컴포넌트 밖에서 dispatch 그냥은 사용못함. Thunk 미들웨어 사용해야함.
    dispatch({ type: "FETCH_POSTS", payload: response.data });
  };
