import { Routes,Route} from "react-router-dom"; 
import Login from './login/login.jsx'; 
import Registration from './Signup/sign_up_page.jsx'; 
import Collected_1 from './collected_ques_ans_page.jsx'; 
import Collected_2 from './collected_homepage_content.jsx'; 
import FAQ from './FAQ_page/faq.jsx' 
import Nav from './main_content/nav.jsx'; 
import Footer from './main_content/footer.jsx' 
import AboutUs from './Aboutus_page/aboutus_main.jsx'; 
// import ContactUs from './contact_page/contact_page.jsx' 
import JoinUs from './joinus_page/joinus_page.jsx'; 
import IndividualQuesAnsPage from './Detailed_ques_ans_page/detailed_ques_ans_page.jsx'; 
import { dividerClasses } from "@mui/material"; 
import Fdb from "./FeedBack/feedback.jsx"; 
import ConUs from "./contact_page/contact_page.jsx"; 
import Data from "../src/FetchingDataFromApi/fetchdata.jsx"
import TeamInfo from "./Team/TeamInfo.jsx";
import ProfilePage from './Profile_page/profile.jsx'
import PersonalizedSearch from './PersonalizeSearch/personalize_search_page.jsx'
import FilteredPage from './FilterPage/filterData.jsx'
const Main=()=>{ 

  return(  

    <> 

    {/* <h1>HIHI</h1> */} 

    {/* <Nav/> */} 
<Data> 

    <Routes> 
        <Route path='/' element={<Collected_2/>}></Route> 
        <Route path='/ques-ans-page' element={<><Collected_1/></>}></Route> 
        <Route path='/:slug' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><IndividualQuesAnsPage/></div></div><Footer/></>}></Route> 
        <Route path='/faq' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><FAQ/></div></div><Footer/></>}></Route> 
        <Route path='/login' element={<Login/>}></Route> 
        <Route path='/registration' element={<Registration/>}></Route> 
        {/* <Route path='/about-us' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><AboutUs/></div></div><Footer/></>}></Route> */} 
        {/* <Route path='/contact-us' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><ContactUs/></div></div><Footer/></>}></Route>  */}
        <Route path='/join-us' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><JoinUs/></div></div><Footer/></>}></Route> 
        <Route path='/fdb' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><Fdb/></div></div><Footer/></>}></Route> 
        <Route path='/contact-us' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><ConUs/></div></div><Footer/></>}></Route> 
        <Route path='/teaminfo' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><TeamInfo/></div></div><Footer/></>}></Route>
        <Route path='/profile' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><ProfilePage/></div></div><Footer/></>}></Route>
        <Route path='/personalized-search' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><PersonalizedSearch/></div></div><Footer/></>}></Route>
        <Route path='/filtered-search' element={<><Nav/><div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}><div className="window-width-resp"><FilteredPage/></div></div><Footer/></>}></Route>
    </Routes> 
    </Data>

    {/* <Footer/> */} 

    </> 

  ); 

} 

export default Main; 

 