import React from "react";
import { MDBContainer } from "mdb-react-ui-kit";
import { useState } from 'react';
import { Rating, Typography } from "@mui/material";
import { Box } from "@mui/system";
import Alert from '@mui/material/Alert';
import axios from "axios";

function ConUs() {
    const [formData, setFormData] = useState({});
    const [temp1,setTemp1] = useState("alert-display-none");
    const [temp2,setTemp2] = useState("alert-display-none");
    const submitHandle = async (event) => {
        event.preventDefault();
        console.log(formData);
        try {
    const response = await axios("http://localhost:9090/contactUs/postQuery", {
        method: "post",
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-Type": "application/json",
          mode: "no-cors",
        },
        data: formData,
      });
  console.log(response.data);
  if(response.data != null){
    setTemp1("alert-display");
  document.getElementById("contactform").reset();
    // window.location.href = '/login';
  }else {
    setTemp2("alert-display");
  }
} catch (error) {
    console.error(error);
  }
}

    const [value, setValue] = React.useState(2);
    return (
        <div className="join-us-main-3" style={{}}>
             <div  className={temp1}>
    <Alert variant="filled" severity="success" >
      Posted Successfully!!
    </Alert>
    </div>
    <div  className={temp2}>
    <Alert variant="filled" severity="error" >
      User already exist !
    </Alert>
    </div>
            <div className="join-us-main-2" style={{ width: "100%", display: "flex", justifyContent: "center", minHeight: 'calc(100vh - 107px)', marginTop : '60px'}}>
                <div className="join-us-main-1" style={{ marginTop: "30px" }}>
                    <MDBContainer fluid className="">
                        <div className="main" style={{ backgroundColor: "white", borderRadius: "10px" }}>
                            <form 
                               onSubmit={submitHandle}  
                                id="contactform" style={{ height: "100%", }}>
                                <div className="cont-1-form" style={{
                                    // display: "flex", 
                                    // justifyContent: "center", 
                                    // alignItems: "center", 
                                    borderRadius: "10px",
                                }}>
                                    <div className="join-us-header" style={{
                                        color: "white",
                                        display: "flex",
                                        justifyContent: "center",
                                        backgroundColor: "rgb(81 47 163)",
                                        width: "100%",
                                        borderRadius: "10px 10px 0 0",
                                    }}>
                                        <h1 style={{ padding: "20px" }}>Contact Us</h1>
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
                                                <div className="main-6" style={{ marginTop: "30px" }}>
                                                    {/* <p style={{color:'white'}}>Password</p> */}
                                                    <input required type="text" name="name"
                                                        onChange={(e) => 
                                                          setFormData({ ...formData, name: e.target.value }) 
                                                        } 
                                                        placeholder=" Name"
                                                        style={{
                                                            width: "100%",
                                                            padding: "5px 5px",
                                                        }}
                                                    />

                                                </div>
                                                <div className="main-6" style={{ marginTop: "30px" }}>
                                                    {/* <p style={{color:'white'}}>Password</p> */}
                                                    <input required type="number" name="sap-id"
                                                        onChange={(e) => 
                                                          setFormData({ ...formData, sap_Id: e.target.value }) 
                                                        } 
                                                        placeholder=" SAP ID"
                                                        style={{ width: "100%", padding: "5px 5px", }} />
                                                </div>
                                                <div className="main-6" style={{ marginTop: "30px" }}>
                                                    <textarea required type="textarea" name="suggestions" onChange={(e) => 
                                                          setFormData({ ...formData, query: e.target.value }) 
                                                        } placeholder="Your Queries" style={{ width: "100%", padding: "10px 5px", }} />
                                                </div>
                                                <input type="submit" name="login" id="" value="Send" style={{
                                                    width: "100%", marginTop: "20px", backgroundColor: "rgb(81 47 163)",
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
    );
}
export default ConUs;

