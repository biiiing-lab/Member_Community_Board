import React from "react";
import "./tailwind.css";
import SignUp from "./pages/SignUp";
import LogIn from "./pages/LogIn";
import Home from "./pages/Home";
import Write from "./pages/Write";
import View from "./pages/View";
import Edit from "./pages/Edit";
import MyPage from "./pages/MyPage";
import Skeleton from "./components/Skeleton";

import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Skeleton />}>
          <Route index element={<Home />} />
          <Route path="write" element={<Write />} />
          <Route path="view/:postId" element={<View />} />
          <Route path="edit/:postId" element={<Edit />} />
          <Route path="mypage" element={<MyPage />} />
        </Route>
        <Route path="/login" element={<LogIn />} />
        <Route path="/signUp" element={<SignUp />} />
      </Routes>
    </div>
  );
}

export default App;
