import Nav from './main_content/nav.jsx';
import Footer from './main_content/footer.jsx';
import Search from './main_content/searchbar_mob.jsx'
import Content from './main_content/ques_ans_pg.jsx'

const Main=()=>{
    return(
    <>
    {/* <div className="collected-ques-ans">
      <Nav/>
      <Search/>
      <Content/>
      <Footer/>
    </div> */}
    <Nav/>

    <div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}>
      <div className="window-width-resp">
        <Search/>
        <Content/>
      </div>
    </div>
    <Footer/>

    </>);
}

export default Main;