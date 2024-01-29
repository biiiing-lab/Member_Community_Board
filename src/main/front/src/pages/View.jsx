import React, { useState, useEffect } from "react";
import Button from "../components/Button";
import { useNavigate, useLocation } from "react-router-dom";
import ListItem from "../components/ListItem";

const View = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const { data, author, content, postId } = location.state || {};

  const [title, setTitle] = useState("");

  useEffect(() => {
    if (location.state && location.state.title) {
      setTitle(location.state.title);
    }
  }, [location.state]);

  const handleButtonClick = () => {
    navigate(`/edit/${encodeURIComponent(postId)}`, { state: { title, author, content } });
  };

  return (
    <>
      <div className="max-w-5xl mx-auto mt-10">
        <div className="text-2xl font-bold mb-5"></div>
        <form>
          <div className="mb-4 w-full rounded border border-gray-200 dark:bg-gray-700 dark:border-gray-600">
            <div className="flex justify-between items-center py-3 px-3 bg-gray-50 border-b dark:border-gray-600">
              <div className="text-2xl font-bold">{title}</div>
              <div className="text-gray-600">작성자: {author}</div>
            </div>
            <div className="py-20 px-4 rounded-b-lg bg-gray-50">
              {content}
            </div>
          </div>
          <div className="w-40 ml-auto">
            <Button
              onClick={handleButtonClick}
              value={"게시글 수정하기"}
              type={"primary"}
            />
          </div>
        </form>
      </div>
      <ListItem data={data} />
    </>
  );
};

export default View;