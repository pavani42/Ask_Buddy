import 'mdb-react-ui-kit/dist/css/mdb.min.css';
// import "@fortawesome/fontawesome-free/css/all.min.css";
/////////////////////////////////JOIN_US css/////////////////////////////////////////////////


import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import './login/login.css';
import App from './Routing.jsx';
import { BrowserRouter } from 'react-router-dom';
import Demo from './Detailed_ques_ans_page/detailed_ques_ans_page.jsx';



// import 'mdb-react-ui-kit/dist/css/mdb.min.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <App/>
  </BrowserRouter>
);


