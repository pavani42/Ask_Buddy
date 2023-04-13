import { Link } from 'react-router-dom';
import Divider from '@mui/material/Divider';
import { useEffect, useContext } from 'react';
import { useState } from 'react';
import Data from '../Dummy_data/data.jsx';
import fetchData from '../FetchingDataFromApi/context.jsx';
import axios from 'axios';
import { faUser } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Card from '../Ques_ans_card/Card.jsx';
// import AccountCircleRoundedIcon from '@mui/icons-material/AccountCircleRounded';
// import PermIdentityOutlinedIcon from '@mui/icons-material/PermIdentityOutlined';

const Main = () => {
  const [val, setVal] = useState('');
  const data = useContext(fetchData);
  const [formData, setFormData] = useState([]);
  // console.log(data);
  const submitSearch = (que) => {
    console.log(que);
  }

  const onPuttingInput = (p) => {
    // console.log(p.target.value);
    axios.get('http://localhost:8083/searchQuestionByKeyword/' + encodeURIComponent(p.target.value))
      .then(response => {
        const dataArray = response.data;
        //  console.log(response);
        //  setData(dataArray); 
        //  console.log(dataArray)
        setFormData(dataArray)
      })
    setVal(p.target.value);
    console.log(formData)
  }
  const logoutClick = () => {
    console.log("hello")
    localStorage.removeItem('token');
    window.location.reload();
  };
  console.log(localStorage.getItem("token"))
  // localStorage.removeItem("token");
  const [profileFlag2, setProfileFlag2] = useState(localStorage.getItem("token") == null ? "display-none" : "p");
  const [profileFlag1, setProfileFlag1] = useState(localStorage.getItem("token") != null ? "display-none" : "p");

  const Passed = (val) => {

    // console.log('hi')

    if (val.key === 'Enter') {

      // setSearchedWord(val.target.value);

      localStorage.setItem('searched', val.target.value);

      window.location.href = "http://localhost:3000/personalized-search";




    }

  }
  return (
    <>
      {/* <h1>nav</h1> */}
      <div className="cover-resp" style={{
        position: "fixed",
        top: "0",
        zIndex: "100",
        boxShadow: '1px 1px 10px 1px', background:
          "linear-gradient(90deg,rgb(95 30 190) 10%,rgb(60 145 255))",
        width: '100%',
        display: 'flex',
        justifyContent: 'center'
      }}>
        <div
          className="main-1"
          style={{

            display: "flex",
            justifyContent: "space-between",
            // width:"100%",
            // position:"fixed",
            // top:"0",
            // zIndex:"100",
            // boxShadow:'1px 1px 10px 1px'

          }}
        >
          <div className="nav-content-5" style={{ display: 'flex' }}>
            <span className="main-1-logo"
              style={{
                color: "white",
                fontFamily: "'Helvetica', 'Arial', sans-serif",
                margin: "3px 10px 3px 10px",
              }}
            >
              <Link to="/" style={{ textDecoration: 'none', color: 'white' }}><b>HCLTech</b></Link>
            </span>


            {/* <div class="dropdown-search show" >
              <form
                onSubmit={() => submitSearch(val)}
                className="nav-content-1"
                id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                style={{
                  width: '100%',
                  border: "none",
                  height: '100%',
                  marginRight: '15px'
                }}
              >
                <div className=""

                  style={{ display: "flex", height: "100%" }}

                >
                  <input
                    onChange={onPuttingInput}
                    type="text"
                    className="fa "
                    placeholder="  Search questions here..."
                    style={{ margin: "6px 0px 6px 0px", width: "100%", height: "80%", paddingLeft: "10px", borderRadius: "7px", border: "none", fontFamily: "'Helvetica', 'Arial', sans-serif" }}
                  />
                </div>

              </form>
              <div class="dropdown-menu" aria-labelledby="dropdownMenuLink" style={{ boxShadow: '1px 1px 5px 1px' }}>

                {formData.slice(0, 5).map((item) => (
                  <Link class="dropdown-item" to={`/${encodeURIComponent(item.question.question)}`}>{item.question.question}</Link>
                ))}
              </div>
            </div> */}
            <div className="searchBox-2" style={{ width: '100%' }}>

              <div

                onKeyDown={Passed}

                className="nav-content-1"



                style={{

                  width: "100%",

                  border: "none",

                  height: "100%",

                  marginRight: "15px",

                }}

              >

                <div className="" style={{ display: "flex", height: "100%" }}>

                  <input

                    onChange={onPuttingInput}

                    type="text"

                    className="fa "

                    placeholder="  Search questions here..."

                    style={{

                      margin: "6px 0px 6px 0px",

                      width: "100%",

                      height: "80%",

                      paddingLeft: "10px",

                      borderRadius: "7px",

                      border: "none",

                      fontFamily: "'Helvetica', 'Arial', sans-serif",

                    }}

                  />

                </div>

              </div>

              <div

                class="search-bar-dropdown"

                // aria-labelledby="dropdownMenuLink" 

                style={{ boxShadow: "1px 1px 5px 1px", position: 'absolute', width: '56.7%' }}

              >

               {
                  formData.map((item) => (

                    <div style={{ backgroundColor: 'white', padding: '5px', width: '100%' }}>

                      <Link

                        class=""

                        to={`/${encodeURIComponent(item.question.question)}`}

                      >

                        {item.question.question}

                      </Link>

                    </div>

                  ))}

                {/* {formData.slice(0, 5).map((item) => (
                  <Link class="dropdown-item" to={`/${encodeURIComponent(item.question.question)}`}>{item.question.question}</Link>
                ))} */}

              </div>

            </div>


          </div>
          <div className="nav-content-4" style={{ display: 'flex' }}>
            <div className="nav-content-3" style={{ marginRight: '20px' }}>
              <div className="" style={{ display: 'flex', justifyContent: 'space-around', marginTop: '18px' }}>
                <Link to='/ques-ans-page' className='on-hover-nav-content' style={{}}>GetStarted</Link>
                <span style={{ margin: '0 18px 0 18px', color: 'white' }}>|</span>
                <Link to='/faq' className='on-hover-nav-content'>FAQ's</Link>
                <span style={{ margin: '0 18px 0 18px', color: 'white' }}>|</span>
                <Link to='/join-us' className='on-hover-nav-content'>JoinUs</Link>

              </div>
            </div>
            <div className={profileFlag1}>
              <Link to="/login"><button className="nav-content-4"
                style={{
                  margin: "12px 8px 8px 0px",
                  backgroundColor: "rgb(95 30 190)",
                  color: "white",
                  border: "none",
                  borderRadius: "5px",
                  padding: '0 15px 0 15px',
                  height: "60%",
                  fontSize: ".86rem",
                }}
              >
                Login
              </button></Link>

            </div>

            <div className={profileFlag2}>
              <Link to="/profile">
                <button className="nav-content-4"
                  style={{
                    textAlign: "center", margin: "8px 10px 8px 0px", backgroundColor: "rgb(95 30 190)", color: "white", border: "none", borderRadius: "50%",
                    // padding: "0 15px 0 15px",             
                    height: "45px", width: "45px",
                    fontSize: "20px",
                  }}>
                  <FontAwesomeIcon icon={faUser} className="userIconMid" />
                </button></Link></div>

          </div>

          <button
            class="my-offcanvas-1"
            type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasRight"
            aria-controls="offcanvasRight"
            style={{ color: "white", fontSize: "30px" }}
          >
            <i class="fa">&#xf0c9;</i>

          </button>

          <div
            class="offcanvas offcanvas-end"
            tabindex="-1"
            id="offcanvasRight"
            aria-labelledby="offcanvasRightLabel"
          >
            <div class="offcanvas-header">


              <button
                type="button"
                class="btn-close text-reset"
                data-bs-dismiss="offcanvas"
                aria-label="Close"
              ></button>
            </div>
            {/* <Link to="/login" style={{ width: "100%", display: "flex", justifyContent: "center", textDecoration: "none" }}><button className="nav-content-5"
              style={{
                margin: "10px 0 10px 0",
                backgroundColor: "rgb(81 47 163)",
                color: "white",
                border: "none",
                borderRadius: "3px",

                height: "90%",
                width: "90%",

              }}
            >
              Login
            </button></Link> */}
            <div className={profileFlag1} style={{ width: "100%" }}>
              <div
                style={{
                  display: "flex", justifyContent: "center", width: "100%",
                }}
              >
                <Link to="/login" style={{ width: "80%" }}>
                  <button className="" style={{ width: "100%", backgroundColor: "rgb(95 30 190)", color: "white", border: "none", borderRadius: "5px", padding: "0 15px 0 15px", height: "30px", fontSize: ".86rem", }}
                  >
                    Login
                  </button>
                </Link>

              </div>
            </div>
            <div className={profileFlag2}
            // style={{ display: "flex", justifyContent: "center" }}     
            >
              <div style={{ display: "flex", justifyContent: "center" }}>
                <Link to="/profile">
                  <button className="nav-content-5" style={{
                    textAlign: "center", backgroundColor: "rgb(95 30 190)", color: "white", border: "none", borderRadius: "50%",
                    // padding: "0 15px 0 15px",            
                    height: "45px",
                    width: "45px", fontSize: "20px",
                  }}
                  >
                    {/* <AccountCircleRoundedIcon fontSize="large" sx={{ fontSize: 40, color:'rgb(95 30 190)'}} /> */}
                    <FontAwesomeIcon icon={faUser} className="userIconMid" />
                  </button>
                </Link>
              </div>
            </div>
            <div className="off-canvas-content-1" style={{ marginTop: '30px' }}>
              <Divider />
              <Link to="/ques-ans-page" style={{ margin: '10px 0 10px 0', textDecoration: 'none', color: 'black', display: 'flex', justifyContent: 'center' }}>Get Started</Link>
              <Divider />
              <Link to="/faq" style={{ margin: '10px 0 10px 0', textDecoration: 'none', color: 'black', display: 'flex', justifyContent: 'center' }}>FAQ's</Link>
              <Divider />
              <Link to="/join-us" style={{ margin: '10px 0 10px 0', textDecoration: 'none', color: 'black', display: 'flex', justifyContent: 'center' }}>Join us</Link>
              <Divider />
              <Link to="/contact-us" style={{ margin: '10px 0 10px 0', textDecoration: 'none', color: 'black', display: 'flex', justifyContent: 'center' }}>Contact</Link>

              <Divider />
            </div>

            {/* <p style={{ margin: '10px 0 10px 0', color: '#ff0000', display: 'flex', justifyContent: 'center' }}><b>Logout</b></p> */}
            <div className={profileFlag2}
              style={{
                width: "100%",
                // display: "flex",      
                // justifyContent: "center",    
                textDecoration: "none",
              }} >
              <div style={{ display: "flex", justifyContent: "center" }}>
                <button onClick={logoutClick}
                  className="nav-content-5" style={{
                    margin: "10px 0 10px 0",
                    backgroundColor: "white",
                    color: "#ff0000",
                    border: "none",
                    borderRadius: "3px",
                    height: "90%",
                    width: "90%",
                  }}
                >     Logout
                </button>
              </div>
            </div>

          </div>





        </div>
      </div>

    </>
  );
};
export default Main;
