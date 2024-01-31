const Button = ({ value, onClick, type }) => {
  let buttonClassName =
    "w-full py-4 rounded text-sm font-bold transition duration-200";

  switch (type) {
    case "primary":
      buttonClassName += " bg-indigo-600 hover:bg-indigo-700 text-gray-50";
      break;
    case "secondary":
      buttonClassName +=
        " bg-white border border-indigo-500 hover:bg-indigo-50 text-indigo-500";
      break;
    case "tertiary":
      buttonClassName += " bg-transparent text-gray-400 py-2";
      break;
    default:
    //   buttonClassName += " bg-indigo-600 hover:bg-indigo-700 text-gray-50";
  }

  return (
    <button className={buttonClassName} onClick={onClick}>
      {value}
    </button>
  );
};

export default Button;
