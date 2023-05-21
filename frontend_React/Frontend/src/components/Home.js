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
  const [mark, setMark] = useState();
  useEffect(() => {
    init();
getC(uname);
getCplus(uname);
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
        console.log("c mark in home page"+res.data);
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
        console.log("c plus mark"+res.data);
        setcplusmark(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }; 
let totals=cmark+cplusmark;

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
                <div className="col-md-3 p-2">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">3</h3>

                      <p className="fs-5">Code Problems solved</p>
                    </div>
                    <i class="fas fa-users  fa-lg"></i>
                  </div>
                </div>

                <div className="col-md-3 p-2">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>
                      <h3 className="fs-2">4</h3>
                      <p className="fs-5">Rank</p>
                    </div>

                    <i class="fas fa-chalkboard-teacher  fa-lg"></i>
                  </div>
                </div>

                <div className="col-md-3 p-2">
                  <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                    <div>

                      <h3 className="fs-2">{totals}</h3>
                      <p className="fs-5">Total Points Earned </p>
                    </div>
                    <i className="bi-file-earmark-code fa-lg"></i>
                  </div>
                </div>
                <div className="col-md-3 p-2">
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

              </div>
            </div>
            
            <p className="text-white h3">Student Detail</p>
           {/* <p className="text-center text-success">msg</p> */}

            <table class="table caption-top bg-white rounded mt -2">
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
            </table>
          </div>
        </div>
        <div></div>
      </div>
    </div>
  );
};

export default Home;
