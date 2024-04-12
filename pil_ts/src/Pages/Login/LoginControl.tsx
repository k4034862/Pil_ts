import * as React from "react";
import LoginView from "./LoginView";
import SignUpView from "./SignUpView";
import ForgetIdView from "./ForgetIdView";
import { useNavigate } from "react-router-dom";
import { Snackbar } from "../../Component/Snackbar";
import Commons from "../../Common/Commons";
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
      let postData = new URLSearchParams({
        USER_ID: inputs.loginId,
        PASSWORD: inputs.loginPw,
      });

      Commons.Axios("post", "/select", postData).then((result) => {
        let data = result?.data;
        if (data.success == true) {
          // 토큰 저장
          localStorage.setItem("token", data.token);
          localStorage.setItem("userId", data.userId);
          // 아이디 저장
          navigate("/Home");
        } else {
          setSnacks({
            ...snacks,
            open: true,
            type: "error",
            message: "아이디나 비밀번호가 틀렸습니다.",
          });
        }
      });
    } catch (error) {
      console.error(error);
      // 오류 처리
    }
  };

  //회원가입 버튼
  const SignUp = async () => {
    let postData = new URLSearchParams({
      USER_ID: signInputs.loginId,
      USER_NM: signInputs.firstId + signInputs.lastId,
      PASSWORD: signInputs.loginPw,
      USER_EMAIL: signInputs.email,
    });
    try {
      if (
        signInputs.loginId == null ||
        signInputs.loginId == undefined ||
        signInputs.loginId == ""
      ) {
        setSnacks({
          ...snacks,
          open: true,
          type: "info",
          message: "아이디를 입력하세요.",
        });
      } else if (
        signInputs.loginPw == null ||
        signInputs.loginPw == undefined ||
        signInputs.loginPw == ""
      ) {
        setSnacks({
          ...snacks,
          open: true,
          type: "info",
          message: "비밀번호를 입력하세요.",
        });
      } else {
        Commons.Axios("post", "/insert", postData)
          .then((result) => {
            let data = result?.data;
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
          });
      }
    } catch (error) {
      setSnacks({
        ...snacks,
        open: true,
        type: "error",
        message: "이미 가입된 회원입니다.",
      });
      // 오류 처리
    }
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
