import ListItem from "./ListItem";

const BoardList = () => {
  return (
    <>
      <table className="table-auto border-collapse w-full ">
        <thead>
          <tr
            className="w-full rounded text-sm font-medium text-gray-700 text-left border-t-2 border-b"
            style={{ fontSize: "0.9674rem" }}
          >
            <th className="w-3/4 px-4 py-2 ">
              <p classsName="w-100">제목</p>
            </th>
            <th className="w-1/6 px-4 py-2 ">작성자</th>
            <th className="w-1/6 px-4 ">조회수</th>
          </tr>
        </thead>
        <tbody className="text-sm font-normal text-gray-700">
          <ListItem
            title="ㅁㄴㅇㄹㅇㄴㅇㄴㅁㄴㅇㄹㅇㄴㄹㄹㅇㄴㄹㄴㅇㄹㄴㅇhhkhjf"
            author="sdsdf"
            view="dsfsdf"
          />
          <ListItem title="sdafdsf" author="sdsdf" view="dsfsdf" />
          <ListItem title="sdafdsf" author="sdsdf" view="dsfsdf" />
          <ListItem title="sdafdsf" author="sdsdf" view="dsfsdf" />
          <ListItem title="sdafdsf" author="sdsdf" view="dsfsdf" />
        </tbody>
      </table>
    </>
  );
};

export default BoardList;
