import { useState } from "react";
import { useNavigate } from "react-router-dom";
import TextInput from "../components/TextInput";
import Button from "../components/Button";

const SignUp = () => {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");
  const [checkpassword, setCheckpassword] = useState("");
  const [nickname, setNickname] = useState("");
  const [submitted, setSubmitted] = useState(false);

  const navigate = useNavigate();

  const onChange = (e) => {
    const { name, value } = e.target;

    if (name === "id") {
      setId(value);
    } else if (name === "password") {
      setPassword(value);
    } else if (name === "checkpassword") {
      setCheckpassword(value);
    } else if (name === "nickname") {
      setNickname(value);
    }
  };

  const onSubmitClick = () => {
    setSubmitted(true);

    if (!id || id.length < 4) return;
    if (!password || password.length < 4) return;
    if (!checkpassword || checkpassword !== password) return;
    if (!nickname || nickname.length < 9) return;

    console.log(id, password, checkpassword, nickname);
    navigate("/login");
  };

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
            <h2 className="text-xl font-bold">회원가입</h2>
          </div>
          <TextInput
            placeholder={"아이디를 입력해주세요"}
            name="id"
            value={id}
            onChange={onChange}
            error={
              submitted && (!id || id.length < 4)
                ? "아이디는 4자 이상으로 입력 해주세요"
                : ""
            }
          />

          <TextInput
            placeholder={"비밀번호를 입력해주세요"}
            name="password"
            value={password}
            onChange={onChange}
            error={
              submitted && (!password || password.length < 4)
                ? "비밀번호는 4자 이상으로 입력 해주세요"
                : ""
            }
          />
          <TextInput
            placeholder={"비밀번호 확인을 위해 한 번 더 입력해주세요"}
            name="checkpassword"
            value={checkpassword}
            onChange={onChange}
            error={
              submitted && (!checkpassword || checkpassword !== password)
                ? "비밀번호가 일치하지 않습니다."
                : ""
            }
          />
          <TextInput
            placeholder={"닉네임을 입력해주세요"}
            name="nickname"
            value={nickname}
            onChange={onChange}
            error={
              submitted && (!nickname || nickname.length < 9)
                ? "닉네임은 9자 이상으로 입력 해주세요"
                : ""
            }
          />

          <Button value="회원가입" type="primary" onClick={onSubmitClick} />
        </div>
      </section>
    </>
  );
};

export default SignUp;
