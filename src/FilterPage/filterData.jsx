
import axios from 'axios'
import {useEffect, useState} from 'react'
import Card from "../Ques_ans_card/Card.jsx";
const Main = () => {

    ////////////axios///////////////////////


    ////////////axios///////////////////////
    const category = localStorage.getItem('category');

    const sub_category = localStorage.getItem('subcategory');

    console.log(category + sub_category);
    const [formData, setFormData] = useState([]);
    const onPuttingInput = (p) => {
        // console.log(p.target.value);
        axios.get('http://localhost:8083/getQuestionsByCategory?cat='+ category +'&subCat=' + sub_category)
          .then(response => {
            const dataArray = response.data;

             console.log(response);
            //  setData(dataArray); 
             console.log(dataArray)
            setFormData(dataArray)
          })
        // setVal(p.target.value);
        console.log(formData)
      }

    useEffect(onPuttingInput, [])
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

                            <h1 style={{ color: "black" }}>Filtered Result </h1>



                        </div>

                    </div>



                    <div className="ques-ans-content-1">

                    {
                            formData.map((val) => {
                                return(
                                    <Card A = {val.question.question} ></Card>
                                    
                                )
                            })
                        }



                    </div>

                </div>

            </div>

        </>

    );

}




export default Main;
    