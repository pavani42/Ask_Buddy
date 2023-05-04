import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import { faCamera } from "@fortawesome/free-solid-svg-icons";
import {

    MDBBreadcrumb,

    MDBBreadcrumbItem,

    MDBCard,

    MDBCardBody,

    MDBCardImage,

    MDBCardText,

    MDBCol,

    MDBContainer,

    MDBRow,

    MDBBtn,

    MDBIcon,

    MDBListGroupItem,

    MDBListGroup,

    MDBTabs,

    MDBTabsItem,

    MDBTabsLink,

    MDBTabsContent,

    MDBTabsPane,

} from "mdb-react-ui-kit";

import React from "react";

import { useState } from "react";

import { UserAnswers } from "./user_wise_answered_ques";

import { UserAskedQuestions } from "./user_wise_asked_ques"

import axios from 'axios';

export default function ProfilePg() {

    const [fillActive, setFillActive] = useState("tab1");
    const [file, setFile] = useState(null);

    const handleFillClick = (value: String) => {

        if (value === fillActive) {

            return;

        }

        setFillActive(value);

    };

    const [userName, setuserName] = useState('');

    const [userSap, setuserSap] = useState('');

    const [userEmail, setuserEmail] = useState('');

    const [userImage, setuserImage] = useState('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');
    const user = JSON.parse(localStorage.getItem('token'));

    //   setuserImage("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")

    //   axios.get('http://localhost:8086/getUserData?token=' + localStorage.getItem('token')) 
    axios("http://localhost:9191/api/users/getUserData?token=" + user, {
        method: "get",
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json",
            "Authorization": "Bearer " + user,
            mode: "no-cors",
        },

    })
        .then(response => {

            const dataArray = response.data.results;

            console.log(response.data);

            // const base64String = response.data.pic;
            // const binaryString = atob(base64String);
            // const blob = new Blob([binaryString], { type: 'image/jpeg' });
            // const url = URL.createObjectURL(blob);

            setuserName(response.data.username);

            setuserSap(response.data.sap_Id);

            setuserEmail(response.data.mail);

            if (response.data.pic != null) {
                setuserImage(response.data.pic);
            }

            var base64Icon = 'data:image/png;base64,' + userImage;

            // console.log(base64Icon);

            

            // if(userImage == null)
            // {
            //     setuserImage("/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEABsbGxscGx4hIR4qLSgtKj04MzM4PV1CR0JHQl2NWGdYWGdYjX2Xe3N7l33gsJycsOD/2c7Z//////////////8BGxsbGxwbHiEhHiotKC0qPTgzMzg9XUJHQkdCXY1YZ1hYZ1iNfZd7c3uXfeCwnJyw4P/Zztn////////////////CABEIAPUA/wMBIgACEQEDEQH/xAAaAAEBAAMBAQAAAAAAAAAAAAAAAQIEBQMG/9oACAEBAAAAAPpQAnO1vDzZ7O3vgAADT4+QDPt+gAAGrwsgCvosgAAfMxMkA3uyAAGhxLjvdHHiAY/U5AADh8+dPet8eJAdzoAAD5vV2+tbbOfqeXv4efV7IAA+X1+/nlbSSeXz/W7YAA+Ydi3JbEk4nQ7AAA4LfttVEnN2+oAAMOb7W1RJNbo+wAAaMWqJGPQAABp4FoRMt0AAHhrigj22QAATQoAm9kAABr69APbZAAANPABlugAACcv1onnv+oAAA19IyTG7myAADy0/Dxz9gHi9Pfc9AB58zw1sPXHHLfztsnnoTK+WWxtdWhq/PWAXc2s2GrqYgXP6XIfKYCgM5iAheh3TncAAAAAn1+T5/mgAAAE+i6L5bTAAAAHZ7j5DXAAAAHT+kfHawAAAA3/q8OFrxERCBVq22tntZSJJJIiCqtttq2gAIKRQD//EABgBAQADAQAAAAAAAAAAAAAAAAABAgME/9oACgICEAMQAAAAACs53rJaNaTAAAVnDUAmN85gAAx0pZaawDSmtAADDXPSYtExCJvTbMAAw1y1tE1lExOmW2YABlrhtNZTETE65bZAAFL83QTAQ6cL0AADl6a2AtXq5gAAK25ekDp570AAApfn3SI6ML0AAAMN6WL13wAAAASIAAAAAAAAAAAAAAAAAAAAAAAP/8QAIxAAAQMDBQEBAQEAAAAAAAAAEQECAwQFFQASEzBAEBQgUP/aAAgBAQABAgDrc59zdVPZ+b8zI21UNx81VWP0SSSV1DPFL46ypahJ0SSTFMx/hVZZviuiili/u2z+G5SpoudBRakjezRJJc5j/BdHlzqWm+zwSMJJOrW/wV6mih/lzZLa6j4GUM0JtC+Cs0GN6potWfw16UDOytZZ08F2htydlxbaE8EscEXZVMp4fC7/AAJk7Ik8VQ3sp08SoOpdNb452IvTAzyyx9EcfmXSOR38KqugXzVL/iLv37vlKvifO+7LcnTxL0SPSqS6MurJuqWZ12dWv02PlV+muY/QAGnvc8pIsixsRtXFdWu/mrq3KrySSdNeypa8lz31TnkkkndBUMf9VZZySSSSSi8qykkkkkk2qf7dZdEkkkkkkkkkkkkq9j/l2eSSSSSSSSSSSSSdWqT5cHEkkkkkkkkkkkkk2V/yrUkkkkkkkkkkkkkm0O+Vntta6XVVbMTicVi8XjMZjcdjsfj8f+D8H4Mfj8djsbjMXi8VicRh6W2aA27duzZx8fHxcXFw8PDw8PDxcXFx8fHs2bdoA6wAAAAOv//EADoQAAIBAgIFCgQFAwUAAAAAAAECAwARBDESMEBRUhATICEyM0FTYXEFYpGhIiRCQ4EjNHNUYHKCsf/aAAgBAQADPwDVqoLMwAGZNRXtBG8x+i1jn/cjiHyi5ppO9xMr1h9z/WsPwt9a5vup5UrHJ+tJh6ixqByEkBifc+zphgBbTkPZSpJ208Q2luQdkV1WHUOmGFmFxUuF7N3h4DmPao5ow8bXU7IMNFe13bqRaN2dzpO3abVthZOcXsHvEpXVWU3BFwdisLmjiZ3m8MkG5eUKLk2FT4jrQaCcZpsM4BJKNkx1Gg5wxyN2TYjHhSo7UhCUAAByWt1Ek5AZmsnnsW8F8ByJKjI4uDTwSc2//Vt46bIVkXtIwYUrorrkwBGw3xEKcKX5NEX+grmv6knen7dBJ4yjfwdxqSBtGUezeB6elhAOBiuw3x0/pYcmm3PtkOpOkrgqwBBzBqPOJyn3FYtP0K/saxX+nepn7xgg3DrNSQMA5upybk/uV+ZTsP5zE/8AOi7Ki5ubUqKqrkBYasTRsh8aIuDmDY1+PFeybDbHYj3rSnd+BfudboYgnjF6/BiG+cDYbOk4yIs1WhZuJzrbpG+5rVbCsd8p2FJUaNxdWrmU5u99EnWmSB0UXYkWoQQxxA30RsVpJB82tuyDew2O0t96628y+gJ2O6BuE63qZ95+w2MEEGipKnw1ZNlGZ6hQVQoyGyEjTGYq+q/cP8bNoEsOyc/TU86bnsD77OACTRFA9ECiavEmz2TR8W5SPGjuo7qY8v4GG5tjgivzkyL7msEDZS8h+RaxL91g/wCXNfEH7WJSIbkFdVjKznxY5nUzKRzWI5o/+18STyZade9wbj1U3rBNnIUPzrUMvYlRvZtXFCunLIEWge5wzv6k2FfEH8qKpJO+xcr+gNhWHTKK53miOyAPYUxzY8hUgig4uOmEFzRZiTyOP1Gr9pVPuKw7ZxW9qaPusVKn818QT96OQfMKANsTEY/mHWtK6hlIIORHSTCR3td26kSnlcyztpv9hR36gqbg0p7XVStkaG8Uu8Ui5ml/SL0zG5OoNrHrFPgnulzCe2lLIiuhBVhcHoAAkmwAuTRxMzzn2Qbl1lqk42+tSHN2+ut5uRsMcmuydDQwhQZysEq21tGUkXtIwYUHRXXJlBHLfExJwR3+u26eCQcDFOW+PxHoQNt68Uns3LfGYr/K222xjjih5fzmK/zPttsfF6o/LNLiJZEdLOb1iuOKsTxxVieOOsTxx1iOOOsRxx1PxpU/GlT8aVPxpU3GlTcaVNxpU3GlTcSVNxpU3GlT8aVPxpU/GlT+YlT+YlT+alT+alT+alT+clT+clT+elSwTpKZUIX/AGF//8QAIBEAAgEEAgMBAAAAAAAAAAAAAQIRAAMgMDEyEBIhYP/aAAgBAgEBPwDFmAouak1JoOaDA6mMDIGKBkaXP3O2eRpbsamTjNJ20v8AJzt6bvAztcHS4lTnbELqdfU4qvsdbKGGKABRrckKcU6jY1sjjytsnndAqPxH/8QAIREAAgEEAgIDAAAAAAAAAAAAAQIRACAwMQMQEiEyQWD/2gAIAQMBAT8AtAJoKKiooqKIjEBN5EYV12bGwjQoCLIqKbWFPcXvh4tm/l+sKGGF/IZbEreQtY+InGrFTa5JY4+MS3U1PXJ8zkVwd+j2XA17NbyyRUn8R//Z");
            // }

            // else
            // {

            // }

            // var base64Icon = 'data:image/png;base64,iVBORw0KGgoAAAANS...';
            {/* <Image style={{width: 50, height: 50}} source={{uri: base64Icon}}/> */ }


            // return () => {
            //     URL.revokeObjectURL(url);
            // };

        })
    // console.log(userImage);
    const logoutClick = () => {
        console.log("hello")
        localStorage.removeItem('token');
        window.location.reload();
        window.location.href = "/";
    };
    const funcTemp = (val) => {
    console.log(val);
    console.log(val.target.files[0])
    // setFile(val.target.files[0]);
    // console.log(file)
    const formData = new FormData();
    formData.append("file", val.target.files[0]);
    console.log(formData)
    // formData.append('customFile', state.image_file);
    axios("http://localhost:9191/api/users/uploadImage", 
    {
        method: "post",
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "multipart/form-data",
            "Authorization": "Bearer " + user,
            mode: "no-cors",
            body : formData,
        },
        

    })
        .then(response => {

            const dataArray = response.data.results;

            console.log(response.data);
})
    }


    ////////////////// 

    return (

        <section

            className="profile-page-1"

            style={{

                backgroundColor: "#eee",

                width: "100%",

                display: "flex",

                justifyContent: "center",

                marginTop: "80px",

                minHeight: 'calc(100vh -107px)'

            }}

        >



            <MDBContainer className="py-5">



                {/* <MDBRow>                    <MDBCol>                        <MDBBreadcrumb className="bg-light rounded-3 p-3 mb-4">                            <MDBBreadcrumbItem>                                <a href='#'>HOME</a>                            </MDBBreadcrumbItem>                            <MDBBreadcrumbItem>                                <a href='#'>User</a>                            </MDBBreadcrumbItem>                            <MDBBreadcrumbItem active>User Profile</MDBBreadcrumbItem>                        </MDBBreadcrumb>                    </MDBCol>                </MDBRow> */}

                <MDBRow>



                    <MDBCol lg="4">



                        <MDBCard className="mb-4">



                            <MDBCardBody className="text-center">
                                <MDBCardImage

                                    // src="ata:image/jpeg;,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"
                                    // eslint-disable-next-line no-template-curly-in-string
                                    src={'data:image/png;base64,' + userImage}
                                    alt="avatar"

                                    className="rounded-circle"

                                    style={{ width: "150px" }}

                                    fluid

                                />
                                {/* <form></form> */}
                                <input

                                    type="file"

                                    id="imageInput"

                                    name="image"

                                    accept="image/*"

                                    style={{ display: "none" }}

                                    onChange={funcTemp}

                                ></input>

                                <label for="imageInput" id="customButton" style={{ position: 'absolute', bottom: '150px' }} title="Change profile photo">

                                    <FontAwesomeIcon icon={faCamera} />

                                </label>
                                <p className="text-muted mb-1">{userName}</p>

                                <p className="text-muted mb-4">{userSap}</p>

                                <div className="d-flex justify-content-center mb-1" style={{}}>



                                    {/* <MDBBtn style={{ color: 'white', backgroundColor: 'rgb(95, 30, 190)' }} className="mx-1">

                                        Logout

                                    </MDBBtn> */}
                                    <button

                                        onClick={logoutClick}

                                        className="nav-content-4"

                                        style={{

                                            margin: "12px 8px 8px 0px",

                                            backgroundColor: "rgb(95 30 190)",

                                            color: "white",

                                            border: "none",

                                            borderRadius: "5px",

                                            padding: "5px 30px 5px 30px",

                                            height: "60%",

                                            fontSize: ".86rem",

                                        }}

                                    >

                                        LOGOUT

                                    </button>



                                    {/* <MDBBtn outline className="ms-1">Message</MDBBtn> */}

                                </div>

                            </MDBCardBody>

                        </MDBCard>

                        {/* <MDBCard className="mb-4 mb-lg-0">                            <MDBCardBody className="p-0">                                <MDBListGroup flush className="rounded-3">                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">                                        <MDBIcon fas icon="globe fa-lg text-warning" />                                        <MDBCardText>https://mdbootstrap.com</MDBCardText>                                    </MDBListGroupItem>                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">                                        <MDBIcon fab icon="github fa-lg" style={{ color: '#333333' }} />                                        <MDBCardText>mdbootstrap</MDBCardText>                                    </MDBListGroupItem>                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">                                        <MDBIcon fab icon="twitter fa-lg" style={{ color: '#55acee' }} />                                        <MDBCardText>@mdbootstrap</MDBCardText>                                    </MDBListGroupItem>                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">                                        <MDBIcon fab icon="instagram fa-lg" style={{ color: '#ac2bac' }} />                                        <MDBCardText>mdbootstrap</MDBCardText>                                    </MDBListGroupItem>                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">                                        <MDBIcon fab icon="facebook fa-lg" style={{ color: '#3b5998' }} />                                        <MDBCardText>mdbootstrap</MDBCardText>                                    </MDBListGroupItem>                                </MDBListGroup>                            </MDBCardBody>                        </MDBCard> */}

                    </MDBCol>

                    <MDBCol lg="8">



                        <MDBCard className="md-4">



                            <MDBCardBody>



                                <MDBRow>



                                    <MDBCol sm="3">



                                        <MDBCardText>Full Name</MDBCardText>

                                    </MDBCol>

                                    <MDBCol sm="9">



                                        <MDBCardText className="text-muted">

                                            {userName}

                                        </MDBCardText>

                                    </MDBCol>

                                </MDBRow>

                                <hr />

                                <MDBRow>



                                    <MDBCol sm="3">



                                        <MDBCardText>SAP ID</MDBCardText>

                                    </MDBCol>

                                    <MDBCol sm="9">



                                        <MDBCardText className="text-muted">

                                            {userSap}

                                        </MDBCardText>

                                    </MDBCol>

                                </MDBRow>

                                <hr />

                                <MDBRow>



                                    <MDBCol sm="3">



                                        <MDBCardText>Email</MDBCardText>

                                    </MDBCol>

                                    <MDBCol sm="9">



                                        <MDBCardText className="text-muted">

                                            {userEmail}

                                        </MDBCardText>

                                    </MDBCol>

                                </MDBRow>

                                <hr />

                                {/* <MDBRow>                                    <MDBCol sm="3">                                        <MDBCardText>Phone</MDBCardText>                                    </MDBCol>                                    <MDBCol sm="9">                                        <MDBCardText className="text-muted">(097) 234-5678</MDBCardText>                                    </MDBCol>                                </MDBRow>                                <hr /> */}

                                <MDBRow>



                                    <MDBCol sm="3">



                                        <MDBCardText>Current PWD</MDBCardText>

                                    </MDBCol>

                                    <MDBCol sm="9">



                                        <MDBCardText className="text-muted">

                                            Bay Area, San Francisco, CA

                                        </MDBCardText>

                                    </MDBCol>

                                </MDBRow>

                                <hr />

                                <MDBRow>



                                    <MDBCol sm="3">



                                        <MDBCardText>Update PWD</MDBCardText>

                                    </MDBCol>

                                    <MDBCol sm="9">



                                        <MDBCardText className="text-muted">

                                            Bay Area, San Francisco, CA

                                        </MDBCardText>

                                    </MDBCol>

                                </MDBRow>

                                {/* <hr /> */}

                                {/* <MDBRow>                                    <MDBCol sm="3">                                        <MDBCardText>Address</MDBCardText>                                    </MDBCol>                                    <MDBCol sm="9">                                        <MDBCardText className="text-muted">Bay Area, San Francisco, CA</MDBCardText>                                    </MDBCol>                                </MDBRow> */}

                            </MDBCardBody>

                        </MDBCard>

                    </MDBCol>

                    <MDBTabs pills fill className="mb-2">



                        {/* <MDBTabsItem>          <MDBTabsLink onClick={() => handleFillClick('tab1')} active={fillActive === 'tab1'}>            Link          </MDBTabsLink>        </MDBTabsItem> */}

                        <MDBTabsItem>



                            <MDBTabsLink

                                onClick={() => handleFillClick("tab2")}

                                active={fillActive === "tab2"}

                            >



                                Asked Questions

                            </MDBTabsLink>

                        </MDBTabsItem>

                        <MDBTabsItem>



                            <MDBTabsLink

                                onClick={() => handleFillClick("tab3")}

                                active={fillActive === "tab3"}

                            >



                                Answered Questions
                                {/* <UserAnswers/> */}

                            </MDBTabsLink>

                        </MDBTabsItem>

                    </MDBTabs>

                    <MDBTabsContent>



                        {/* <MDBTabsPane show={fillActive === 'tab1'}>Tab 1 content</MDBTabsPane> */}

                        <MDBTabsPane show={fillActive === "tab2"}>

                            {/* Asked Questions */}
                            <UserAskedQuestions />

                        </MDBTabsPane>

                        <MDBTabsPane show={fillActive === "tab3"}>

                            {/* Answered Questions */}
                            <UserAnswers />

                        </MDBTabsPane>

                    </MDBTabsContent>

                </MDBRow>

            </MDBContainer>

        </section>

    );

}




