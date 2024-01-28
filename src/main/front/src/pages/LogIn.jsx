import TextInput from "../components/TextInput";
import Button from "../components/Button";
const LogIn = () => {
  return (
    <>
      <section className="flex justify-center items-center h-screen bg-gray-100">
        <div className="max-w-md w-full bg-white rounded p-6 space-y-4">
          <div className="mb-4">
            <div className="mb-2">
              <span className="my-0  text-rose-500	font-semibold text-s ">
                m i l k y
              </span>
              <span className="my-0 font-semibold text-s text-indigo-500">
                &nbsp; * w a y
              </span>
            </div>
            <h2 className="text-2xl font-bold">로그인</h2>
          </div>
          <TextInput placeholder={"아이디를 입력해주세요"} />
          <TextInput placeholder={"비밀번호를 입력해주세요"} />
          <Button value={"로그인"} type={"primary"} />
          <div className="flex items-center justify-between"></div>
        </div>
      </section>
    </>
  );
};

export default LogIn;
