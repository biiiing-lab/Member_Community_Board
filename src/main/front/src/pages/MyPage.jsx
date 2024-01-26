import BoardList from "../components/BoardList";

const MyPage = () => {
  return (
    <>
      <div className="py-10 bg-indigo-100	">
        <div className="flex mx-auto max-w-5xl">
          <div className="font-bold mr-2">유저네임</div>
          <div>test</div>
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
