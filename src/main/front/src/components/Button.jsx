const Button = ({ value, onClick }) => {
  return (
    <button
      className="w-full py-4 bg-emerald-400 hover:bg-emerald-500 rounded text-sm font-bold text-gray-50 transition duration-200"
      onClick={onClick}
    >
      {value}
    </button>
  );
};

export default Button;
