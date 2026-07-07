import React, { Suspense, useState } from "react";
import { use } from "react";
import { useEffect } from "react";

const getText = async () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      // console.log("getText 호출!");
      resolve("hello");
    }, 2000);
  });
};

const textPromise = getText();

const TextItem = () => {
  let trueOrNot = true;
  let text = "default text";
  // use는 if 안에 사용할 수 있음.
  if (trueOrNot) {
    // use hook 사용
    text = use(textPromise);
  }
  return <h2>{text}</h2>;
};

// useEffect는 먼저 렌더링 후에 작동하지만(그래서 렌더링을 block 하지는 X)
// use는 데이터를 받아오기까지 렌더링을 지연시킴

const Use = () => {
  return (
    <Suspense fallback="loading">
      <TextItem />
    </Suspense>
  );
};

export default Use;

// 기존 방법 (useEffect)
// const TextItem = ({ text }) => {
//   return <h2>{text}</h2>;
// };

// const Use = () => {
//   const [text, setText] = useState("");
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     const fetchText = async () => {
//       try {
//         const text = await getText();
//         setText(text);
//         setLoading(false);
//       } catch (error) {
//         console.error(error);
//       } finally {
//         setLoading(false);
//       }
//     };

//     fetchText();
//   }, []);

//   if (loading) return <h2>Loading...</h2>;
//   return <TextItem text={text} />;
// };
