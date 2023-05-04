import { useParams } from 'react-router-dom';
import { useEffect, useContext } from 'react';
// import data from '../Dummy_data/data.jsx';
import AnswerCard from '../Answer_component/answer.jsx';
import { color } from '@mui/system';
import axios from 'axios';
import { useState } from 'react';
import fetchData from '../FetchingDataFromApi/context.jsx'
// import FontAwesomeIcon from ''
const Main = () => {
  //////////////////////////FOR FETCHING & STORING API IN ARRAY////////////////////////////////// 
  // const data = useContext(fetchData);
  const [formData, setFormData] = useState({});
  // const [b, setB] = useState([])
  // console.log(data);
  const [a, setA] = useState({

    question: {
      question: "",
      questionDescription: '',
      user:{
           username : ""
      }
    },

    answerList: [{
      description: '',
      user:{
        username : ""
   }
    },]
  });
  //////////////////////////FOR FETCHING & STORING API IN ARRAY////////////////////////////////// 
  const { slug } = useParams();
  console.log(slug)
  const data = useContext(fetchData);
  console.log(data);
  // const a = data.data.find((item) => item.question.question === slug);
  // console.log(a.answerList[0])
  // console.log(a.question.question)
  useEffect(() => {
    console.log("HIHII");
  }, [a]);
  useEffect(() => {
    if ((data.data.find((item) => item.question.question === slug)) !== undefined) {
      setA(data.data.find((item) => item.question.question === slug));
    }
  }, [data]);
  console.log(a)
  const user = JSON.parse(localStorage.getItem('token'));
  const submitHandle = async (event) => {
    event.preventDefault();
    if (localStorage.getItem('token') == null) {
      window.alert("Please login to post the answer!");
      // window.location.href = '/login';
    }
    // const response = await axios.post('http://localhost:9090/postAnswer?answer=kjd&question=kdm', formData);
    else {
      try {
        // console.log(formData.Detailed_Answer + a.question.question)
        // answer = encodeURIComponent(formData.Detailed_Answer);
        const response = await axios('http://localhost:9191/api/answers/postAnswer?answer=' + encodeURIComponent(formData.Detailed_Answer) + '&question=' + encodeURIComponent(a.question.question), {
          method: "post",
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json",
            "Authorization": "Bearer " + user,
            mode: "no-cors",
          },
        });
        console.log(response);
        if (response.data.message == "Please Login")
          window.alert("Please login")
        if (response.status == 200) {
          setTimeout(function () {
            document.getElementById("modalCloseButton").click();
            alert("Answer posted successfully !!")
          }, 300);
        }
      }
      catch (error) {
        window.alert(error.message)
      }
    }
  }
  console.log(a.question.question)
  console.log(a.answerList.description)
  console.log(a.question.user.username)
  return (
    <>
      <div className="detailed-div-1" style={{ width: '100%', display: 'flex', justifyContent: 'center', marginTop: '80px', minHeight: 'calc(100vh - 107px)' }}>
        <div className="detailed-div-2" style={{}}>
          <div className="detailed-div-3">
            <div className="detailed-div-3-content" style={{ display: 'flex' }}>
              <div className="detailed-div-5-like-dislike" style={{ marginRight: '25px' }}>
                {/* <FontAwesomeIcon icon="fa-solid fa-triangle" /> */}
                <p style={{ fontSize: '35px', margin: '0', color: 'grey' }}>&#9650;</p>
                <p style={{ fontSize: '25px', margin: '0' }}>10</p>
                <p style={{ fontSize: '35px', margin: '0', color: 'grey' }}>&#9660; </p>
              </div>
              <div className="detailed-div-4-ques-bar">
                <h2 style={{ color: 'black' }}>{a.question.question}</h2>
                {/* Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis alias animi voluptatem similique aspernatur voluptatum unde, minima laborum, perferendis, tenetur vitae reprehenderit esse aperiam rerum dolor rem commodi ipsa temporibus!
                Voluptatibus nihil corrupti nemo dicta aspernatur quidem architecto cumque maiores perferendis, quae excepturi officiis ea vero consectetur aperiam quisquam molestias iste qui reiciendis ullam tempora, ipsa natus. Consectetur, accusamus architecto?
                Dolores tempora odit, possimus rerum voluptatum repellat aliquid omnis quia fugiat quas voluptas, voluptate repudiandae! Esse nostrum ea commodi laboriosam sit voluptates architecto expedita. Cupiditate consectetur dolor voluptatum nobis molestias.
                Temporibus odio aut minima voluptate illum facere hic excepturi dolor repellendus. Facere atque asperiores tempora quam laboriosam maiores dolorum aliquam, velit similique qui ab? Doloremque nulla sapiente accusantium nisi quo. */}
                <div>{a.question.quesDescription}</div>
                <a data-toggle="modal" data-target="#exampleModal" className='replyButtonDQAP'>
                  <i className="fa fa-reply" aria-hidden="true"></i>
                  Reply</a>
                <div style={{ display: 'flex' }} title="Asked by"><img src="https://static.vecteezy.com/system/resources/thumbnails/009/734/564/small/default-avatar-profile-icon-of-social-media-user-vector.jpg" alt="" width="35px" height="35px" draggable="false" /> <p style={{ color: '#b2b2b2', marginTop: '5px' }}>{a.question.user.username}</p></div>

              {/* </div> */}
              <hr style={{ width: '100%' }} />
            </div>              </div>
          <div className="detailed-div-6-like-dislike" style={{ display: 'flex' }}>
            <div className="detailed-div-5-like-dislike" style={{ marginRight: '25px' }}>
              {/* <FontAwesomeIcon icon="fa-solid fa-triangle" /> */}
              <p style={{ fontSize: '35px', margin: '0', color: 'grey' }}>&#9650;</p>
              <p style={{ fontSize: '25px', margin: '0' }}>10</p>
              <p style={{ fontSize: '35px', margin: '0', color: 'grey' }}>&#9660; </p>
            </div>
            <hr />
            {/* <div></div> */}
            {/* <AnswerCard Answer={a.answerList[0].description} /> */}
            <div>
              <h4 style={{ color: 'black' }}>Answer</h4>
              {a.answerList.map((val) => {
                return (
                  <><hr />
                    <AnswerCard Answer={val.description} Username = {val.user.username}/>
                  </>
                )
              })}
            </div>
          </div>
        </div>
      </div>
    </div >
      <form onSubmit={submitHandle}>
        <div className="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header" style={{ backgroundColor: 'rgb(95 30 190)' }}>
                <h5 className="modal-title" id="exampleModalLabel" style={{ color: 'white' }}>Comment your answer!</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close" style={{ border: 'none', fontSize: '25px', backgroundColor: 'rgb(95 30 190)', color: 'white' }}>
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                {/* <div className="form-group">
                  <label for="question-asked" className="col-form-label" style={{ color: 'black' }}>Title</label>
                  <input required type="text" className="form-control" id="question-asked" name='question' onChange={(e) => setFormData({ ...formData, Answer: e.target.value })} />
                </div> */}
                <div className="form-group">
                  <label for="message-text" className="col-form-label" style={{ color: 'black' }}>Details of answer</label>
                  <textarea required type="text" className="form-control" id="message-text" name="detailed-question" onChange={(e) => setFormData({ ...formData, Detailed_Answer: e.target.value })}> </textarea>
                </div>              </div>              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" id="modalCloseButton" data-dismiss="modal">Close</button>
                <button type="submit" className="btn btn-primary" style={{ backgroundColor: 'rgb(95, 30, 190)' }}>ASK</button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </>
  );

}
export default Main;