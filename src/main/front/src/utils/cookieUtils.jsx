import Cookies from "js-cookie";

const COOKIE_NAME = "user";

export const setLoginCookie = (userData) => {
  Cookies.set(COOKIE_NAME, JSON.stringify(userData), { expires: 7 });
  console.log(userData);
};

export const removeLoginCookie = () => {
  Cookies.remove(COOKIE_NAME);
};

export const getLoginCookie = () => {
  const cookieValue = Cookies.get(COOKIE_NAME);
  return cookieValue ? JSON.parse(cookieValue).userName : "";
};
