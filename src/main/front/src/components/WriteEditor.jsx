import Button from "./Button";

const WriteEditor = ({ type, title, content }) => {
  return (
    <div className="max-w-5xl mx-auto mt-10">
      <div className="text-2xl font-bold mb-5">
        {type === "write" ? "게시글 작성" : "게시글 수정"}
      </div>
      <form>
        <div className="mb-4 w-full rounded border border-gray-200 dark:bg-gray-700 dark:border-gray-600">
          <div className="flex justify-between items-center py-2 px-3 bg-gray-50 border-b dark:border-gray-600">
            <input
              className="w-full p-2 text-xl bg-gray-50"
              placeholder="제목을 입력 해주세요"
              value={title ? title : null}
              requiredx
            />
          </div>
          <div className="py-2 px-4 rounded-b-lg bg-gray-50">
            <textarea
              rows="20"
              className="block p-2 w-full text-sm text-gray-800 bg-gray-50 border-0 "
              placeholder="글을 입력해주세요"
              required
            >
              {content ? content : null}
            </textarea>
          </div>
        </div>
        <div className="w-40 ml-auto">
          <Button
            value={type === "write" ? "게시물 업로드" : "게시글 수정하기"}
            type={"primary"}
          />
        </div>
      </form>
    </div>
  );
};

export default WriteEditor;
