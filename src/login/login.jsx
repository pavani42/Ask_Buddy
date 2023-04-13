// import { faHandPointLeft } from '@fortawesome/free-solid-svg-icons';
import axios from "axios";
import React from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import HCLogo from "../images/HCLTech_Logo_3.png";
import Alert from "@mui/material/Alert";
import Ques_ans_pg from '../main_content/ques_ans_pg.jsx'

const Main = () => {
  const [formData, setFormData] = useState({});
  const [temp1, setTemp1] = useState("alert-display-none");
  const [temp2, setTemp2] = useState("alert-display-none");
  const [token , setToken]=useState();

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      // const response = await axios.post(
      //   "https://httpbin.org/anything",
      //   formData
      // );

      // const response = await axios.post(
      //   "https://httpbin.org/anything",
      //   formData
      // );
      const response = await axios("http://localhost:9090/login?id=" + formData.SapId + "&password=" + formData.Password, {
        method: "get",
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-Type": "application/json",
          mode: "no-cors",
        },
        data: formData,
      });
                         

      // axios("https://httpbin.org/anything",{method:'post',headers:{
      //   'Access-Control-Allow-Origin':'*','Content-Type':'application/json','mode':'no-cors'}},
      //   data:{formData}
      // );
      console.log(response.data);
      if (response.data == '401 : "{"message": "Bad credentials"}"')
       {
        localStorage.removeItem('token');
        setTemp2("alert-display");
        
      }
      else if(response.data == 'Invalid User Id or Password') 
      {
        localStorage.removeItem('token');
        setTemp2("alert-display");
        console.log(localStorage.getItem('token'))
      }
      else {
        setTemp1("alert-display");
        localStorage.setItem("token", JSON.stringify(response.data));
        setToken(response.data);
        // console.log(localStorage.getItem('token'));
        window.location.href = "/";
      }
    } catch (error) {
      console.error(error);
    }
  };
  return (
    <>
      <div className={temp1}>
        <Alert variant="filled" severity="success">
          Success!! Login successful !
        </Alert>
      </div>
      <div className={temp2}>
        <Alert variant="filled" severity="error">
          Invalid credentials !
        </Alert>
      </div>
      <form
        onSubmit={handleSubmit}
        id="form"
        style={{
          height: "100%",
          // background: "linear-gradient(hsl(240, 55%, 50%),black)",
        }}
      >
        {/*position: 'absolute',top:'0px',*/}
        <div
          className="main"
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <div
            className="main-2"
            style={{
            //  borderStyle:'groove',
              backgroundColor:'white',
              width: "400px",
              display: "flex",
              justifyContent: "center",
              borderRadius: "10px",
              position: "absolute",
              top: "15%",
            }}
          >
            <div
              className="main-3"
              style={{ padding: "0px 0px 30px 0px", width: "100%" }}
            >
              {/* <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/HCLTech-new-logo.svg/2560px-HCLTech-new-logo.svg.png" style={{width:'100%',color:'white'}}alt="" /> */}
              {/* <span style={{fontSize:'70px',color:'white',fontFamily: "'Helvetica', 'Arial', sans-serif"}}>HCLTech</span> */}
              <div className="login-logo" style={{backgroundColor:'rgb(95 30 190)',borderRadius:'7px 7px 0 0',padding:'10px'}}>
              <img
                src={HCLogo}
                alt=""
                style={{ width: "100%", margin: "20px 0 20px 0" }}
              />
              </div>
              <h4
                style={{
                  textAlign: "center",
                  fontFamily: "'Helvetica', 'Arial', sans-serif",
                  marginTop:'20px',
                  color:'black'
                }}
              >
                Login to continue
              </h4>
              <div className="main-4" style={{width:'100%',display:'flex',justifyContent:'center'}}>
                <div className="main-8" style={{width:'80%'}}>
                <div className="main-5" >
                  {/* <p style={{color:'white'}}>Emailid</p> */}
                  <input
                    required
                    type="number"
                    name="SapId"
                    onChange={(e) =>
                      setFormData({ ...formData, SapId: e.target.value })
                    }
                    style={{
                      width: "100%",
                      padding: "5px 5px",
                      marginTop: "15px",
                    }}
                    placeholder=" Sap ID"
                  />
                </div>
                <div className="main-6" style={{ marginTop: "10px" }}>
                  {/* <p style={{color:'white'}}>Password</p> */}
                  <input
                    required
                    type="password"
                    name="pass"
                    onChange={(e) =>
                      setFormData({ ...formData, Password: e.target.value })
                    }
                    placeholder=" Password"
                    style={{
                      width: "100%",
                      padding: "5px 5px",
                      marginTop: "15px",
                    }}
                  />
                </div>
                <input
                  type="submit"
                  name="login"
                  id=""
                  value="LOGIN"
                  style={{
                    width: "100%",
                    marginTop: "20px",
                    backgroundColor: "rgb(95 30 190)",
                    color: "white",
                    border: "none",
                    padding: "10px 10px",
                    borderRadius: "7px",
                  }}
                />
                <p
                  style={{
                    marginTop: "20px",
                    
                    fontFamily: "'Helvetica', 'Arial', sans-serif",
                  }}
                >
                  Not a member?{" "}
                  <Link to="/registration" style={{}} className='on-hover-bottom-text'>
                    <b>REGISTER HERE</b>
                  </Link>
                </p>
              </div>
              </div>
            </div>
          </div>
        </div>
      </form>
    </>
  );
};

export default Main;
