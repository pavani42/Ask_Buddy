const Main=(p)=>{
  console.log(p)
    return (
        <>
        <div className="detailed-div-5-ans-bar">
           
          {/* <h4 style={{color:'black'}}>Answer</h4> */}
          {p.Answer}
          <div style={{ display: 'flex' }} title="Asked by"><img src="https://static.vecteezy.com/system/resources/thumbnails/009/734/564/small/default-avatar-profile-icon-of-social-media-user-vector.jpg" alt="" width="35px" height="35px" draggable="false" /> <p style={{ color: '#b2b2b2', marginTop: '5px' }}>{p.Username}</p></div>
        </div>
        </>
    );
}

export default Main;