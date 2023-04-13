// import { Checkbox, FormControlLabel, FormLab\n\nel } from "@mui/material"; 
// import React from "react"; 
// import { Container, Row, Col, Form, FormGroup, Input } from "reactstrap"; 
import CommonSection from "../comman_section/common_section.jsx"; 
import { Link } from "react-router-dom"; 
import React from "react"; 
import { 
  MDBBtn, 
  MDBContainer, 
  MDBCard, 
  MDBCardBody, 
  MDBCardImage, 
  MDBRow, 
  MDBCol, 
  MDBInput, 
  MDBRadio, 
  MDBCheckbox, 
} from "mdb-react-ui-kit"; 
function App() { 
  return ( 
    <div className="join-us-main-3" style={{minHeight: 'calc(100vh - 107px)', marginTop : '60px'}}> 
      {/* <CommonSection title={"Join us"}></CommonSection> */} 
      <div 
        className="join-us-main-2" 
        style={{ width: "100%", display: "flex", justifyContent: "center" }} 
       > 
        <div 
          className="join-us-main-1" 
          style={{ marginTop: "30px" }} 
        > 
          {/* <CommonSection title="Join Us" /> */} 
          <MDBContainer fluid className=""> 
            <div 
              className="main" 
              style={{ backgroundColor: "white", borderRadius: "10px" }} 
            > 
              {/* <CommonSection title={"Join us"}></CommonSection> */} 
              <form 
                // onSubmit={handleSubmit} 
                id="form" 
                style={{ 
                  height: "100%", 
                }} 
              > 
                {/*position: 'absolute',top:'0px',*/} 
                <div 
                  className="cont-1-form" 
                  style={{ 
                    // display: "flex", 
                    // justifyContent: "center", 
                    // alignItems: "center", 
                    borderRadius: "10px", 
                  }} 
                > 
                  <div 
                    className="join-us-header" 
                    style={{ 
                      color: "white", 
                      display: "flex", 
                      justifyContent: "center", 
                      backgroundColor: "rgb(81 47 163)", 
                      width: "100%", 
                      borderRadius: "10px 10px 0 0", 
                    }} 
                  > 
                    <h1 style={{ padding: "20px" }}>Join us</h1> 
                  </div> 
                  <div 
                    className="main-2" 
                    style={{ 
                      backgroundColor: "white", 
                      width: "100%", 
                      display: "flex", 
                      justifyContent: "center", 
                      borderRadius: "0 0 10px 10px", 
                    }} 
                  > 
                    <div 
                      className="main-3" 
                      style={{ padding: "0px 0px 30px 0px", width: "80%" }} 
                    > 
                      <div className="main-4" style={{}}> 
                        <div 
                          className="main-5" 
                          style={{ 
                            display: "flex", 
                            marginTop: "30px", 
                          }} 
                        > 
                          {/* <p style={{color:'white'}}>Emailid</p> */} 
                          <input 
                            required 
                            type="firstName" 
                            name="firstName" 
                            // onChange={(e) => 
                            //   setFormData({ ...formData, Email: e.target.value }) 
                            // } 
                            style={{ 
                              width: "100%", 
                              padding: "5px 5px", 
                              marginRight: "10px", 
                            }} 
                            placeholder=" First Name" 
                          /> 
                          <input 
                            required 
                            type="lastName" 
                            name="lastName" 
                            // onChange={(e) => 
                            //   setFormData({ ...formData, Email: e.target.value }) 
                            // } 
                            style={{ 
                              width: "100%", 
                              padding: "5px 5px", 
                              marginLeftt: "10px", 
                            }} 
                            placeholder=" Last Name" 
                          /> 
                        </div> 
                        <div 
                          className="gender-join-us" 
                          style={{ marginTop: "30px" }} 
                        > 
                          <div 
                            className="join-us-gender-container" 
                            style={{ display: "flex" }} 
                          > 
                            <h7> 
                              <b>Gender:</b> 
                            </h7> 
                            <input 
                              className="form-check-input" 
                              type="radio" 
                              name="gender-radio" 
                              id="" 
                              style={{ marginLeft: "8px", marginRight: "5px" }} 
                            /> 
                            Male 
                            <input 
                              className="form-check-input" 
                              type="radio" 
                              name="gender-radio" 
                              id="" 
                              style={{ marginLeft: "8px", marginRight: "5px" }} 
                            /> 
                            Female 
                            <input 
                              className="form-check-input" 
                              type="radio" 
                              name="gender-radio" 
                              id="" 
                              style={{ marginLeft: "8px", marginRight: "5px" }} 
                            /> 
                            Other 
                          </div> 
                        </div> 
                        <div className="main-6" style={{ marginTop: "30px" }}> 
                          {/* <p style={{color:'white'}}>Password</p> */} 
                          <input 
                            required 
                            type="number" 
                            name="sap-id" 
                            // onChange={(e) => 
                            //   setFormData({ ...formData, Password: e.target.value }) 
                            // } 
                            placeholder=" SAP ID" 
                            style={{ 
                              width: "100%", 
                              padding: "5px 5px", 
                            }} 
                          /> 
                        </div> 
                        <div className="main-5" style={{ marginTop: "30px" }}> 
                          {/* <p style={{color:'white'}}>Emailid</p> */} 
                          <input 
                            required 
                            type="email" 
                            name="emailid" 
                            // onChange={(e) => 
                            //   setFormData({ ...formData, Email: e.target.value }) 
                            // } 
                            style={{ 
                              width: "100%", 
                              padding: "5px 5px", 
                            }} 
                            placeholder=" Email ID" 
                          /> 
                        </div> 
                        <div 
                          className="skills-join-us" 
                          style={{ marginTop: "30px" }} 
                        > 
                          <div className="join-us-skills-container"> 
                            <h7> 
                              <b>Skills:</b> 
                            </h7> 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Java" 
                              style={{ marginLeft: '5px' }} 
                            />Java 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Java" 
                              style={{ marginLeft: '5px' }} 
                            />C 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Java" 
                              style={{ marginLeft: '5px' }} 
                            />C++ 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Java" 
                              style={{ marginLeft: '5px' }} 
                            />.Net 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Java" 
                              style={{ marginLeft: '5px' }} 
                            />Php 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Python" 
                              style={{ marginLeft: '5px' }} 
                            />Python 
                            <br/> 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Springboot" 
                              style={{ marginLeft: '5px' }} 
                            />Springboot 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="React" 
                              style={{ marginLeft: '5px' }} 
                            />React 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="React" 
                              style={{ marginLeft: '5px' }} 
                            />Angular 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="React" 
                              style={{ marginLeft: '5px' }} 
                            />Nodejs 
                            <input 
                              class="form-check-input" 
                              type="checkbox" 
                              value="" 
                              id="Java" 
                              style={{ marginLeft: '5px' }} 
                            />Other 
                          </div> 
                        </div> 
                        <input 
                          type="submit" 
                          name="login" 
                          id="" 
                          value="JOIN" 
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
      / 
    </div> 
  ); 
} 
export default App; 
 