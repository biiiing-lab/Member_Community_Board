const TextInput = ({ placeholder }) => {
  return (
    <div>
      <input
        className="w-full p-4 text-sm bg-gray-50 focus:outline-none border border-gray-200 rounded text-gray-600"
        type="text"
        placeholder={placeholder}
      />
    </div>
  );
};

export default TextInput;
