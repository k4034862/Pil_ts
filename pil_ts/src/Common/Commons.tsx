import axios from "axios";

const Commons = {
  Axios: async (_type = "get", _url: any, _params: any) => {
    const token = localStorage.getItem("token");
    switch (_type) {
      case "get":
        return await axios.get(_url, {
          headers: {
            "Content-Type": `application/json`,
            Authorization: "Bearer " + token,
          },
          params: _params,
        });
      case "post":
        return await axios.post(_url, _params);
    }
  },
};
export default Commons;
