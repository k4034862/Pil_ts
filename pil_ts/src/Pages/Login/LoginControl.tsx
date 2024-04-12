import * as React from "react";
import LoginView from "./LoginView";
import SignUpView from "./SignUpView";
import ForgetIdView from "./ForgetIdView";
import { useNavigate } from "react-router-dom";
import { Snackbar } from "../../Component/Snackbar";
import axios from "axios";

function LoginControl() {
  const navigate = useNavigate(); // Route move api

  const [snacks, setSnacks] = React.useState({
    type: "info",
    open: false,
    message: "",
  }); //알림

  const [inputs, setInputs] = React.useState({
    loginId: "", //아이디
    loginPw: "", //비밀번호
    loginChk: false, //로그인 상태 유지
  }); //로그인 페이지

  const [signInputs, setSignInputs] = React.useState({
    firstId: "", //성
    lastId: "", //이름
    loginPw: "", //비밀번호
    email: "", //이메일
    loginId: "", //아이디
  }); //로그인 페이지

  const [forgetInputs, setForgetInputs] = React.useState({
    firstId: "", //성
    lastId: "", //이름
    email: "", //이메일
  }); //로그인 페이지

  const [pageNo, setPageNo] = React.useState(0); // 0 : 로그인 페이지 1 : 회원가입 페이지 2 : 아이디찾기 페이지

  // 로그인 버튼
  const Login = async () => {
    try {
      let postData = {
        USER_ID: inputs.loginId,
        PASSWORD: inputs.loginPw,
      };

      const response = await axios.get("/select", {
        headers: {
          "Content-Type": `application/json`,
        },
        params: postData,
      });

      console.log(response);
      if (response.data === "success") {
        navigate("/Home");
      } else {
        setSnacks({
          ...snacks,
          open: true,
          type: "error",
          message: "아이디나 비밀번호가 틀렸습니다.",
        });
      }
    } catch (error) {
      console.error(error);
      // 오류 처리
    }
  };

  //회원가입 버튼
  const SignUp = async () => {
    await axios
      .post(
        "/insert",
        new URLSearchParams({
          USER_ID: signInputs.loginId,
          USER_NM: signInputs.firstId + signInputs.lastId,
          PASSWORD: signInputs.loginPw,
          USER_EMAIL: signInputs.email,
        })
      )
      .then((result: any) => {
        console.log(result);
        setSnacks({
          ...snacks,
          open: true,
          type: "info",
          message: "회원가입에 성공하였습니다.",
        });
        setPageNo(0);
      })
      .catch((error) => {
        setSnacks({
          ...snacks,
          open: true,
          type: "error",
          message: "이미 가입된 회원입니다.",
        });
        console.log(error);
      });
  };

  //아이디찾기 버튼
  const FindId = () => {};

  return (
    <div className="Login">
      {pageNo === 0 ? (
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
          signInputs={signInputs}
          setSignInputs={setSignInputs}
        />
      ) : (
        <ForgetIdView
          pageNo={pageNo}
          FindId={FindId}
          setPageNo={setPageNo}
          forgetInputs={forgetInputs}
          setForgetInputs={setForgetInputs}
        />
      )}
      <Snackbar
        type={snacks.type}
        open={snacks.open}
        message={snacks.message}
        onClose={() => {
          setSnacks({
            ...snacks,
            open: false,
          });
        }}
      />
    </div>
  );
}
export default LoginControl;
