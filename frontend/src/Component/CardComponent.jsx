const CardComponent = ({ event }) => {
    console.log("card component rendered");
  return (
    <div className="flex flex-col bg-blue-400 items-center justify-center p-4 rounded-lg shadow-md h-60 w-80 cursor-pointer">
      <img src="/image.png" alt="event.title" className="w-full h-40 object-cover rounded-md" />
      <h2 className="text-lg font-semibold mt-3">{event.title}</h2>
      <p>{event.description}</p>
    </div>
  );
};

export default CardComponent;