const TextInput = ({ placeholder, name, value, onChange, error }) => {
  return (
    <>
      <input
        className={`w-full mb-2 p-4 text-sm bg-gray-50 focus:outline-none border border-gray-200 rounded text-gray-600 ${
          error ? "border-red-500" : ""
        }`}
        type="text"
        name={name}
        value={value}
        placeholder={placeholder}
        onChange={onChange}
      />
      {error && <p className="text-red-500 text-xs">{error}</p>}
    </>
  );
};

export default TextInput;
