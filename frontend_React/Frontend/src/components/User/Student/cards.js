import React,{Component} from 'react'
import cimage from './cimage.png';
import cplus from './c++.png';
import py from './py.webp';
import { Link } from "react-router-dom";
import "./Cards.css";
const Cards =() =>{
    
        return (
            <React.Fragment>
                   <h1 className="text-center text-danger text-capitalize my-5  ">
                   &nbsp;&nbsp;
      </h1>
<div className="container">
        <div className="row">
          <div className="col-sm">
            <div class="card">
              <img src={cplus} className="card-img-top" height="300px" />
              <div className="card-body">
                <h3 className="card-title text-xl-center font-weight-bold font-italic ">
                  C++ Programming
                </h3>  <hr />
                <div className="row d-flex justify-content-center align-content-center ">
                <Link to={
                    {
                    pathname:"editor",
                    state:{
                        lang:'cpp'
                    }
                }} className="nav-link">
                  <h4>Start Coding</h4>
                  </Link>
                </div>
              </div>
            </div>
          </div>
          <div className="col-sm">
            <div className="card">
              <img src={py} className="card-img-top" height="300px" />

              <div className="card-body">
                <h3 className="card-title text-center font-weight-bold font-italic">
                  Python Programming
                </h3>  <hr />
                <p className="card-text"></p>
                <div className="row d-flex justify-content-center align-content-center ">
                <Link to={"login"} className="nav-link">
                <h4>Start Coding</h4>
                  </Link>
                </div>
              </div>
            </div>
          </div>
          <div className="col-sm">
            <div className="card">
              <img src={cimage} className="card-img-top" height="300px" />
              <div className="card-body">
                <h3 className="card-title text-xl-center font-weight-bold font-italic">
                  C Programming
                </h3>
                <hr />
                <p className="card-text"></p>
                <div className="row d-flex justify-content-center align-content-center ">
                <Link to={
                    {
                    pathname:"editor",
                    state:{
                        lang:'c'
                    }
                }}
                     className="nav-link">
                    <h4>Start Coding</h4>
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </React.Fragment>


        )
    }

export default Cards;