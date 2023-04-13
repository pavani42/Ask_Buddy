import React from 'react';
import {
    MDBCard,
    MDBCardImage,
    MDBCardBody,
    MDBCardTitle,
    MDBCardText,
    MDBRow,
    MDBCol
} from 'mdb-react-ui-kit';
export default function TeamInfo() {
    return (
        <MDBRow className='row-cols-1 row-cols-md-4 g-4' style={{ backgroundColor: "#eee", width: '100%', display: 'flex', justifyContent: 'center', marginTop: '80px' }}>
            <MDBCol>
                <MDBCard className='h-100'>
                    <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/041.webp' alt='...' position='top' />
                    <MDBCardBody>
                        <MDBCardTitle>Srikanth Narsimhan</MDBCardTitle>
                        <MDBCardText>              Ask Buddy Application Chief and the he is the man behind bringing the capable minds under the one roof.
                        </MDBCardText>
                    </MDBCardBody>
                </MDBCard>

            </MDBCol>      <MDBCol>
                <MDBCard className='h-100'>
                    <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/042.webp' alt='...' position='top' />          <MDBCardBody>            <MDBCardTitle>Rajalakshmi B</MDBCardTitle>            <MDBCardText>The lady who mada a path for the team collaboration and providing resouces for implementing the application.</MDBCardText>          </MDBCardBody>        </MDBCard>      </MDBCol>      <MDBCol>        <MDBCard className='h-100'>          <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/043.webp' alt='...' position='top' />          <MDBCardBody>            <MDBCardTitle>Anbu</MDBCardTitle>            <MDBCardText>              This is a longer card with supporting text below as a natural lead-in to additional content.
                    </MDBCardText>          </MDBCardBody>        </MDBCard>      </MDBCol>      <MDBCol>        <MDBCard className='h-100'>          <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/044.webp' alt='...' position='top' />          <MDBCardBody>            <MDBCardTitle>Vidhya</MDBCardTitle>            <MDBCardText>              This is a longer card with supporting text below as a natural lead-in to additional content.
                        This content is a little bit longer.
                    </MDBCardText>          </MDBCardBody>        </MDBCard>      </MDBCol>      <MDBCol>        <MDBCard className='h-100'>          <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/044.webp' alt='...' position='top' />          <MDBCardBody>            <MDBCardTitle>Mohammadraphi Saif</MDBCardTitle>            <MDBCardText>              This is a longer card with supporting text below as a natural lead-in to additional content.
                        This content is a little bit longer.
                    </MDBCardText>          </MDBCardBody>        </MDBCard>      </MDBCol>      <MDBCol>        <MDBCard className='h-100'>          <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/044.webp' alt='...' position='top' />          <MDBCardBody>            <MDBCardTitle>Sindiri Pavani</MDBCardTitle>            <MDBCardText>              This is a longer card with supporting text below as a natural lead-in to additional content.
                        This content is a little bit longer.
                    </MDBCardText>          </MDBCardBody>        </MDBCard>      </MDBCol>      <MDBCol>        <MDBCard className='h-100'>          <MDBCardImage src='https://mdbootstrap.com/img/new/standard/city/044.webp' alt='...' position='top' />          <MDBCardBody>            <MDBCardTitle>Shaik Faraz Hussain</MDBCardTitle>            <MDBCardText>              This is a longer card with supporting text below as a natural lead-in to additional content.
                        This content is a little bit longer.
                    </MDBCardText>          </MDBCardBody>        </MDBCard>      </MDBCol>    </MDBRow>);
}