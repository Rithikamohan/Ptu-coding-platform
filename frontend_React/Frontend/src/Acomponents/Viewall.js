import React from 'react'
import { useState } from "react";
import { useEffect } from "react";
import Sidebar from "./Sidebar";
import empService from ".././services/stu.service";
import facService from ".././Fservices/fac.service";
const Viewall = () => {

const [empList, setEmpList] = useState([]);

  //fac
  const [facList, setFacList] = useState([]);

  useEffect(() => {
    init();
    initF();

  }, []);
  const init = () => {
    let arr=[];
    empService
      .getAllEmp()
      .then((res) => {
    //console.log(res.data);
        setEmpList(res.data);

      })
    
      .catch((error) => {
        console.log(error);
      });
  };

  const initF = () => {
    facService
      .getAllFac()
      .then((res) => {

        console.log(res.data);
        setFacList(res.data);
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
      <div className="container-fluid">
      <p className="text-white h3">Students List</p>


            <table class="table caption-top bg-white rounded mt -2">
              <thead className="thead-dark">
                <tr>
                  <th scope="col">SL.NO</th>
                  <th scope="col">Student Name</th>
                  <th scope="col">Student ID</th>
                  <th scope="col">Register Number</th>
                  <th scope="col">Email ID</th>
                  
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
                
                  </tr>
                ))}
              </tbody>
            </table>

            <p className="text-white h3">Faculty List</p>
  

            <table class="table caption-top bg-white rounded mt -2">
              <thead className="thead-dark">
                <tr>
                  <th scope="col">SL.NO</th>
                  <th scope="col">Student Name</th>
                  <th scope="col">Student ID</th>
                  <th scope="col">Register Number</th>
                  <th scope="col">Email ID</th>
                </tr>
              </thead>
              <tbody>
                {facList.map((e, num) => (
                  <tr>
                    <th scope="row">{num + 1}</th>
                    <td>{e.name}</td>
                    <td>{e.id}</td>
                    <td>{e.mobile}</td>
                    <td>{e.email}</td>
                   
                  </tr>
                ))}
              </tbody>
            </table>

        </div></div></div> </div></div>
  )
}

export default Viewall