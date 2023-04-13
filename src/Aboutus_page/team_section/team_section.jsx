import React from "react";
import { Col } from "reactstrap";
import { Link } from "react-router-dom";
import "../team_section/team.css";
const OUR__MEMBERS = [
  {
    name: "Srikanth",
    experience: "Deputy General Manager",
    fbUrl: "#",
    instUrl: "#",
    twitUrl: "#",
    linkedinUrl: "#",
    imgUrl: 'https://upload.wikimedia.org/wikipedia/en/b/bd/Doraemon_character.png',
  },
  {
    name: "Faraz",
    experience: "FSD - React",
    fbUrl: "#",
    instUrl: "#",
    twitUrl: "#",
    linkedinUrl: "#",
    imgUrl:'https://upload.wikimedia.org/wikipedia/en/3/3f/NobitaNobi.png',
  },
  {
    name: "Pavani",
    experience: "FSD",
    fbUrl: "#",
    instUrl: "#",
    twitUrl: "#",
    linkedinUrl: "#",
    imgUrl:'https://i.pinimg.com/474x/a1/9c/7d/a19c7d4f7499a609049a022810f0e169.jpg',
  },
  {
    name: "Saif",
    experience: "UI Dev",
    fbUrl: "#",
    instUrl: "#",
    twitUrl: "#",
    linkedinUrl: "#",
    imgUrl:'https://i.pinimg.com/222x/8c/6f/ac/8c6fac5bb37b79ed7acbf86c105e16f8.jpg'
  },
];
const OurTeam = () => {
  return (
    <>
      <div className="team_section">
      {OUR__MEMBERS.map((item, index) => (
        
        <Col lg="3" md="3" sm="4" xs="6" key={index} className="mb-4">
          <div className="single__member" >
            <div className="single__member-img">
              <img src={item.imgUrl} alt="" className="w-100" />
            </div>
            <h5 className="text-center mb-0 mt-3">{item.name}</h5>
            <p className="section__description text-center">
              {item.experience}
            </p>
          </div>
        </Col>
        
      ))}
      </div>
    </>
  );
};
export default OurTeam;
