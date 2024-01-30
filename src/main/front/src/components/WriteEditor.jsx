import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./Button";
import axios from "axios";

const WriteEditor = ({ type, title: initialTitle, content: initialContent }) => {
  const navigate = useNavigate();
  const [title, setTitle] = useState(initialTitle || "");
  const [content, setContent] = useState(initialContent || "");


  const handleTitleChange = (e) => {
    setTitle(e.target.value);
  };

  const handleContentChange = (e) => {
    setContent(e.target.value);
  };

  const handleButtonClick = () => {
    if (type === "write") {
      axios.get("http://localhost:4000/posts")
        .then(response => {
          const idNumber = response.data;
          const nextId = (parseInt(idNumber[idNumber.length - 1].id) + 1).toString();
          const postData = { id: nextId, title, content };

          axios.post("http://localhost:4000/posts", postData)
            .then((res) => {
              navigate("/", { replace: true });
            })
            .catch((error) => {
              console.error(error);
            });
        })
        .catch(error => {
          console.error(error);
        });
    }
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
