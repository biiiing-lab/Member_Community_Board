import React, { useState, useEffect } from "react";
import Button from "../components/Button";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import ListItem from "../components/ListItem";

const View = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [data, setData] = useState([]);

  useEffect(() => {
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

    fetchData();
  }, [id]);

  const onEditButtonClick = () => {
    console.log(id);
    navigate(`/edit/${id}`);
  };
  const onDeleteButtonClick = async () => {
    await axios
      .delete(`http://localhost:4000/posts/${id}`)
      .then((res) => {
        console.log("삭제성공!");
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <>
      <div className="max-w-5xl mx-auto mt-10">
        <div className="flex justify-between	">
          <div className="w-20 mb-4">
            <Button
              onClick={() => navigate("/")}
              value={
                <div className="flex">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke-width="1.5"
                    stroke="currentColor"
                    class="w-5 h-5"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      d="M15.75 19.5 8.25 12l7.5-7.5"
                    />
                  </svg>
                  이전으로
                </div>
              }
              type={"tertiary"}
            />
          </div>
          <div className="flex justify-end">
            <div className="w-20 mx-2.5">
              <Button
                onClick={onEditButtonClick}
                value={"수정하기"}
                type={"primary"}
              />
            </div>
            <div className="w-20">
              <Button
                onClick={onDeleteButtonClick}
                value={"삭제하기"}
                type={"secondary"}
              />
            </div>
          </div>
        </div>
        <div className="text-2xl font-bold mb-2 border border-indigo-400"></div>
        <form>
          <div className="mb-4 w-full rounded">
            <div className="flex flex-col	p-3 border-b dark:border-gray-600">
              <div className="mb-2 text-2xl font-bold">{data.title}</div>
              <div className="mb-2 flex">
                <div className="text-gray-400 text-sm">{data.writer} |</div>
                <div className="text-gray-400 text-sm ml-1">{data.regDate}</div>
                {data.modDate ? (
                  <div className="text-gray-400 text-sm ml-1">
                    | 마지막 수정 날짜: {data.modDate}
                  </div>
                ) : (
                  ""
                )}
              </div>
            </div>
            <div className="pt-10 pb-40 px-4 rounded-b-lg border-b dark:border-gray-600">
              {data.content}
            </div>
            {/* <div className="py-4 px-4 rounded-b-lg border-b dark:border-gray-600">
              이전글 {data.title}
            </div>
            <div className="py-4 px-4 rounded-b-lg border-b dark:border-gray-600">
              다음글 {data.title}
            </div> */}
          </div>
        </form>
      </div>
      <ListItem data={data} />
    </>
  );
};

export default View;
