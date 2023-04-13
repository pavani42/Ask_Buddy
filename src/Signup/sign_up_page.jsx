// import { faHandPointLeft } from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';
import React from 'react';
import { useState } from 'react';
import { Link } from "react-router-dom";
import HCLogo from '../images/HCLTech_Logo_3.png';
import Alert from '@mui/material/Alert';
import '../Signup/signup.css';
const Main=()=> {
  
  const [formData, setFormData] = useState({});
  const [temp1,setTemp1] = useState("alert-display-none");
  const [temp2,setTemp2] = useState("alert-display-none");

  const handleSubmit=async(event)=> {
    event.preventDefault();
    try {
      // const response = await axios.post('/register', formData);
      console.log(formData);
      const response = await axios("http://localhost:8086/register", {
        method: "post",
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-Type": "application/json",
          mode: "no-cors",
        },
        data: formData,
      });
      console.log(response);
      if(response.data == true){
        setTemp1("alert-display");
        window.location.href = '/login';
      }else if(response.data == false){
        setTemp2("alert-display");
      }
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <>
    <div  className={temp1}>
    <Alert variant="filled" severity="success" >
      Success!! Account created successfully, you can LOGIN now.
    </Alert>
    </div>
    <div  className={temp2}>
    <Alert variant="filled" severity="error" >
      User already exist !
    </Alert>
    </div>
    <form onSubmit={handleSubmit} id="form" style={{height:'100%',backgroundColor:'#EBEAEA'}}>
      <div className="registration-main" style={{display:'flex',justifyContent:'center',alignItems:'center'}} >
        <div className="registration-main-2" style={{width:'400px',display:'flex',justifyContent:'center',borderRadius:'10px',marginTop:'10vh',marginBottom:'20px',backgroundColor:'white'}}>
          <div className="registration-main-3" style={{padding:'0px 0px 30px 0px',width:'100%'}}>
            {/* <span style={{fontSize:'70px',color:'white',fontFamily: "'Helvetica', 'Arial', sans-serif"}}>HCLTech</span> */}
            <div className="registration-logo" style={{backgroundColor:'rgb(95 30 190)',borderRadius:'10px 10px 0 0',padding:'10px'}}>
              <img src={HCLogo} alt="" style={{width:'100%',margin:'20px 0 20px 0'}}/>
            </div>
            <h4 style={{color:'black',textAlign:'center',marginTop:'20px'}}>Register here for AskBuddy</h4>
            <div className="registration-main-4" style={{width:'100%',display:'flex',justifyContent:'center'}}>
              <div className="registration-9" style={{width:'80%'}}>
              <div className="registration-main-7"style={{}}>
                <input required type="number"  name='sapid' onChange={(e) => setFormData({ ...formData, sap_Id: e.target.value })} style={{width:'100%',padding:'5px 5px',marginTop:'20px'}} placeholder=' SAP ID' />
              </div>
              <div className="registration-main-5"style={{}}>
               
                <input required type="email"  name='emailid' onChange={(e) => setFormData({ ...formData, mail: e.target.value })} style={{width:'100%',padding:'5px 5px',marginTop:'20px'}} placeholder=' Email ID' />
              </div>
              <div className="registration-main-8"style={{}}>
                
                <input required type="" name= 'username' onChange={(e) => setFormData({ ...formData, username: e.target.value })} style={{width:'100%',padding:'5px 5px',marginTop:'20px'}} placeholder=' User Name'/>
              </div>
              <div className="registration-main-6">
               
                <input required type="password" name='pass' onChange={(e) => setFormData({ ...formData, password: e.target.value })}  placeholder=' Password' style={{width:'100%',padding:'5px 5px',marginTop:'20px'}}/>
              </div>
              
              <input type="submit" name="register" id="" value="REGISTER"  style={{width:'100%',marginTop:'20px',backgroundColor:'rgb(95 30 190)',color:'white',border:'none',padding:'10px 10px',borderRadius:'7px'}} />
              <div className="registration-main-7 " style={{display:'flex',marginTop:'10px'}}><p style={{}}>Already Have Account? <Link to="/login" style={{}} className='on-hover-bottom-text'><b>LOGIN HERE</b></Link></p></div>
            </div>
            </div>
          </div>
        </div>
      </div>
    </form>
    
    </>
  );
}


export default Main;