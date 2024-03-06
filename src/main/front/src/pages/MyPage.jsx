import BoardList from "../components/BoardList";
import Button from "../components/Button";

const MyPage = () => {
  return (
    <>
      <div className="py-10 bg-indigo-100	">
        <div className="flex justify-between mx-auto max-w-5xl">
          <div className="w-full my-auto">
            <span className="font-bold mr-2">유저네임</span>
            <span>test</span>
          </div>
          <div className="w-20">
            <Button value="로그아웃" type="tertiary" />
          </div>
        </div>
      </div>
      <div className="bg-white mt-10 spb-4 mx-auto rounded max-w-5xl	">
        <div className="text-2xl font-bold	">내가 작성한 게시글</div>
        <div className="overflow-x-auto mt-6 ">
          <BoardList />
        </div>
      </div>
    </>
  );
};

export default MyPage;
