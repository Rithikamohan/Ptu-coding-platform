import React from "react";
import { useSelector } from "react-redux";
import authToken from "../utils/authToken";
import Sidebar from "./Sidebar";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import empService from ".././services/stu.service";
import { Link } from "react-router-dom";
import { useState } from "react";
import { useEffect } from "react";
import { MDBCol, MDBContainer, MDBRow, MDBCard, MDBCardText, MDBCardBody, MDBCardImage, MDBTypography, MDBIcon } from 'mdb-react-ui-kit';
import fac from "./graduated.png";
const Home = () => 
{
  if (localStorage.jwtToken) {
    authToken(localStorage.jwtToken);
  }

  const username=window.localStorage.getItem("username");
  let uname = username ;
   
 // console.log(uname)
  const [cmark, setcmark] = useState("");
  const [cplusmark, setcplusmark] = useState("");
  const [pymark, setpymark] = useState("");
  const [mark, setMark] = useState();
  useEffect(() => {
    init();
getC(uname);
getCplus(uname);
getpy(uname);
  deleteEmp(uname);
  }, []);
  if (localStorage.jwtToken) {
    authToken(localStorage.jwtToken);
  }
  const [empList, setEmpList] = useState([]);
  const init = () => {
    empService
      .getAllEmp()
      .then((res) => {
        
        //console.log(res.data);
        for(let i=0;i<=res.data.length;i++)
        {
          let item=res.data[i];
          let name=item.name;
          //console.log(item);
         //console.log(username)
         let user=uname
          
        if(user===name)
        {
          setEmpList(res.data[i]);      
        }
        }
        
      })
      .catch((error) => {
        console.log(error);
      });
  };
  
  const deleteEmp = (name) => {
    empService
      .getMark(name)
      .then((res) => {
        console.log(res.data);
        setMark(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 
  //get c mark
  const getC = (name) => {
    empService
      .getC(name)
      .then((res) => {
        // console.log("c mark in home page"+res.data);
        setcmark(res.data);
      
      })
      .catch((error) => {
        console.log(error);
      });
  }; 

  const getCplus = (name) => {
    empService
      .getCplus(name)
      .then((res) => {
   
        setcplusmark(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }; 

  const getpy = (name) => {
    empService
      .getPy(name)
      .then((res) => {
      
        setpymark(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }; 
let totals=cmark+cplusmark+pymark;
const styles = {
  colm: {
    width: 150, /* Desired width */
    height: 100 /* Desired height */
  }
  
};
  return (
    <div className="container-fluid bg-secondary min-vh-100">
      <div className="row">
        <div className="col-2 bg-white vh-100">
          <Sidebar />
        </div>
        <div className="col">
          <div className="px-3">
            <div className="container-fluid">
              <div className="row g-3 my-3">
                <div className="col">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">3</h3>

                      <p className="fs-5">Code Problems solved</p>
                    </div>
                    <i class="fas fa-users  fa-lg"></i>
                  </div>
                </div>

                <div style={styles.colm} className="col-md-3">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">4</h3>
                      <p className="fs-5">Rank</p>
                    </div>

                    <i class="fas fa-chalkboard-teacher  fa-lg"></i>
                  </div>
                </div>

                <div style={styles.colm} className="col-md-3">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>

                      <h3 className="fs-2">{totals}</h3>
                      <p className="fs-5">Total Points Earned </p>
                    </div>
                    <i className="bi-file-earmark-code fa-lg"></i>
                  </div>
                </div>
                <div style={styles.colm} className="col-md-3">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">{cmark}</h3>
                      <p className="fs-5">C Language points </p>
                    </div>
                    <i className="bi-file-earmark-code fa-lg"></i>
                  </div>
                </div>
                <div className="col-md-3 p-2">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">{cplusmark}</h3>
                      <p className="fs-5">C++ Language points </p>
                    </div>
                    <i className="bi-file-earmark-code fa-lg"></i>
                  </div>
                </div>

                <div className="col-md-3 p-2">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">{pymark}</h3>
                      <p className="fs-5">Python Language points </p>
                    </div>
                    <i className="bi-file-earmark-code fa-lg"></i>
                  </div>
                </div>

              </div>
            </div>

      <MDBContainer className="py-0 h-100">
        <MDBRow className="justify-content-center align-items-center h-100">
          <MDBCol lg="6" className="mb-4 mb-lg-0">
            <MDBCard className="mb-3" style={{ borderRadius: '.5rem' }}>
              <MDBRow className="g-0">
                <MDBCol md="4" className="gradient-custom text-center text-white"
                  style={{ borderTopLeftRadius: '.5rem', borderBottomLeftRadius: '.5rem' }}>
                  <MDBCardImage src={fac}
                    alt="Avatar" className="my-5" style={{ width: '80px' }} fluid />
                  <MDBTypography tag="h5"> {empList.name}</MDBTypography>
                  <MDBCardText>Student at PTU</MDBCardText>
                  <MDBIcon far icon="edit mb-5" />
                </MDBCol>
                <MDBCol md="8">
                  <MDBCardBody className="p-4">
                    <MDBTypography tag="h6">Student Detail</MDBTypography>
                    <hr className="mt-0 mb-4" />
                    <MDBRow className="pt-1">
                      <MDBCol size="6" className="mb-3">
                        <MDBTypography tag="h6">PTU Mail ID</MDBTypography>
                        <MDBCardText className="text-muted">{empList.email}</MDBCardText>
                      </MDBCol>
                      <MDBCol size="6" className="mb-3">
                        <MDBTypography tag="h6">Register Number</MDBTypography>
                        <MDBCardText className="text-muted">{empList.mobile}</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <MDBRow className="pt-1">
                      <MDBCol size="15" className="mb-3">
                        <MDBTypography tag="h6">Department</MDBTypography>
                        <MDBCardText className="text-muted">Computer Science and Engineering, PTU</MDBCardText>
                      </MDBCol>
                      
                    </MDBRow>
<br/>
                    <div className="d-flex justify-content-start">
                      <a href="#!"><MDBIcon fab icon="facebook me-3" size="lg" /></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <a href="#!"><MDBIcon fab icon="twitter me-3" size="lg" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <a href="#!"><MDBIcon fab icon="instagram me-3" size="lg" /></a>
                    </div>
                  </MDBCardBody>
                </MDBCol>
              </MDBRow>
            </MDBCard>
          </MDBCol>
        </MDBRow>
      </MDBContainer>

            {/* <table class="table caption-top bg-white rounded mt -2">
              <thead className="thead-dark">
                <tr>
                  <th scope="col">SL.NO</th>
                  <th scope="col">Student Name</th>
                  <th scope="col">Student ID</th>
                  <th scope="col">Register Number</th>
                  <th scope="col">Email ID</th>
                  <th scope="col">Operations</th>
                </tr>
              </thead>
              <tbody>
              
                  <tr>
                    <th scope="row">1</th>
                    <td>{empList.name}</td>
                    <td>{empList.id}</td>
                    <td>{empList.mobile}</td>
                    <td>{empList.email}</td>
                    <td>
                      <Link
                        to={"/" + empList.id}
                        className="btn btn-sm btn-primary"
                      >
                        Edit
                      </Link>
                     
                    </td>
                  </tr> 
              </tbody>
            </table> */}
          </div>
        </div>
        <div></div>
      </div>
    </div>
  );
};

export default Home;
