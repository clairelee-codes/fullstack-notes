import React, { useState } from "react";

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
      <button type="submit">submit</button>
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
