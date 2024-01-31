import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import TextInput from "../components/TextInput";
import BoardList from "../components/BoardList";

const Home = () => {
  const navigate = useNavigate();

  const onClickWrite = () => {
    console.log("함수 실행!");
    navigate("/write");
  };
  return (
    <>
      <div className="bg-white pb-4 mx-auto rounded max-w-5xl	">
        <div className="w-full flex justify-between items-center px-2 mt-10">
          <div className="text-2xl font-bold">자유게시판</div>
          <div>
            <div className="w-full sm:w-64 inline-block relative ">
              <TextInput placeholder={"Search"} />
            </div>
            <div className="w-20 inline-block ml-3">
              <Button
                value={"글쓰기"}
                type={"primary"}
                onClick={onClickWrite}
              />
            </div>
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
