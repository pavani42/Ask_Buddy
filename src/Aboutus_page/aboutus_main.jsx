import React from "react";
import { Container, Row, Col } from "reactstrap";
// import '../aboutus.css';
import CommonSection from "../comman_section/common_section.jsx";
// import aboutImg from "../Askbuddy-bg.png";
// import queImg from "../icon1.jpeg";
import JoinUs from "./join_us_section/join_us_section.jsx";
import OurTeam from "./team_section/team_section.jsx";
import { Icon } from "@iconify/react";
import AskBuddyLogo from "../images/ask_buddy_logo.png";
import AboutUsMsgImg from "../images/icon_aboutus.png";
import { Link } from "react-router-dom";
import HeaderImg from "../images/about_us_head_cover_reduced_opacity.png";

const AboutSection = ({ aboutClass }) => {
  return (
    <section className="about__section">
      {/* <CommonSection title="About Us" /> */}
      <Col lg="12" md="12">
        <div
          className="aboutus-header-1"
          style={{
            backgroundImage: `url(${HeaderImg})`,
            backgroundSize: "cover",
            padding: "140px 20px 140px 20px",
          }}
        >
          <h1
            style={{
              textAlign: "center",
              color: "rgb(95 30 190)",
            }}
          >
            <sup>
              <i class="fa fa-quote-left" aria-hidden="true"></i>
            </sup>
            Asking questions is first step to begin change
            <sup>
              <i class="fa fa-quote-right" aria-hidden="true"></i>
            </sup>
          </h1>
          <div className="aboutus-header-2" style={{display:'flex',justifyContent:'center',marginTop:'20px'}}>
            
          <Link to="/ques-ans-page">
            <button
              className="btn join_us-btn mt-4"
              style={{ color: "white", backgroundColor: "rgb(95 30 190)" }}
            >
              Get Started &#8594;
            </button>
          </Link>
          </div>
        </div>
      </Col>
      <Container>
        <Row>
          <Col lg="6" md="6">
            <div className="about__section-content">
              {/* <h3 className="section__subtitle">About Us</h3> */}
              <h1
                className="section__title"
                style={{ marginTop: "20px", color: "rgb(95 30 190)" }}
              >
                <u>Why Ask Buddy ?</u>
              </h1>{" "}
              <br />
              <p className="section__description">
                The Ask Buddy Application main vision is to share and grow the
                knowledge. This application makes a platform for the every
                HCLites to come under one roof and share their knowledge for the
                benfit of the every HCLites. The key features are listed below
                for using the application.
              </p>
              <br />
              <div className="about__section-item align-items-center">
                <p
                  className="section__description d-flex align-items-center gap-2"
                  style={{ marginRight: "5px" }}
                >
                  <Icon icon="ri:checkbox-circle-line" color="green" /> User
                  Friendly
                </p>
                <p
                  className="section__description d-flex align-items-center gap-2"
                  style={{ marginRight: "5px" }}
                >
                  <Icon icon="ri:checkbox-circle-line" color="green" />{" "}
                  Categorized Search
                </p>
              </div>
              <div className="about__section-item align-items-center">
                <p
                  className="section__description d-flex align-items-center gap-2"
                  style={{ marginRight: "5px" }}
                >
                  <Icon icon="ri:checkbox-circle-line" color="green" /> High
                  Quality Answers
                </p>
                <p
                  className="section__description d-flex align-items-center gap-2"
                  style={{ marginRight: "5px" }}
                >
                  <Icon icon="ri:checkbox-circle-line" color="green" /> Free
                  Knowledge Sharing
                </p>
              </div>
              {/* <Link to="/ques-ans-page">
                
                <button
                  className="btn join_us-btn mt-4"
                  style={{ color: "white", backgroundColor: "rgb(95 30 190)" }}
                >
                  Get Started &#8594;
                </button>
              </Link> */}
            </div>
          </Col>
          <Col lg="6" md="6">
            <div className="about__img">
              <img src={AskBuddyLogo} alt="" className="w-100 rounded-3" style={{}}/>
            </div>
          </Col>
          {/* <Col lg="6" md="6" sm="12">
            
            <div className="about__page-img">
              
              <img style={{backgroundColor:'transparent'}}src={AboutUsMsgImg} alt="" className="w-100 rounded-3" />
            </div>
          </Col> */}
          <Col lg="12" md="12" sm="12">
            <div className="about__page-content" style={{}}>
              <h2
                className="section__title"
                style={{ color: "rgb(95 30 190)" }}
              >
                <u>
                  We Are Committed To Provide Qualitative Answers with no
                  Distractions.
                </u>
              </h2>
              <br />
              <p className="section__description">
                Ask Buddy Application is the Question & Answer site for the
                every professional working in the HCL TECH. It is a place for
                every individual HCLite can ask Question and get answers from
                people who have been there and done that. Ask Buddy Answers
                comes from the Great writers, who really understand the issues
                and have first-hand knowledge.
              </p>
              <p className="section__description">
                Ask Buddy application is maintainhed and run by the HCL TECH
                newbies of 2022 Grads across India.
              </p>
              {/* <div className=" d-flex align-items-center gap-2 mt-4">
                
                <span className="fs-12">
                  
                  <i class="ri-admin-fill"></i>
                </span>
                <br /> <br /> <br /> <br /> <br /> */}
              <div style={{ marginTop: "40px" }}>
                <h4
                  className="section__subtitle"
                  style={{ color: "rgb(95 30 190)" }}
                >
                  <u>Need Any Help?</u>
                </h4>
                <h6>Contact US Admin</h6>
              </div>
              {/* </div> */}
            </div>
          </Col>
        </Row>
      </Container>
      <JoinUs />
      {/* <OurTeam /> */}
    </section>
  );
};
export default AboutSection;
