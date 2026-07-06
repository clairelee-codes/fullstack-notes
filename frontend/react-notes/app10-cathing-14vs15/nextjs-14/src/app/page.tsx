import Image from "next/image";

export default async function Home() {
  const response = await fetch("http://localhost:3000/api/time");
  const { time } = await response.json();

  return (
    <div>
      Home
      <h2>{time}</h2>
    </div>
  );
}
