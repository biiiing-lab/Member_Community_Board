const Pagination = ({ itemsPerPage, totalItems, paginate, currentPage }) => {
  const pageNumbers = [];

  for (let i = 1; i <= Math.ceil(totalItems / itemsPerPage); i++) {
    pageNumbers.push(i);
  }

  return (
    <>
      <div
        id="pagination"
        className="w-full flex justify-center border-t border-gray-100 pt-4 items-center"
      >
        <p
          onClick={() => {
            currentPage - 1 >= 1
              ? paginate(currentPage - 1)
              : paginate(currentPage);
          }}
          className="cursor-pointer"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke-width="1"
            stroke="currentColor"
            class="w-5 h-5"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              d="M15.75 19.5 8.25 12l7.5-7.5"
            />
          </svg>
        </p>

        {pageNumbers.map((number) => (
          <p
            className={`leading-relaxed cursor-pointer px-2 mx-1 text-sm hover:text-indigo-600 rounded hover:border-indigo-200 ${
              currentPage === number ? `bg-indigo-400 text-white` : ``
            }`}
          >
            <a onClick={() => paginate(number)}>{number}</a>
          </p>
        ))}
        <p
          onClick={() => {
            currentPage + 1 <= pageNumbers.length
              ? paginate(currentPage + 1)
              : paginate(currentPage);
          }}
          className="cursor-pointer"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth="1"
            stroke="currentColor"
            className="w-5 h-5"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="m8.25 4.5 7.5 7.5-7.5 7.5"
            />
          </svg>
        </p>
      </div>
    </>
  );
};

export default Pagination;
