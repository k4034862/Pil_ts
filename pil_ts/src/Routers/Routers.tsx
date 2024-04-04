import { BrowserRouter, Routes, Route } from "react-router-dom";
import Drawer from "../Drawer";
import Login from "../Pages/Login/LoginControl";
const Router = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route element={<Drawer />}></Route>
      </Routes>
    </BrowserRouter>
  );
};
export default Router;
