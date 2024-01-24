import { Outlet } from "react-router-dom";

const Skeleton = () => {
  return (
    <>
      <div className="flex flex-wrap -mx-3 w-full ">
        <div className="px-20 mb-1 mx-auto w-full bg-white border-gray-200">
          <div className="sm:flex items-center sitems-stretch justify-between grow lg:mb-0 py-4 px-5">
            <div className="flex flex-col flex-wrap justify-center mb-5 mr-3 lg:mb-0">
              <span className="my-0 flex text-dark font-semibold text-[1.35rem]/[1.2] flex-col justify-center">
                밀키웨이 🌠
              </span>
            </div>
            <div className="flex items-center lg:shrink-0 lg:flex-nowrap">
              <div className="relative flex items-center lg:ml-4 sm:mr-0 mr-2">
                userName
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
