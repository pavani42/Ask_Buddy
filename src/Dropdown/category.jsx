import React, { useState } from 'react';
import { useEffect, useContext } from 'react';
// import axios from 'axios';
// import Subcategory from './subCategory'
// const Category = (prop) => { 

//     console.log(prop.data); 
  
//     const [options1, setOptions1] = useState([]);

//     const [selectedOption, setSelectedOption] = useState('');
  
//     const optionClicked=(val)=>{ 
  
//       console.log(val.target.innerText)  
//       setSelectedOption(val.target.innerText);
//       console.log(selectedOption);
  
//     } 

//     // const handleClick = async (event) => {
//     //   const selectedValue = event.target.value;
//     //   const options1Response = await axios.get('/api/options1'); // replace with your Spring Boot endpoint
//     //   const options2Response = await axios.get(`/api/options2?selectedValue=${selectedValue}`); // replace with your Spring Boot endpoint
//     //   setOptions1(options1Response.data);
//     //   setOptions2(options2Response.data);
//     // };
    
//     const handlesubmit = async(event) =>{
//       const options1Response = await axios.get('http://localhost:8083/getCategoryList'); 
//       console.log(options1Response); 
//       setOptions1(options1Response.data);
//     };
     
  
//     return ( 
  
//       <> 
  
//         <div class="dropdown"> 
  
//           <button 
  
//             class="btn btn-secondary dropdown-toggle" 
  
//             type="button" 
  
//             id="dropdownMenuButton" 
  
//             data-toggle="dropdown" 
  
//             aria-haspopup="true" 
  
//             aria-expanded="false" 
  
//             style={{color:'rgb(95, 30, 190)',backgroundColor:'#e3ebf7',width:'120px',margin:'10px'}} 

//             onClick = {handlesubmit}
  
//           > 
  
//             category 
  
//           </button> 
  
//           <div 
  
//             class="dropdown-menu" 
  
//             aria-labelledby="dropdownMenuButton" 
  
//             style={{ 
  
//               width: "200px", 
  
//               maxHeight: "200px", 
  
//               overflowY: "scroll", 
  
//               wordWrap: "break-word", 
  
//             }} 
  
//           > 
  
//             {/* {prop.data.map((val) => {  }
  
//               {/* return (  */}
  
//                   {/* <span class="dropdown-item" href="#" onClick={optionClicked}>   */}
  
//                   {/* {val.name}  */}
  
//                 {/* </span>  */}
  
//               {/* );  */}
  
//             {/* })}  */}

//             {options1.map((val) => {  
//               return (
//                 <span class="dropdown-item" href="#" onClick={optionClicked}>  
//                      {val.cat_name}
//                      </span>
//               );
//             })}
  
             
  
//           </div> 
  
//         </div> 

//         <div>
//       <Subcategory data={selectedOption} />
//     </div>
  
//       </> 
  
//     ); 
  
//   }; 
  
//   export default Category; 
  
   
import { Link } from 'react-router-dom';
import axios from 'axios'; 


const Main = (prop) => { 

  const [formData, setFormData] = useState([]);
  // console.log(prop.data); 

  // const optionClicked=(val)=>{ 

  //   console.log(val.target.innerText) 

  //   localStorage.setItem('filteredItem' , val.target.innerText); 

  // } 

  console.log(localStorage.getItem('filteredItem'));
  const onPuttingInput = (p) => {
    // console.log(p.target.value);
    axios.get('http://localhost:8083/getCategoryList')
      .then(response => {
        const dataArray = response.data;
        //  console.log(response);
        //  setData(dataArray); 
         console.log(dataArray)
        setFormData(dataArray)
      })
    // setVal(p.target.value);
    console.log(formData)
  }

  useEffect(onPuttingInput, []);
  // localStorage.setItem('filteredItem' , 'Java'); 

  return ( 

    <> 

      <div class="dropdown"> 

        <button 

          class="btn btn-secondary dropdown-toggle" 

          type="button" 

          id="dropdownMenuButton" 

          data-toggle="dropdown" 

          aria-haspopup="true" 

          aria-expanded="false" 

          style={{color:'rgb(95, 30, 190)',backgroundColor:'#e3ebf7',width:'120px',margin:'10px'}} 

        > 

          category 

        </button> 

        <div 

          class="dropdown-menu" 

          aria-labelledby="dropdownMenuButton" 

          style={{ 

            width: "200px", 

            maxHeight: "200px", 

            overflowY: "scroll", 

            wordWrap: "break-word", 

          }} 

        > 

{formData.map((val) => {  
              return (
                <span class="dropdown-item" href="#" onClick={prop.functionChangeDetect}>  
                     {val.cat_name}
                     </span>
              );
            })}

           

        </div> 

      </div> 

    </> 

  ); 

}; 

export default Main; 

 
 