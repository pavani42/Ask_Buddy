import { Link } from 'react-router-dom';

const Main = () => {
  return (
    <>

      {/* <h1>footer</h1> */}
      <div className="width-resp-footer" style={{ width: '100%', background: "linear-gradient(90deg,rgb(95 30 190) 10%,rgb(60 145 255))", display: 'flex', justifyContent: 'center' }}>
        <footer className="footer-content window-width-resp" style={{}}>

          <div className="footer-content-left" style={{ marginLeft: '10px' }}>
            <Link style={{ textDecoration: 'none', color: 'white' }} to='/'>About us</Link>
            <span style={{ margin: '0 15px 0 15px', color: 'white' }}>|</span>
            <Link style={{ textDecoration: 'none', color: 'white' }} to='/fdb'>Feedback</Link>
            <span style={{ margin: '0 15px 0 15px', color: 'white' }}>|</span>
            <Link to='/contact-us' style={{ textDecoration: 'none', color: 'white' }}>Contact</Link>
            <span style={{ margin: '0 15px 0 15px', color: 'white' }}>|</span>
            <Link to='/join-us' style={{ textDecoration: 'none', color: 'white' }}>Join us</Link>
            <span style={{ margin: '0 15px 0 15px', color: 'white' }}>|</span>
            <Link to='/teaminfo' style={{ textDecoration: 'none', color: 'white' }}>Team</Link>

          </div>
          <div className="footer-content-right" style={{ color: 'white', marginRight: '10px' }}>
            <p style={{ margin: '10px' }}>© HCL TECH 2023</p>
          </div>
        </footer>
      </div>
    </>
  );
}
export default Main;