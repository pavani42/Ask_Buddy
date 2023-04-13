import React from "react";
import { Container } from "reactstrap";
// import "./commonsection.css";
const CommonSection = ({ title }) => {
  return (
    <section className="common__section" style={{backgroundColor: 'rgba(60,145,255,1)',
      backgroundPosition: 'center',
      backgroundSize: 'cover',
      backgroundRepeat: 'no-repeat',
      padding: '50px 0px',}}>
      
      <Container className="text-center">
        
        <h1 className="text-light" style={{color:'white'}}>{title}</h1>
      </Container>
    </section>
  );
};
export default CommonSection;
