import { Link } from "react-router-dom"
// import data from '../Dummy_data/data.jsx'
import {useParams} from 'react-router-dom';
import { useEffect } from "react";

const Main=(prop)=>{
    console.log(prop.A +  prop.B)
    return(

        <>
          <hr/>

          <Link to={`/${encodeURIComponent(prop.A)}`} className="card-link" style={{textDecoration:'none',color:'black'}}>

            <div className="card-1">
                <div className="card-2" style={{padding:'20px'}}>
                    <h5>{prop.A}</h5>
                    {/* <p>{prop.B}</p> */}
                    <u>Learn more</u>    
                </div>
            </div>
          </Link>
        </>
    );
}
export default Main;