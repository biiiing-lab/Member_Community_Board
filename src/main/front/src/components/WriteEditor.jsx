import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./Button";

const WriteEditor = ({ type, editTitle, editContent }) => {
  console.log(editTitle, editContent);
  const navigate = useNavigate();
  const [title, setTitle] = useState(editTitle);
  const [content, setContent] = useState(editContent);

  console.log(title, content);

  const handleTitleChange = (e) => {
    setTitle(e.target.value);
  };

  const handleContentChange = (e) => {
    setContent(e.target.value);
  };

  const handleButtonClick = () => {
    navigate("/");
  };

  return (
    <div className="max-w-5xl mx-auto mt-10">
      <div className="text-2xl font-bold mb-5">
        {type === "write" ? "게시글 작성" : "게시글 수정"}
      </div>
      <form>
        <div className="mb-4 w-full rounded border border-gray-200 dark:bg-gray-700 dark:border-gray-600">
          <div className="flex justify-between items-center py-2 px-3 bg-gray-50 border-b dark:border-gray-600">
            <input
              className="w-full p-2 text-xl bg-gray-50"
              placeholder="제목을 입력 해주세요"
              value={title}
              onChange={handleTitleChange}
              required
            />
          </div>
          <div className="py-2 px-4 rounded-b-lg bg-gray-50">
            <textarea
              rows="20"
              className="block p-2 w-full text-sm text-gray-800 bg-gray-50 border-0 "
              placeholder="글을 입력해주세요"
              value={content}
              onChange={handleContentChange}
              required
            />
          </div>
        </div>
        <div className="w-40 ml-auto">
          <Button
            onClick={handleButtonClick}
            value={type === "write" ? "게시물 업로드" : "게시글 수정하기"}
            type={"primary"}
          />
        </div>
      </form>
    </div>
  );
};

export default WriteEditor;
