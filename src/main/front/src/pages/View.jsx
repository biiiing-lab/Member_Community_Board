import React, { useState, useEffect } from "react";
import Button from "../components/Button";
import axios from "axios";
import { useNavigate, useLocation, useParams } from "react-router-dom";
import ListItem from "../components/ListItem";

const View = () => {
  const navigate = useNavigate();
  // const location = useLocation();
  // const { data, author, content, postId } = location.state || {};

  // const [title, setTitle] = useState("");

  // useEffect(() => {
  //   if (location.state && location.state.title) {
  //     setTitle(location.state.title);
  //   }
  // }, [location.state]);

  // const handleButtonClick = () => {
  //   navigate(`/edit/${encodeURIComponent(postId)}`, {
  //     state: { title, author, content },
  //   });
  // };

  const { id } = useParams();
  console.log(id);
  const [data, setData] = useState([]);

  const fetchData = async () => {
    await axios
      .get(`http://localhost:4000/posts/${id}`)
      .then((res) => {
        console.log("불러오기 성공!");
        setData(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    fetchData();
    console.log(data);
  }, []);
  return (
    <>
      <div className="max-w-5xl mx-auto mt-10">
        <div className="text-2xl font-bold mb-5"></div>
        <form>
          <div className="mb-4 w-full rounded border border-gray-200 dark:bg-gray-700 dark:border-gray-600">
            <div className="flex justify-between items-center py-3 px-3 bg-gray-50 border-b dark:border-gray-600">
              <div className="text-2xl font-bold">{data.title}</div>
              <div className="text-gray-600">{data.date}</div>
            </div>
            <div className="py-20 px-4 rounded-b-lg bg-gray-50">
              {data.content}
            </div>
          </div>
          <div className="flex justify-end">
            {/* <div className="w-40 mx-2.5">
              <Button
                onClick={handleButtonClick}
                value={"게시글 수정하기"}
                type={"primary"}
              />
            </div>
            <div className="w-40">
              <Button
                onClick={handleButtonClick}
                value={"게시글 삭제하기"}
                type={"secondary"}
              />
            </div> */}
          </div>
        </form>
      </div>
      <ListItem data={data} />
    </>
  );
};

export default View;
