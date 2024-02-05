import React from 'react';

const DateComponent = () => {
  const date = new Date();
  const dateStr = `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(
    2,
    '0'
  )}-${String(date.getDate()).padStart(2, '0')}`;

  return <>{dateStr}</>;
};

export default DateComponent;
