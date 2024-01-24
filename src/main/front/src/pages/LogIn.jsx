const LogIn = () => {
  return (
    <>
      <section className="flex justify-center items-center h-screen bg-gray-100">
        <div className="max-w-md w-full bg-white rounded p-6 space-y-4">
          <div className="mb-4">
            <p className="text-gray-600">밀키웨이 🌠</p>
            <h2 className="text-xl font-bold">로그인</h2>
          </div>
          <div>
            <input
              className="w-full p-4 text-sm bg-gray-50 focus:outline-none border border-gray-200 rounded text-gray-600"
              type="text"
              placeholder="아이디를 입력해주세요"
            />
          </div>
          <div>
            <input
              className="w-full p-4 text-sm bg-gray-50 focus:outline-none border border-gray-200 rounded text-gray-600"
              type="text"
              placeholder="비밀번호를 입력해주세요"
            />
          </div>
          <div>
            <button className="w-full py-4 bg-blue-600 hover:bg-blue-700 rounded text-sm font-bold text-gray-50 transition duration-200">
              로그인
            </button>
          </div>
          <div className="flex items-center justify-between">
            {/* <div className="flex flex-row items-center">
              <input
                type="checkbox"
                className="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded"
              />
              <label
                htmlFor="comments"
                className="ml-2 text-sm font-normal text-gray-600"
              >
                Remember me
              </label>
            </div> */}
            <div>
              <a className="text-sm text-blue-600 hover:underline" href="#">
                비밀번호를 잊어버리셨나요?
              </a>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default LogIn;
