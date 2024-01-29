import WriteEditor from "../components/WriteEditor";
import React from "react";
import { useLocation } from "react-router-dom";

const Edit = () => {
  const location = useLocation();
  const { title, content } = location.state || {};
  return (
    <>
      <WriteEditor
        type={"edit"}
        title={title || ""}
        content={content || ""}
      />
    </>
  );
};

export default Edit;
