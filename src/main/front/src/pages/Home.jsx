import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import TextInput from "../components/TextInput";
import BoardList from "../components/BoardList";

const Home = () => {
  const [inputValue, setInputValue] = useState("");
  const navigate = useNavigate();

  const onClickWrite = () => {
    console.log("함수 실행!");
    navigate("/write");
  };

  const handleEnter = async (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
      // await axios
      //   // .get(`/api/boards`)
      //   .get(`http://localhost:4000/posts`, { params: { title: "수정" } })
      //   .then((res) => {
      //     console.log("검색 성공!");
      //     console.log(res.data);
      //   })
      //   .catch((error) => {
      //     console.log(error);
      //   });
    }
  };
  return (
    <>
      <div className="bg-white pb-4 mx-auto rounded max-w-5xl	">
        <div className="w-full flex justify-between items-center px-2 mt-10">
          <div className="text-2xl font-bold">자유게시판</div>
          <div className="w-96">
            <TextInput
              placeholder={"제목, 작성자 등을 검색하세요"}
              onChange={(e) => setInputValue(e.target.value)}
              onKeyDown={handleEnter}
            />
          </div>
          <div className="w-20 inline-block ml-7">
            <Button value={"글쓰기"} type={"primary"} onClick={onClickWrite} />
          </div>
        </div>
        <div className="overflow-x-auto mt-6 ">
          <BoardList />
        </div>
      </div>
    </>
  );
};

export default Home;
