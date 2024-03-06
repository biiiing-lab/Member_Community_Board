import axios from "axios";
import React, { useState, useEffect } from "react";
import WriteEditor from "../components/WriteEditor";
import { useNavigate, useParams } from "react-router-dom";
// import { useLocation } from "react-router-dom";

const Edit = () => {
  const { id } = useParams();
  const [data, setData] = useState({});
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = () => {
      axios
        .get(`http://localhost:8080/api/boards/${id}`)
        .then((res) => {
          console.log("불러오기 성공!");
          setData(res.data);
          console.log(res.data);
          setIsLoading(false);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    fetchData();
  }, []);

  return (
    <>
      {isLoading ? (
        <h2>로딩 중 ... </h2>
      ) : (
        <WriteEditor
          type={"edit"}
          editTitle={data.title}
          editContent={data.content}
        />
      )}
    </>
  );
};

export default Edit;
