import React from "react";
import { useState } from "react";

const List = React.memo(
  ({
    title,
    completed,
    id,
    todoData,
    setTodoData,
    isDragging,
    handleClick,
  }) => {
    console.log("List");

    const [isEditing, setIsEditing] = useState(false);
    const [editedTitle, setEditedTitle] = useState(title);

    // const btnStyle = {
    //   color: "#fff",
    //   border: "none",
    //   padding: "5px 9px",
    //   borderRadius: "50%",
    //   cursor: "pointer",
    //   float: "right",
    // };

    // const getStyle = (completed) => {
    //   return {
    //     padding: "10px",
    //     borderBottom: "1px #ccc dotted",
    //     textDecoration: completed ? "line-through" : "none",
    //   };
    // };

    const handleCompleteChange = (id) => {
      let newTodoData = todoData.map((data) => {
        if (data.id === id) {
          // data.completed = !data.completed;  // ❌ 원본 직접 수정 : 불변성
          return { ...data, completed: !data.completed };
        }
        return data;
      });

      setTodoData(newTodoData);
      localStorage.setItem("todoData", JSON.stringify(newTodoData));
    };

    // const handleClick = (id) => {
    //   console.log(id);
    //   let newTodoData = todoData.filter((data) => data.id !== id);
    //   console.log(newTodoData);
    //   setTodoData(newTodoData);
    //   localStorage.setItem("todoData", JSON.stringify(newTodoData));
    // };

    const handleEditChange = (e) => {
      setEditedTitle(e.target.value);
    };

    const handleSubmit = (e) => {
      e.preventDefault();
      const newTodoData = todoData.map((data) => {
        if (data.id === id) {
          return { ...data, title: editedTitle };
        }
        return data;
      });
      setTodoData(newTodoData);
      localStorage.setItem("todoData", JSON.stringify(newTodoData));
      setIsEditing(false);
    };

    if (isEditing) {
      return (
        <form
          onSubmit={handleSubmit}
          className="flex items-center gap-2 w-full px-4 py-1 my-2 border rounded border-gray-200"
        >
          <input
            value={editedTitle}
            autoFocus
            onChange={handleEditChange}
            className="border-2 rounded pl-4"
          />
          <button
            type="button"
            onClick={() => setIsEditing(false)}
            className="px-4 py-2"
          >
            X
          </button>
          <button type="submit" className="py-2">
            Save
          </button>
        </form>
      );
    } else {
      return (
        <div
          className={`${isDragging ? "bg-gray-400" : "bg-gray-100"} flex items-center justify-between w-full px-4 py-1 my-2 text-gray-600 border rounded border-gray-200`}
        >
          <div className="items-center">
            <input
              type="checkbox"
              onChange={() => handleCompleteChange(id)}
              checked={completed}
              className="mr-1"
            />
            <span className={completed ? "line-through" : undefined}>
              {title}
            </span>
          </div>
          <div className="items-center">
            <button
              className="px-4 py-2 float-right"
              onClick={() => handleClick(id)}
            >
              X
            </button>
            <button
              className="px-4 py-2 float-right"
              onClick={() => setIsEditing(true)}
            >
              Edit
            </button>
          </div>
        </div>
      );
    }
  },
);

export default List;
