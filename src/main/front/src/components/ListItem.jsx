import React from "react";
import { useNavigate } from "react-router-dom";

const ListItem = ({ title, author, view }) => {
  const navigate = useNavigate();

  const handlePostClick = () => {
    console.log("Clicked on post with title:", title, author, view);
    navigate(`/view/${encodeURIComponent(title)}`, { state: { title, author } });
  };

  return (
    <tr
      className="hover:bg-gray-50 border-b border-b-gray-100 cursor-pointer"
      onClick={handlePostClick}
    >
      <td className="px-4 py-4 flex items-center">{title}</td>
      <td className="px-4 py-4">{author}</td>
      <td className="px-4 py-4">{view}</td>
    </tr>
  );
};

export default ListItem;
