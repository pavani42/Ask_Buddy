// import Data from '../Dummy_data/data.jsx'
// import { useState } from 'react';
// import { Link } from 'react-router-dom';
// import axios from 'axios';
// const Main = () => {
//   const [val , setVal] = useState('');
//   const [formData, setFormData] = useState([]);
//   const submitSearch=(que)=>{
//     console.log(que);
//   }

//   const onPuttingInput=(p)=>{
//     console.log(p);
//     axios.get('http://localhost:8083/searchQuestionByKeyword/' + encodeURIComponent(p.target.value))
//      .then(response => { 
//       const dataArray = response.data; 
//       console.log(response);
//       setFormData(dataArray);
//       })
//     // setVal(p.target.value);
//     console.log(formData)
//   }
//     return (
//       <>
//       <div class="dropdown-search show" >

//         <form
//           className="searchbox-main-4"
//           id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"

//           onSubmit={()=>submitSearch(val)}
//           style={{

//             marginLeft:"10px",
//             marginRight:"10px",
//             marginTop:"58.5px"
//           }}
//         >
//           <div className="searchbox-main-5" style={{ display: "flex", height: "100%" }}>
//             <input
//             onChange={onPuttingInput}
//               type="text"
//               className="fa"
//               placeholder="  Search questions here..."
//               style={{ border: "none",margin: "15px 0px 6px 0px", width: "100%", height: "50px",borderRadius:"6px",paddingLeft:"10px",fontFamily:"'Helvetica', 'Arial', sans-serif"}}
//             />
//           </div>
//         </form>
//         <div class="dropdown-menu" aria-labelledby="dropdownMenuLink" style={{width:'95%'}}>

//             {/* {Data.filter((item)=>{
//               const searchTerm = val.toLowerCase();
//               const fullQues = item.Ques.toLowerCase();
//               return searchTerm && fullQues.startsWith(searchTerm);

//             }).slice(0,5).map((item)=>( */}
//               {formData.slice(0, 5).map((item) => (
//               <Link class="dropdown-item" to={`/${encodeURIComponent(item.question.questions)}`}>{item.question.question}</Link>
//             ))}
//           </div>
//       </div>
//         {/* <h1>HI</h1> */}
//       </>
//     );
//   };
//   export default Main;

import Data from "../Dummy_data/data.jsx";

import { useState } from "react";

import axios from 'axios';
import { Link } from "react-router-dom";

const Main = () => {

  const [val, setVal] = useState("");
  const [formData, setFormData] = useState([]);
  const onPuttingInput = (p) => {
    // console.log(p.target.value);
    axios.get('http://localhost:9191/api/questions/searchQuestionByKeyword/' + encodeURIComponent(p.target.value))
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

  const submitSearch = (que) => {

    console.log(que);

  };

  const Passed = (val) => {

    // console.log('hi'); 

    if (val.key === 'Enter') {

      // setSearchedWord(val.target.value); 

      localStorage.setItem('searched', val.target.value);

      window.location.href = "http://localhost:3000/personalized-search";




    }



  }

  // const onPuttingInput = (p) => {

  //   // console.log(p.target.value); 

  //   setVal(p.target.value);

  // };

  return (

    <>



      <div className="searchBox-2" style={{ width: "100%" }}>

        <div

          // onSubmit={() => submitSearch(val)} 

          onKeyDown={Passed}

          className="searchbox-main-4"

          style={{

            marginLeft: "10px",

            marginRight: "10px",

            marginTop: "58.5px",

          }}

        >

          <div className="searchbox-main-5" style={{ display: "flex", height: "100%" }}>

            <input

              onChange={onPuttingInput}

              type="text"

              className="fa "

              placeholder="  Search questions here..."

              style={{

                margin: "15px 0px 6px 0px",

                width: "100%",

                height: "50px",

                paddingLeft: "10px",

                borderRadius: "7px",

                border: "none",

                fontFamily: "'Helvetica', 'Arial', sans-serif",

              }}

            />

          </div>

        </div>

        <div

          class="search-bar-dropdown-mob"

          // aria-labelledby="dropdownMenuLink" 

          style={{

            boxShadow: '5px',

            position: "absolute",

            left: '12px',

            width: "95%",

            zIndex: '100'

          }}

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

        </div>

      </div>

      {/* <h1>HI</h1> */}

    </>

  );

};

export default Main;




