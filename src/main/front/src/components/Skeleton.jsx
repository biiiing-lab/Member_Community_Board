import { Outlet, useNavigate } from "react-router-dom";

const Skeleton = () => {
  const navigate = useNavigate();
  return (
    <>
      <div className="flex flex-wrap -mx-3 w-full drop-shadow-sm mx-auto ">
        <div className="px-20 mb-1 mx-auto w-full bg-white border-gray-200">
          <div className="sm:flex items-center sitems-stretch justify-between grow lg:mb-0 py-4 px-5 max-w-5xl mx-auto">
            <div className="flex flex-col flex-wrap justify-center mb-5  lg:mb-0">
              <button className="flex" onClick={() => navigate("/")}>
                <span className="my-0  text-rose-500	font-semibold text-[1.35rem]/[1.2] flex-col">
                  m i l k y
                </span>
                <span className="my-0 font-semibold text-[1.35rem]/[1.2] text-indigo-500">
                  &nbsp; * w a y
                </span>
              </button>
            </div>
            <div className="flex items-center lg:shrink-0 lg:flex-nowrap">
              <div className="relative flex items-center lg:ml-4 sm:mr-0 mr-2">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 24 24"
                  fill="currentColor"
                  className="w-6 h-6"
                >
                  <path
                    fillRule="evenodd"
                    d="M18.685 19.097A9.723 9.723 0 0 0 21.75 12c0-5.385-4.365-9.75-9.75-9.75S2.25 6.615 2.25 12a9.723 9.723 0 0 0 3.065 7.097A9.716 9.716 0 0 0 12 21.75a9.716 9.716 0 0 0 6.685-2.653Zm-12.54-1.285A7.486 7.486 0 0 1 12 15a7.486 7.486 0 0 1 5.855 2.812A8.224 8.224 0 0 1 12 20.25a8.224 8.224 0 0 1-5.855-2.438ZM15.75 9a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0Z"
                    clipRule="evenodd"
                  />
                </svg>
                <span className="ml-2">user</span>
              </div>
            </div>
          </div>
        </div>
      </div>

      <Outlet />
    </>
  );
};

export default Skeleton;
