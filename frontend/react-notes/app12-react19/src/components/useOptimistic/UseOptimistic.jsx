import React, { useOptimistic, useState } from "react";

export function submitTitle(formData) {
  return new Promise((resolve, reject) => {
    const updatedTitle = formData.get("title");
    setTimeout(() => {
      const n = Math.random();
      if (n < 0.75) {
        resolve(updatedTitle);
      } else reject("Error");
    }, 5000);
  });
}

// useOptimistic
// 서버 요청이 처리되는 동안 예상되는 결과를 미리 반영하여,
// 사용자가 보다 매끄럽게 애플리케이션을 사용할 수 있도록 도움.
const UseOptimistic = () => {
  const [title, setTitle] = useState("title");
  const [optimisticTitle, setOptimisticTitle] = useOptimistic(title);
  const [error, setError] = useState(null);
  const pending = title !== optimisticTitle;

  const handleSubmit = async (formData) => {
    setError(null);
    setOptimisticTitle(formData.get("title"));
    try {
      const updatedTitle = await submitTitle(formData);
      setTitle(updatedTitle);
    } catch (e) {
      setError(e);
    }
  };
  return (
    <div>
      <h2>{optimisticTitle}</h2>
      <p>{pending && "Updaing..."}</p>
      <form action={handleSubmit}>
        <input type="text" name="title" />
        <button type="submit" disabled={pending}>
          Submit
        </button>
      </form>
      <div>{error && error}</div>
    </div>
  );
};

export default UseOptimistic;
