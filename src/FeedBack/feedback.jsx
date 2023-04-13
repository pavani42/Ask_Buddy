import React from "react";
import { MDBContainer } from "mdb-react-ui-kit";
import { Stack, Rating, Typography } from "@mui/material";
import axios from 'axios';
import { useState } from 'react';
import Alert from "@mui/material/Alert";
import { Box } from "@mui/system";
const Fdb = () => {
    // const [value, setValue] = React.useState(2);
    const [temp1, setTemp1] = useState("alert-display-none");
    const [formData, setFormData] = useState({});
    const user = JSON.parse(localStorage.getItem('token'));
    // const [value, setValue] = useState(0);
    const changeHandle = (event, newValue) => {
     setValue(newValue);
     };
    const SubmitHandle = async (event) => {
      event.preventDefault();
      if(localStorage.getItem('token') == null)
      {
        window.alert("Please login");
      }
      console.log(formData)
      try{
      const response = await axios('http://localhost:8087/feedBack/addFeed', {
          method: "post",
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json",
            "Authorization": "Bearer " + user,
            mode: "no-cors",
          },
          data: formData,
        });
      console.log(response);
      if(response.data.message == "Please Login")
         window.alert("Please login")
      if (response.status == 200) {
        // setTimeout(function () {
        //   document.getElementById("modalCloseButton").click();
        //   alert("Question posted successfully !!")
        // }, 300);
        document.getElementById("feedbackform").reset();
        setTemp1("alert-display");
        window.alert("Succesfully Submitted")
      }
    }
  catch(error)
  {
    window.alert("Please Login")
    console.log(error)
  }
    }
    const [value, setValue] = useState(0);
    const handleChange = (event, newValue) => { console.log(newValue); setValue(newValue); setFormData({ ...formData, rating: newValue}) };
    return (
        <>
        <div className={temp1}>
        <Alert variant="filled" severity="success">
          Success!!
        </Alert>
      </div>
        <div className="join-us-main-3" style={{minHeight: 'calc(100vh - 107px)', marginTop : '60px'}}>
            <div className="join-us-main-2" style={{ width: "100%", display: "flex", justifyContent: "center" }}>
                <div className="join-us-main-1" style={{ marginTop: "30px" }}>
                    <MDBContainer fluid className="">
                        <div className="main" style={{ backgroundColor: "white", borderRadius: "10px" }}>
                            <form
                                onSubmit={SubmitHandle}  
                                id="feedbackform" style={{ height: "100%", }}>
                                <div className="cont-1-form" style={{
                                    // display: "flex", 
                                    // justifyContent: "center", 
                                    // alignItems: "center", 
                                    borderRadius: "10px",
                                }}
                                >
                                    <div className="join-us-header" style={{
                                        color: "white",
                                        display: "flex",
                                        justifyContent: "center",
                                        backgroundColor: "rgb(81 47 163)",
                                        width: "100%",
                                        borderRadius: "10px 10px 0 0",
                                    }}
                                    >
                                        <h1 style={{ padding: "20px" }}>Feedback</h1>
                                    </div>
                                    <div className="main-2" style={{
                                        backgroundColor: "white",
                                        width: "100%",
                                        display: "flex",
                                        justifyContent: "center",
                                        borderRadius: "0 0 10px 10px",
                                    }}>
                                        <div className="main-3" style={{ padding: "0px 0px 30px 0px", width: "80%" }} >
                                            <div className="main-4" style={{}}>
                                                {/* <div className="main-6" style={{ marginTop: "30px" }}>
                                                    <p style={{color:'white'}}>Password</p>
                                                    <input
                                                        required
                                                        type="number"
                                                        name="sap-id"
                                                        onChange={(e) => 
                                                          setFormData({ ...formData, Password: e.target.value }) 
                                                        } 
                                                        placeholder=" SAP ID"
                                                        style={{
                                                            width: "100%",
                                                            padding: "5px 5px",
                                                        }}
                                                    />
                                                </div>  */}
                                                <div className="main-6" style={{ marginTop: "30px" }}>
                                                    <Typography required component="legend">Rating</Typography>
                                                    {/* <Rating name="simple-controlled" value={value}  
                                                                onChange={( newValue) => { 
                                                                setValue(newValue); 
                                                                }}/> */}
                                                    {/* <Rating sx={{ fontSize: '2.5rem', alignContent: "center", justifyContent: "center" }} required name="half-rating" defaultValue={0.0} precision={1.0} value={value}
                                                    onChange={(newValue) => { 
                                                        console.log("hiii")
                                                        setValue(value); 
                                                        setFormData({ ...formData, rating: value}) 
                                                        }} /> */}
                                            {/* <Rating sx={{ fontSize: '2.5rem', alignContent:"center", justifyContent:"center" }} required name="half-rating" defaultValue={0.0} precision={1.0} value= {value} onChange={handleChange}/> */}
                                            <Rating sx={{ fontSize: '2.5rem', alignContent:"center", justifyContent:"center" }} name="mui-rating" value={value} onChange={handleChange}/>
                                                </div>
                                                <div className="main-6" style={{ marginTop: "30px" }}>
                                                    <textarea
                                                        type="textarea"
                                                        name="suggestions"
                                                        placeholder="Your Suggestion"
                                                         onChange={(e) => 
                                                          setFormData({ ...formData, anyImp: e.target.value }) 
                                                        } 
                                                        style={{
                                                            width: "100%",
                                                            padding: "10px 5px",
                                                        }}
                                                    />
                                                </div>
                                                <div className="main-6" style={{ marginTop: "30px" }}>
                                                    <textarea
                                                        type="textarea"
                                                        name="comments"
                                                        placeholder="Your Comments"
                                                        style={{
                                                            width: "100%",
                                                            padding: "10px 5px",
                                                        }}
                                                        onChange={(e) => 
                                                            setFormData({ ...formData, cmnts: e.target.value }) 
                                                          } 
                                                    />
                                                </div>
                                                <input
                                                    type="submit"
                                                    name="login"
                                                    id=""
                                                    value="Submit"
                        
                                                    style={{
                                                        width: "100%",
                                                        marginTop: "20px",
                                                        backgroundColor: "rgb(81 47 163)",
                                                        color: "white",
                                                        border: "none",
                                                        padding: "10px 10px",
                                                        borderRadius: "7px",
                                                    }}
                                                />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </MDBContainer>
                </div>
            </div>
        </div>
        </>
    );
}
export default Fdb;
