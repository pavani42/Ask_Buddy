import CommonSection from '../comman_section/common_section.jsx';
import LoadingBar from 'react-top-loading-bar'
import { useState } from 'react';
import { useEffect, useContext } from 'react';
import noteContext from '../FetchingDataFromApi/context.jsx'
const Main = () => {

  const [pr, setPr] = useState(40);

  const ab = useContext(noteContext);

  useEffect(() => {

    setPr(ab.pr);
    console.log(ab.pr);

  })
  return (

    <>

      <LoadingBar

        color='white'

        progress={pr}

      // onLoaderFinished={() => setProgress(10)}

      />



      <div className="faq-main-div" style={{ marginTop: "58.5px" }}>

        <CommonSection title={'FAQs'}></CommonSection>

        <section className='faq-body-1' style={{ marginLeft: '15px' }}>

          {/* <h3 class="text-center mb-4 pb-2 text-primary fw-bold">FAQs</h3> */}

          <p class="text-center mb-5">

            Most of Your are Resolved here

          </p>




          <div class="row">

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="far fa-paper-plane text-primary pe-2"></i>What is this application and what does it do?

              </h6>

              <p>

                <strong>

                  <u>Ask Buddy</u>

                </strong>{" "}

                is an community forum application mainly targeted to the Freshers to resolve their queries from the veteran HCLites.

              </p>

            </div>

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="far fa-paper-plane text-primary pe-2"></i>Is this application free or is there a cost involved?

              </h6>

              <p>

                {/* <strong> 

                <u>Absolutely!</u> 

              </strong>{" "} */}

                Ask Buddy application is Absolutely free to use.

              </p>

            </div>

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="far fa-paper-plane text-primary pe-2"></i>How do I create an account for this application?

              </h6>

              <p>

                {/* <strong> 

                <u>Absolutely!</u> 

              </strong>{" "} */}

                This application provides a user friendly path to register, click on the <strong>"LOGIN"</strong>  there you can find <strong>"REGISTER HERE"</strong> click on it and register your self for using this application.

              </p>

            </div>

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-user text-primary pe-2"></i> What are the system requirements for running this application?

              </h6>

              <p>

                {/* <strong> 

                <u>Yes, it is possible!</u> 

              </strong>{" "} */}

                Developers them self dont know, so try to use in latest one.

              </p>

            </div>



            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-user text-primary pe-2"></i> What kind of data does this application collect and how is it used?

              </h6>

              <p>

                Currently <strong>

                  Ask Buddy

                </strong>{" "} application uses only your SAP ID, Name, Mobile & Email for making a authenticated user.

              </p>

            </div>




            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-rocket text-primary pe-2"></i> Can I use this application offline?

              </h6>

              <p>

                Unfortunately <strong>NO</strong>, you cannot use this application offline as its designed only to work on with the network.

              </p>

            </div>




            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-home text-primary pe-2"></i> Is there a mobile app version of this application?

              </h6>

              <p>

                {/* <strong> 

                <u>Unfortunately no</u>. 

              </strong>{" "} */}

                <strong>Yes</strong>, the application for the mobile will be released soon.

              </p>

            </div>




            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-home text-primary pe-2"></i> How do I report a bug on the application?

              </h6>

              <p>

                You can directly contact Admin from <strong>Contact US</strong> form & will give an update with in 3 business days.

              </p>

            </div>




            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-home text-primary pe-2"></i>How do I reset my password if I forget it?

              </h6>

              <p>

                Currently, reset password is unavailable in future versions it will get added.

              </p>

            </div>

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-user text-primary pe-2"></i> How do I provide feedback on the application?

              </h6>

              <p>

                After Logged into the application you can see FeedBack option click on it and provide your Feedback.

              </p>

            </div>

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-user text-primary pe-2"></i> How do I delete my account and what happens to my data when I do?




              </h6>

              <p>

                Currently, you need to contact Admin through <strong>Contact Us</strong> form to delete your account, After sucessful deletion your data will be flushed.

              </p>

            </div>

            <div class="col-md-6 col-lg-4 mb-4">

              <h6 class="mb-3 text-primary">

                <i class="fas fa-user text-primary pe-2"></i> How often is the application updated and how are updates delivered?

              </h6>

              <p>

                Our Team will give updates and add features to application with in less time & updates gets deployed into the server directly.

              </p>

            </div>

          </div>

        </section>

      </div>

    </>

  );



};




export default Main; 