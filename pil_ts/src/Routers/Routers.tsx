import { BrowserRouter, Routes, Route } from "react-router-dom";
import Drawer from "../Drawer";
import Login from "../Pages/Login/LoginControl";
import Home from "../Pages/Home/HomeView";
const Router = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route element={<Drawer />}>
          <Route path="/Home" element={<Home />}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
};
export default Router;
