import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {

    const baseUrl = "http://localhost:8080";

    const [ data, setData ] = useState('');

    useEffect(() => { // 컴포넌트가 마운트 될 때 실행
        springDataSet();
    },[])

    async function springDataSet() { // Axios 방식 사용
        await axios
            .get(baseUrl + "/data-test") // 해당 URL에 HTTP GET 요청
            .then((res)=>{
                console.log(res);
                setData(res.data); // GET 요청하여 응답받은 data
            })
            .catch((err)=>{
                console.log(err);
            })
    }

    return (
        <div className="App">
            <h1>{data}</h1>
        </div>
    );
}

export default App;