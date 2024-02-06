import { useState } from "react";
import { useNavigate } from "react-router-dom";
import TextInput from "../components/TextInput";
import Button from "../components/Button";
import axios from "axios";

const SignUp = () => {
  const [id, setId] = useState("test1");
  const [password, setPassword] = useState("test1");
  const [checkpassword, setCheckpassword] = useState("test1");
  const [nickname, setNickname] = useState("test@gmail.com");
  const [email, setEmail] = useState("테스트테스트");
  const [submitted, setSubmitted] = useState(false);

  const navigate = useNavigate();

  const date = new Date();
  const dateStr = `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(
    2,
    "0"
  )}-${String(date.getDate()).padStart(2, "0")}`;

  const onChange = (e) => {
    const { name, value } = e.target;

    if (name === "id") {
      setId(value);
    } else if (name === "password") {
      setPassword(value);
    } else if (name === "checkpassword") {
      setCheckpassword(value);
    } else if (name === "email") {
      setEmail(value);
    } else if (name === "nickname") {
      setNickname(value);
    }
  };

  const onSubmitClick = async () => {
    setSubmitted(true);

    if (!id || id.length < 4) return;
    if (!password || password.length < 4) return;
    if (!checkpassword || checkpassword !== password) return;
    if (!email || email.length < 4) return;
    if (!nickname || nickname.length < 4) return;

    console.log(id, password, checkpassword, nickname);

    await axios
      .post("/SignUp", {
        memberId: id,
        password: password,
        email: email,
        memberName: nickname,
        regDate: dateStr,
      })
      .then((res) => {
        console.log(res);
      })
      .catch((error) => {
        console.log(error);
      });
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
            type={"password"}
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
            type={"password"}
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
            type={"email"}
            placeholder={"이메일을 입력해주세요"}
            name="email"
            value={email}
            onChange={onChange}
            error={
              submitted && (!email || email.length < 4)
                ? "이메일은 4자 이상으로 입력 해주세요"
                : ""
            }
          />
          <TextInput
            placeholder={"닉네임을 입력해주세요"}
            name="nickname"
            value={nickname}
            onChange={onChange}
            error={
              submitted && (!nickname || nickname.length < 4)
                ? "닉네임은 4자 이상으로 입력 해주세요"
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
