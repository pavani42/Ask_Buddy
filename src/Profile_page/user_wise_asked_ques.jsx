import React from "react"; 
import Card from "../Ques_ans_card/Card.jsx"; 
import { useState, useEffect } from 'react';
import axios from "axios";

export const UserAskedQuestions = () => { 

    const [data, setData] = useState([]);
    const fetchAPI = () => {
        const user = JSON.parse(localStorage.getItem('token'));
        axios("http://localhost:9090/userQuestions", {
            method: "get",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Authorization": "Bearer " + user,
                mode: "no-cors",
            },

        }).then((res) => {
            setData(res.data);
            console.log(res.data);
        });
    };
    useEffect(fetchAPI, []);

  return ( 

    <div className="ques-ans-content-1"> 

      {data.slice(0, 10).map((val) => { 
        // console.log(val.question.question + val.answerList[0].description)
        return <Card A={val.question.question} B={val.question.question}/>; 

      })} 

    </div> 

  ); 

}; 