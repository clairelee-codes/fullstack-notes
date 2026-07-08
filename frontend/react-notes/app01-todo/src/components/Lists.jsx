import List from "./List";
import React from "react";
import { DragDropContext, Droppable, Draggable } from "@hello-pangea/dnd";

const Lists = React.memo(({ todoData, setTodoData, handleClick }) => {
  console.log("Lists");

  const handleEnd = (result) => {
    // console.log(result);
    if (!result.destination) return;

    const newTodoData = [...todoData];
    const [reorderedItem] = newTodoData.splice(result.source.index, 1);
    newTodoData.splice(result.destination.index, 0, reorderedItem);
    setTodoData(newTodoData);
    localStorage.setItem("todoData", JSON.stringify(newTodoData));
  };

  return (
    <div>
      <DragDropContext onDragEnd={handleEnd}>
        <Droppable droppableId="todo">
          {(provided) => (
            <div {...provided.droppableProps} ref={provided.innerRef}>
              {todoData.map((data, index) => (
                <Draggable
                  key={data.id}
                  draggableId={data.id.toString()}
                  index={index}
                >
                  {(provided, snapshot) => (
                    <div
                      key={data.id}
                      {...provided.draggableProps}
                      ref={provided.innerRef}
                      {...provided.dragHandleProps}
                    >
                      <List
                        // key={data.id}
                        title={data.title}
                        completed={data.completed}
                        id={data.id}
                        todoData={todoData}
                        setTodoData={setTodoData}
                        isDragging={snapshot.isDragging}
                        handleClick={handleClick}
                      />
                    </div>
                  )}
                </Draggable>
              ))}
              {provided.placeholder}
            </div>
          )}
        </Droppable>
      </DragDropContext>
    </div>
  );
});

export default Lists;
