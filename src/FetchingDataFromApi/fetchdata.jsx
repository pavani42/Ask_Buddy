import React from "react";
import NoteContext from "./context.jsx";
import { useState, useEffect } from 'react';
import axios from "axios";

const Main = (props) => {

    const [pr, setPr] = useState();
    const [data1,setData] = useState([]);
   

    // const [data, setData] = useState([]);
    const fetchAPI = () => {
        axios("http://localhost:9191/api/questions/latestQuestions", {
            method: "get",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                mode: "no-cors",
            },

        }).then((res)  => {
            setPr(100);
            setData(res.data);
            console.log(res.data);
        });
    };
    useEffect(fetchAPI, []);
    return (
        <NoteContext.Provider value={{data:data1, pr:pr}}>
            {props.children}
        </NoteContext.Provider>);
}
export default Main;