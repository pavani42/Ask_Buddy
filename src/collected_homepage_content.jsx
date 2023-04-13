import Nav from './main_content/nav.jsx';
import Footer from './main_content/footer.jsx';
import Search from './main_content/searchbar_mob.jsx'
import Home from './main_content/home.jsx'

const Main=()=>{
    return(
    <>
      {/* <Nav/>
      <Search/>
      <Home/>
      <Footer/> */}

      <Nav/>

    <div className='' style={{width:'100%',display:'flex',justifyContent:'center'}}>
      <div className="window-width-resp">
      <Search/>
      <Home/>
      </div>
    </div>
    <Footer/>
    </>);
}

export default Main;