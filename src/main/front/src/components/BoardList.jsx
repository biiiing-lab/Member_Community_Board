import React, { useState, useEffect } from "react";
import axios from "axios";
import ListItem from "./ListItem";

const BoardList = () => {
  // const data = [
  //   { title: "title1", author: "sdsdf1", view: "dsfsdf1", content: "본문내용" },
  //   { title: "title2", author: "sdsdf2", view: "dsfsdf2", content: "본문내용2" },
  //   { title: "title3", author: "sdsdf3", view: "dsfsdf3", content: "본문내용3" },
  //   { title: "title4", author: "sdsdf4", view: "dsfsdf4", content: "본문내용4" },
  //   { title: "title5", author: "sdsdf5", view: "dsfsdf5", content: "본문내용5" },
  // ];

  // let postId = 1;

  // const newData = data.map((item) => ({
  //   ...item,
  //   postId: postId++
  // }));

  const [data, setData] = useState([]);

  const fetchData = async () => {
    await axios
      .get(`http://localhost:4000/posts`)
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
  }, []);
  return (
    <>
      <table className="table-auto border-collapse w-full">
        <thead>
          <tr
            className="w-full rounded text-sm font-medium text-gray-700 text-left border-t-2 border-b"
            style={{ fontSize: "0.9674rem" }}
          >
            <th className="w-3/4 px-4 py-2">
              <p className="w-100">제목</p>
            </th>
            <th className="px-4 py-2">작성자</th>
            <th className=" px-4">작성일</th>
          </tr>
        </thead>
        <tbody className="text-sm font-normal text-gray-700">
          {/* {newData.map((item, index) => (
            <ListItem key={index} {...item} author={item.author} />
          ))} */}
          {data.map((item, index) => (
            <ListItem
              key={index}
              {...item}
              author={item.writer}
              date={item.modDate ? item.modDate : item.regDate}
              id={item.id}
            />
          ))}
        </tbody>
      </table>
    </>
  );
};

export default BoardList;
