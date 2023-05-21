import React from "react";
import { useState } from "react";
import { useEffect } from "react";

import { useSelector } from "react-redux";
import authToken from "../utils/authToken";
import { Alert } from "react-bootstrap";
import Sidebar from "./Sidebar";
import { Link } from "react-router-dom";
import empService from ".././services/stu.service";
const Home = () => {
  const [empList, setEmpList] = useState([]);
  const [getList, List] = useState([]);
  const [msg, setMsg] = useState("");
  const auth = useSelector((state) => state.auth);

  if (localStorage.jwtToken) {
    authToken(localStorage.jwtToken);
 }
  useEffect(() => {
    init(); 
    //let name={auth.username}
  }, []);
 
  const init = () => {
    console.log(auth.username)
    let name=(auth.username)
    empService
      .findByname(name)
      .then((res) => {
        console.log(res.data);
        setEmpList(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const deleteEmp = (id) => {
    empService
      .deleteEmp(id)
      .then((res) => {
        setMsg("Delete Sucessfully");
        init();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container-fluid bg-secondary min-vh-100">
    <div className="row">
      <div className="col-2 bg-white vh-100">
        <Sidebar />
        
      </div>
      <div className="col">
        <div className="px-3">
        &nbsp;&nbsp;
          <p className="text-white h3">Students List</p>
         <p className="text-center text-success"></p> &nbsp;
         &nbsp;
         &nbsp;

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
              
            {empList.map((e, num) => (
                  <tr>
                    <th scope="row">{num + 1}</th>
                    <td>{e.name}</td>
                    <td>{e.id}</td>
                    <td>{e.mobile}</td>
                    <td>{e.email}</td>
                    <td>
                      <Link
                        to={"editStu/" + e.id}
                        className="btn btn-sm btn-primary"
                      >
                        Edit
                      </Link>
                      <a
                        onClick={() => deleteEmp(e.id)}
                        className="btn btn-sm btn-danger ms-2"
                      >
                        Delete
                      </a>
                    </td>
                  </tr>
                ))}
              
            </tbody>
          </table>
        </div>
      </div>
      <div></div>
    </div>
  </div>
  );
};
//Welcome faculty {auth.username}
export default Home;
