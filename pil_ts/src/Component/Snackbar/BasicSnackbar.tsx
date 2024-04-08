import Snackbar, { SnackbarOrigin } from "@mui/material/Snackbar";
import MuiAlert from "@mui/material/Alert";
import React, { forwardRef } from "react";

interface BasicSnackbarProps {
  open: boolean;
  onClose: () => void;
  type: string;
  message: string;
}

const Alert = forwardRef<HTMLDivElement, any>(function Alert(props, ref) {
  return (
    <MuiAlert
      sx={props.sx}
      elevation={6}
      ref={ref}
      variant="filled"
      {...props}
    />
  );
});

const position: SnackbarOrigin = { vertical: "top", horizontal: "center" };

function BasicSnackbar(props: BasicSnackbarProps) {
  return (
    <Snackbar
      open={props.open}
      onClose={props.onClose}
      autoHideDuration={2000}
      anchorOrigin={position}
    >
      <Alert severity={props.type}>{props.message}</Alert>
    </Snackbar>
  );
}

export default BasicSnackbar;
