import axios from 'axios';
import { useState } from 'react';
// import NavDropdown from "react-bootstrap/NavDropdown";
// import data from '../Dummy_data/data.jsx';
import Card from '../Ques_ans_card/Card.jsx';
import React, { useEffect, useContext } from "react";
import fetchData from '../FetchingDataFromApi/context.jsx'
import Category from '../Dropdown/category.jsx';
import SubCategory from '../Dropdown/subCategory.jsx';
import { faFilter } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button } from 'reactstrap';
const Main = () => {
  const [formData, setFormData] = useState({});
  const [formData1, setFormData1] = useState({});
  const [closeModal, setCloseModal] = useState('');
  const [selectedOption, setSelectedOption] = useState('');
  const [filter, setFilter] = useState('display-none');
  const [css, setCss] = useState('display-none');
  const [catDropDownTitle, setCatDropDownTitle] = useState("category");
  // const [data,setData]=useState([]);
  const data = useContext(fetchData);
  const selectChange = (e) => {
    setSelectedOption(e.target.value);
    setFormData({ ...formData, Category: e.target.value });
  }

  const filterApplied = () => {
    window.location.href = "/filtered-search"
  }
  const [array, setArray] = useState([]);
  const changeCategorySubcategory = (val) => {
    // console.log(val.target.innerText);
    localStorage.setItem('category', val.target.innerText);
    setCatDropDownTitle(val.target.innerText);
    axios.get('http://localhost:8083/getSubCategoryList/' + val.target.innerText)
      .then(response => {
        const dataArray = response.data;
        console.log(response);
        //  setData(dataArray); 
        console.log(dataArray)
        setFormData1(dataArray)
      });
  }
  console.log(formData1)
  console.log(localStorage);
  //   const fetchAPI=()=>{axios("http://localhost:9090/latestQuestion", {
  //     method: "get",
  //     headers: {    
  //       "Access-Control-Allow-Origin": "*",
  //       "Content-Type": "application/json",
  //       mode: "no-cors",
  //     },  //   }).then((res) => {
  //     setData(res.data);
  //     console.log(res.data);
  //   });
  // };     
  // useEffect(fetchAPI ,[]);  console.log(data); 

  // const changeDetectCatSubcat = (val) => {

  //   console.log(val.target.innerText);

  //   // localStorage.setItem('category',val.target.innerText)

  //   // setCss("");

  //   setCatDropDownTitle(val.target.innerText);

  // };
  const submitHandle = async (event) => {
    event.preventDefault();
    if (localStorage.getItem('token') == null) {
      window.alert("Please login to post the question!");
      // window.location.href = '/login';
    }
    // else 
    const user = JSON.parse(localStorage.getItem('token'));
    console.log('Bearer ' + user);
    const response = await axios("http://localhost:8083/postQuestion?category=" + localStorage.getItem('category') + "&sub_Category=" + localStorage.getItem('subcategory') + "&question= " + encodeURIComponent(formData.Question) + "&questionDescription=" + encodeURIComponent(formData.Detailed_Question), {
      method: "post",
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json",
        "Authorization": "Bearer " + user,
        mode: "no-cors",
      },
    });
    console.log(response);
    if (response.status == 200) {
      setTimeout(function () {
        document.getElementById("modalCloseButton").click();
        alert("Successfully Posted")
      }, 300);
    }
    else if (response.status == 400) {
      setTimeout(function () {
        document.getElementById("modalCloseButton").click();
        alert("Please Login");
      }, 300);
    }
    else if (response.status == 401) {
      alert("time out");
    }

    // else if(response.status)
  }
  const filterClick = () => {
    if (filter === "none") {
      setFilter("display-none");
    } else {
      setFilter("none");
    }
  }; return (
    <>
      {/* <h1 style={{height:"700px"}}>body</h1> */}      {/* ////////////////////////////////////////////////////////////modal//////////////////////////////////////////////////////////////// */}
      <form onSubmit={submitHandle}>
        <div className="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header" style={{ backgroundColor: 'rgb(95 30 190)' }}>
                <h5 className="modal-title" id="exampleModalLabel" style={{ color: 'white' }}>Ask a question</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close" style={{ border: 'none', fontSize: '25px', backgroundColor: 'rgb(95 30 190)', color: 'white' }}>
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                {/* <form> */}
                {/* <div className="dropdown" style={{marginBottom:'15px'}}> */}
                {/* <select required value={selectedOption} style={{ color: 'rgb(95 30 190)' }} className="btn btn-secondary dropdown-toggle" onChange={selectChange} type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <option className="dropdown-item" value="">---Select Category---</option>
                  <option className="dropdown-item" value="language">Language</option>
                  <option className="dropdown-item" value="framework">Framework</option>
                  <option className="dropdown-item" value="Technology">Technology</option>
                  <option className="dropdown-item" value="other">Other</option>
                </select> */}
                <div style={{ display: "flex" }}>
                  <Category functionChangeDetect={changeCategorySubcategory} />
                  <SubCategory array={formData1} css={css} />
                </div>
                {/* <div style={{ display: "flex" }}>

<Category />

<SubCategory />

</div> */}

                {/* </div>                 */}
                <div className="form-group">
                  <label for="question-asked" className="col-form-label" style={{ color: 'black' }}>Title</label>
                  <input required type="text" className="form-control" id="question-asked" name='question' onChange={(e) => setFormData({ ...formData, Question: e.target.value })} />
                </div>
                <div className="form-group">
                  <label for="message-text" className="col-form-label" style={{ color: 'black' }}>Details of question</label>
                  <textarea required type="text" className="form-control" id="message-text" name="detailed-question" onChange={(e) => setFormData({ ...formData, Detailed_Question: e.target.value })}> </textarea>
                </div>
                {/* </form> */}
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" id="modalCloseButton" data-dismiss="modal">Close</button>
                <button type="submit" className="btn btn-primary" style={{ backgroundColor: 'rgb(95, 30, 190)' }}>ASK</button>
              </div>
            </div>
          </div>
        </div>
      </form>
      {/* ////////////////////////////////////////////////////////////modal//////////////////////////////////////////////////////////////// */}      <div className="body-main-content" style={{ width: '100%', display: 'flex', justifyContent: 'center', marginBottom: '20px' }}>
        <div className="ques-ans-page-2 height-1" style={{ backgroundColor: 'white' }}>
          <div className="list-group w-100" >
            <div className="body-main-2" style={{ display: "flex", justifyContent: "space-between", margin: '0 10px 0 10px' }}>
              <h1 style={{ margin: "40px 10px 20px 0px", color: 'black' }}>
                Top Questions</h1>
              {/* <a class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" className="" href="#" style={{ backgroundColor: "rgb(60 145 255)", width: "120px", padding: "17px 10px 10px 10px", color: "white", height: "60px", margin: "auto 10px auto 0", borderRadius: "5px", textDecoration: "none" }}>Ask Question</a> */}
              <div style={{ display: "flex", marginTop: '40px' }}>
                {/* <Category/>
                <SubCategory/> */}
                <button className="btn btn-secondary" style={{ marginRight: "10px", border: "none", backgroundColor: "#e3ebf7", color: "rgb(95 30 190)", height: "40px", borderRadius: "5px", }} onClick={filterClick}
                >
                  <FontAwesomeIcon icon={faFilter} />

                </button>
                <a class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" href="#" style={{ backgroundColor: "rgb(60 145 255)", width: "120px", padding: "12px 10px 10px 10px", color: "white", height: "40px", borderRadius: "5px", textDecoration: "none", }}>
                  Ask Question
                </a>
              </div>
            </div>
          </div>
          <div

            style={{

              height: "120px",

              backgroundColor: "rgb(242 242 243)",

              margin: "5px",

            }}

            className={filter}

          >

            <div style={{ display: "flex" }}>

              <Category functionChangeDetect={changeCategorySubcategory} header = {catDropDownTitle}/>

              <SubCategory array={formData1} css={css} />

            </div>




            <div>

              <Button

                class="btn btn-primary"


                onClick={filterApplied}

                style={{

                  backgroundColor: "rgb(60 145 255)",

                  width: "120px",

                  padding: "12px 10px 10px 10px",

                  color: "white",

                  height: "40px",

                  borderRadius: "5px",

                  textDecoration: "none",

                  margin: "10px",

                }}

              >
                Apply Filter
              </Button>
            </div>
            {/* <h1>HIIIIII</h1> */}
          </div>
          <div className="ques-ans-content-1">
            {data.data.map((val) => {
              return (
                <Card
                  A={val.question.question}
                  B={val.answerList.description}
                />
              );
            })}
          </div>
        </div>
      </div>
    </>
  );
};
export default Main;
