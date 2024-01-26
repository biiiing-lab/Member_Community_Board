const ListItem = ({ title, author, view }) => {
  return (
    <>
      <tr className="hover:bg-gray-50 border-b border-b-gray-100	 cursor-pointer">
        <td className="px-4 py-4 flex items-center">{title}</td>
        <td className="px-4 py-4">{author}</td>
        <td className="px-4 py-4">{view}</td>
      </tr>
    </>
  );
};

export default ListItem;
