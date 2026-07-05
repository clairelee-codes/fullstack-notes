import { ReactNode, Suspense } from "react";
import wait from "../lib/wait";
import Link from "next/link";

export default function BoardLayout({
  children,
  boardList,
  comments,
  admin,
}: {
  children: ReactNode;
  boardList: ReactNode;
  comments: ReactNode;
  admin: ReactNode;
}) {
  const isAdmin = true;

  return (
    <>
      <nav>
        <Link href={"/board"}>Board</Link>{" "}
        <Link href={"/board/settings"}>Settings</Link>
      </nav>
      {isAdmin && admin}
      {children}
      {boardList}
      {comments}

      {/* <Suspense fallback={<h2>Loading BoardList..</h2>}>
        <BoardList />
      </Suspense>
      <Suspense fallback={<h2>Loading Comments..</h2>}>
        <Comments />
      </Suspense> */}
    </>
  );
}

// async function BoardList() {
//   await wait(3000);
//   return <h2>BoardList</h2>;
// }

// async function Comments() {
//   await wait(4000);
//   return <h2>Comments</h2>;
// }
