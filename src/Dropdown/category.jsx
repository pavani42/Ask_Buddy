import React, { useState } from 'react';
import { useEffect, useContext } from 'react';  
import axios from 'axios'; 
const Main = (prop) => { 
  const [formData, setFormData] = useState([]);
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
         {prop.header} 
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
 
 