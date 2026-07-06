import Image from "next/image";

export default async function About() {
  return (
    <div>
      About
      <h2>{new Date().toISOString()}</h2>
    </div>
  );
}
