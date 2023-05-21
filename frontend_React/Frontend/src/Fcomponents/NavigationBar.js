import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import pic from "./logo.png";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faUserPlus,
  faSignInAlt,
  faSignOutAlt,
} from "@fortawesome/free-solid-svg-icons";
import { logoutUser } from "../services/index";

const NavigationBar = () => {
  const auth = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const isLoggedIn=window.localStorage.getItem("loggedIn");
  const username=window.localStorage.getItem("username");
  const logout = () => {
    dispatch(logoutUser());
  };

  const guestLinks = (
    <>
      <div className="mr-auto"></div>
      <Nav className="navbar-right">
        <Link to={"faculty/register"} className="nav-link">
          <FontAwesomeIcon icon={faUserPlus} /> Faculty Register
        </Link>
        <Link to={"faculty/login"} className="nav-link">
          <FontAwesomeIcon icon={faSignInAlt} /> Faculty Login
        </Link>
      </Nav>
    </>
  );
  const userLinks = (
    <>
      <Nav className="mr-auto">
        <Link to={"#"} className="nav-link">
        </Link>
        <Link to={"#"} className="nav-link">
          
        </Link>
        <Link to={"#"} className="nav-link">
       
        </Link>
      </Nav>
      <Nav className="navbar-right">
      <Link to={"username"} className="nav-link">
          {username}
        </Link>
        <Link to={"logout"} className="nav-link" onClick={logout}>
          <FontAwesomeIcon icon={faSignOutAlt} /> Logout
        </Link>
      </Nav>
    </>
  );

  return (
    <Navbar bg="light" variant="light">
      <Link to={auth.isLoggedIn ? "home" : ""} className="navbar-brand">
        <img
          src={pic}
          width="50"
          height="50"
          alt="brand"
        />{" "}
      PTU CODING AND MONITORING PLATFORM
      </Link>
      {isLoggedIn ? userLinks : guestLinks}
    </Navbar>
  );
};

export default NavigationBar;
