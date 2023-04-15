import React, { useCallback, useState } from 'react';
import { useEffect, useContext } from 'react';
// import axios from 'axios';
// const SubCategory = (prop) => {  
    
//   const [options1, setOptions1] = useState([]);

//     console.log(prop.data); 
//     const optionClicked=(val)=>{   
//       console.log(val.target.innerText)  
//       // console.log(prop.data);  
//     } 


//     const handlesubmit = async(event) =>{
//       console.log("comming here");
//       const options1Response = await axios.get('http://localhost:8083/getSubCategoryList/' + prop.data); 
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
  
//             sub category 
  
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
  
//             {options1.map((val) => {  
  
//               return (  
  
//                   <span class="dropdown-item" href="#" onClick={optionClicked}>  
  
//                   {val.subcat_name}  
  
//                 </span> 
  
//               );  
  
//             })}  
  
             
  
//           </div> 
  
//         </div> 
  
//       </> 
  
//     ); 
  
//   }; 
  
//   export default SubCategory; 
  
   
// import { useContext } from 'react'; 

import { useLocation } from 'react-router-dom'; 
import axios from 'axios'; 

const Main = (prop) => { 
  const [formData, setFormData] = useState([{category: {id: 1, cat_name: 'Backend'}, id: 1, subcat_name: "Java"}]);
  const [temp , setTemp] = useState(localStorage.getItem('filteredItem'));
  const [subCatDropDownTitle, setSubCatDropDownTitle] = useState("subcategory");
  console.log(prop.array);
  console.log(prop.css);
  console.log(formData);
  // console.log(localStorage); 

  const optionClicked=(val)=>{ 
    
    // onPuttingInput();
    // setFormData(prop.array);
    console.log(val) 
    // localStorage.setItem('subCategory', val.target.innerText);
    console.log(formData.length);
    console.log(prop.array.length !== undefined)
    console.log(prop.array.length)
    if(prop.array.length !== undefined)
    {
      setFormData(prop.array);
    }
    console.log(formData);

  } 
  
  useEffect(optionClicked);

  const optionClicked2 = (val) =>{
    console.log(val.target.innerText);
    setSubCatDropDownTitle(val.target.innerText);
    localStorage.setItem('subcategory', val.target.innerText);
  }

  console.log(localStorage);
  const onPuttingInput = () => {
    // console.log(p.target.value);
    // setFormData([]);
    console.log(localStorage.getItem('filteredItem'));
    console.log(prop.array);
    if(prop.array.length !== undefined)
    {
      setFormData(prop.array);
    }
    // axios.get('http://localhost:8083/getSubCategoryList/' + localStorage.getItem('filteredItem'))
    //   .then(response => {
    //     const dataArray = response.data;
    //      console.log(response);
    //     //  setData(dataArray); 
    //      console.log(dataArray)
    //     setFormData(dataArray)
    //   });
    // setVal(p.target.value);
    // console.log(formData)
  };
  
 
  // useEffect(() => {
  //   console.log(temp);
  //   onPuttingInput();
  // }, [temp]);
 useEffect(onPuttingInput , temp);

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

          style={{color:'rgb(95, 30, 190)',backgroundColor:'#e3ebf7',margin:'10px'}} 
          onClick = {onPuttingInput}

        > 

         {subCatDropDownTitle} 

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
    
                    <span class="dropdown-item" href="#" onClick={optionClicked2}>  
    
                    {val.subcat_name}  
    
                  </span> 
    
                );  
    
              })}

        </div> 
        </div>

 

    </> 

  ); 

}; 

export default Main; 

 
 

 