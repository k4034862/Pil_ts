import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import ButtonGroup from "@mui/material/ButtonGroup";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider, Theme } from "@mui/material/styles";

function LoginView(props: any) {
  const defaultTheme = createTheme();

  return (
    <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            로그인
          </Typography>
          <Box component="form" noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="아이디"
              name="email"
              onChange={(e) => {
                props.setInputs({
                  ...props.inputs,
                  loginId: e.target.value,
                });
              }}
              autoComplete="email"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="비밀번호"
              type="password"
              id="password"
              autoComplete="current-password"
              onChange={(e) => {
                props.setInputs({
                  ...props.inputs,
                  loginPw: e.target.value,
                });
              }}
            />
            <FormControlLabel
              control={
                <Checkbox
                  value="remember"
                  color="primary"
                  onChange={(e) => {
                    props.setInputs({
                      ...props.inputs,
                      loginChk: e.target.checked,
                    });
                  }}
                />
              }
              label="로그인 상태 유지"
            />
            <Box
              sx={{
                display: "flex",
              }}
            >
              <ButtonGroup
                variant="contained"
                aria-label="Basic button group"
                sx={{ width: "100%" }}
              >
                <Button
                  fullWidth
                  variant="contained"
                  sx={{ mr: 3, height: "5vh" }}
                  onClick={(e) => {
                    props.Login();
                  }}
                >
                  로그인
                </Button>
                <Button
                  fullWidth
                  variant="contained"
                  sx={{ mr: 3 }}
                  onClick={(e) => {
                    props.setPageNo(2);
                  }}
                >
                  아이디 찾기
                </Button>
                <Button
                  fullWidth
                  variant="contained"
                  onClick={(e) => {
                    props.setPageNo(1);
                  }}
                >
                  회원 가입
                </Button>
              </ButtonGroup>
            </Box>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}
export default LoginView;
