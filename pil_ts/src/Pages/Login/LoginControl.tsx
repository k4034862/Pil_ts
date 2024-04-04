import * as React from "react";
import LoginView from "./LoginView";
import SignUpView from "./SignUpView";
import ForgetIdView from "./ForgetIdView";
import { useNavigate } from "react-router-dom";

function LoginControl() {
  const navigate = useNavigate(); // Route move api

  const [inputs, setInputs] = React.useState({
    loginId: "", //아이디
    loginPw: "", //비밀번호
    loginChk: false, //로그인 상태 유지
  }); //로그인 페이지

  const [siginInputs, setSignInputs] = React.useState({
    firstId: "", //성
    lastId: "", //이름
    loginPw: "", //비밀번호
    email: "", //이메일
  }); //로그인 페이지

  const [pageNo, setPageNo] = React.useState(0); // 0 : 로그인 페이지 1 : 회원가입 페이지 2 : 아이디찾기 페이지

  //로그인 버튼
  const Login = () => {
    navigate("/Home");
  };

  //회원가입 버튼
  const SignUp = () => {};
  return pageNo === 0 ? (
    <LoginView
      Login={Login}
      inputs={inputs}
      setInputs={setInputs}
      pageNo={pageNo}
      setPageNo={setPageNo}
    />
  ) : pageNo === 1 ? (
    <SignUpView
      pageNo={pageNo}
      setPageNo={setPageNo}
      SignUp={SignUp}
      siginInputs={siginInputs}
      setSignInputs={setSignInputs}
    />
  ) : (
    <ForgetIdView pageNo={pageNo} setPageNo={setPageNo} />
  );
}
export default LoginControl;
