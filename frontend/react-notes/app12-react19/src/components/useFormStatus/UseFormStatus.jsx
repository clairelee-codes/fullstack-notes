import React, { useState } from "react";
import { useFormStatus } from "react-dom";

// useFormStatus: 폼의 상태를 추적하는 데 사용되는 hook
const SubmitButton = () => {
  const { pending } = useFormStatus();
  // console.log(pending);

  return (
    <button type="submit" disabled={pending}>
      {pending ? "Submitting..." : "Submit"}
    </button>
  );
};

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
      <SubmitButton />
    </form>
  );
};

const UseFormStatus = () => {
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

export default UseFormStatus;
