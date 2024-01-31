import React from "react";
import { useNavigate } from "react-router-dom";

const ListItem = ({ title, author, date, content, id }) => {
  const navigate = useNavigate();

  // const handlePostClick = () => {
  //   navigate(`/view/${encodeURIComponent(boardId)}`, {
  //     state: { title, author, content, boardId },
  //   });
  // };

  const handlePostClick = () => {
    navigate(`/view/${id}`);
  };

  return (
    <tr
      className="hover:bg-gray-50 border-b border-b-gray-100 cursor-pointer"
      onClick={handlePostClick}
    >
      <td className="px-4 py-4">{id}</td>
      <td className="px-4 py-4">{title}</td>
      <td className="px-4 py-4">{author}</td>
      <td className="px-4 py-4">{date}</td>
    </tr>
  );
};

export default ListItem;
