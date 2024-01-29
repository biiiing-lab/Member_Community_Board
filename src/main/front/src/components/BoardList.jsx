import React from "react";
import ListItem from "./ListItem";

const BoardList = () => {
  const data = [
    { title: "title1", author: "sdsdf1", view: "dsfsdf1", content: "본문내용" },
    { title: "title2", author: "sdsdf2", view: "dsfsdf2", content: "본문내용2" },
    { title: "title3", author: "sdsdf3", view: "dsfsdf3", content: "본문내용3" },
    { title: "title4", author: "sdsdf4", view: "dsfsdf4", content: "본문내용4" },
    { title: "title5", author: "sdsdf5", view: "dsfsdf5", content: "본문내용5" },
  ];

  let postId = 1;

  const newData = data.map((item) => ({
    ...item,
    postId: postId++
  }));

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
            <th className="w-1/6 px-4 py-2">작성자</th>
            <th className="w-1/6 px-4">조회수</th>
          </tr>
        </thead>
        <tbody className="text-sm font-normal text-gray-700">
          {newData.map((item, index) => (
            <ListItem key={index} {...item} author={item.author} />
          ))}
        </tbody>
      </table>
    </>
  );
};

export default BoardList;
