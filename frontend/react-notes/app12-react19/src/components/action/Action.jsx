import React, { useState } from "react";

// onSubmit: 전통적인 방식
// action: React19의 새로운 방식
// 비교
// 1. e.preventDefault() 자동
// 2. FormData 자동 전달
// 3. 폼 자동 리셋
// 4. 비동기 처리

const PostForm = ({ addPost }) => {
  const formAction = async (formData) => {
    const newPost = {
      title: formData.get("title"),
    };
    await new Promise((resolve) => setTimeout(resolve, 1000));
    addPost(newPost);
  };

  // action
  return (
    <form action={formAction}>
      <input type="text" name="title" />
      <button type="submit">Submit</button>
    </form>
  );
};

const Action = () => {
  const [posts, setPosts] = useState([]);
  const addPost = (newPost) => {
    setPosts((posts) => [...posts, newPost]);
  };

  return (
    <div>
      <PostForm addPost={addPost} />
      {console.log(posts)}
      {posts.map((post, index) => {
        return <h2 key={index}>{post.title}</h2>;
      })}
    </div>
  );
};

export default Action;
