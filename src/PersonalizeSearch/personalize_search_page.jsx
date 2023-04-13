import Card from "../Ques_ans_card/Card.jsx";
import axios from 'axios';
import { useEffect, useContext } from 'react';
import { useState } from 'react';

const Main = () => {

    const [formData, setFormData] = useState([]);
    console.log(localStorage);

    const temp = localStorage.getItem('searched');

    const [noRecordsDisplay, setNoRecordsDisplay] = useState('');

    console.log(temp)

    const onPuttingInput = (p) => {
        // console.log(p.target.value);
        axios.get('http://localhost:8083/searchQuestionByKeyword/' + encodeURIComponent(temp))
            .then(response => {
                const dataArray = response.data;
                //  console.log(response);
                //  setData(dataArray); 
                console.log(dataArray)
                setFormData(dataArray)

                // console.log(formData)
            })
            if(formData.length === 0)
               {
                setNoRecordsDisplay('');
                 
              }

            else
            {
            setNoRecordsDisplay('display-none');
            }
        // console.log(formData)
    }
    useEffect(onPuttingInput, []);
    console.log(formData)
    console.log(formData.length)
    // if(formData.length === 0)
    // {
    //     setNoRecordsDisplay('display-none');
    // }

    // else
    // {
    //     setNoRecordsDisplay('');
    // }

    return (

        <>

            <div

                className="body-main-content join-us-main-3"

                style={{

                    width: "100%",

                    display: "flex",

                    justifyContent: "center",

                    marginBottom: "20px",

                    marginTop: '60px'

                }}

            >

                <div className="ques-ans-page-2 height-1" style={{ backgroundColor: "white" }}>

                    <div className="list-group w-100">

                        <div

                            className="body-main-2"

                            style={{

                                display: "flex",

                                justifyContent: "space-between",

                                margin: "30px 10px 0 10px",

                            }}

                        >

                            <h1 style={{ color: "black" }}>Search Result </h1>



                        </div>

                    </div>



                    <div className="ques-ans-content-1">



                        {
                            formData.map((val) => {
                                return (
                                    <Card A={val.question.question} ></Card>

                                )
                            })
                        }

                        <h1 style={{ textAlign: 'center', color: 'rgb(180 180 180)', marginTop: '100px' }} className = {noRecordsDisplay}>No Records Found!!</h1>

                    </div>

                </div>

            </div>

        </>

    );

};

export default Main;