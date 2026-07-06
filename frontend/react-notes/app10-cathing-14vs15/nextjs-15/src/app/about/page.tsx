export const dynamic = "force-static";

export default async function About() {
  return (
    <div>
      About
      <h2>{new Date().toISOString()}</h2>
    </div>
  );
}
