import { useEffect } from "react";
import { axios } from "axios";

const Secured = () => {
  useEffect(() => {
    const token = localStorage.getItem("access_token");

    axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
  }, []);

  return <></>;
};

export default Secured;
