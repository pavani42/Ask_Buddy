import React from "react";
import "../join_us_section/joinus.css";
import { Container, Row, Col } from "reactstrap";
import JoinusImg from '../join_us_section/My_project.png'
import {Link} from 'react-router-dom'
const JoinUs = () => {
  return (
    <section className="join_us" style={{backgroundColor:'rgb(221 221 221)'}}>
      <Container>
        <Row>
          <Col lg="6" md="6" sm="12" className="join_us-img">
            <img style={{backgroundColor:'transparent'}}src={JoinusImg}alt="" className="w-100 rounded-3 join-us-section-img" />
          </Col>
          <Col lg="6" md="6" sm="12" style={{marginTop:'20px'}}>
            <h2 className="section__title join_us-title" style={{color:'rgb(95 30 190)'}}>
              Want to join Upcoming Projects?
            </h2>
            <h3 className="section__title join_us-title1" style={{color:'rgb(95 30 190)'}}>
              Don't Be Late
            </h3>
            <Link to='/join-us'> <button className="btn join_us-btn mt-4" style={{color:'white',backgroundColor:'rgb(95 30 190)'}}>Join us</button></Link>
          </Col>
        </Row>
      </Container>
    </section>
  );
};
export default JoinUs;
