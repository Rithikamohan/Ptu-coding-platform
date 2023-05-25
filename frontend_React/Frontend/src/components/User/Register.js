import React, { useState } from "react";
import { useDispatch } from "react-redux";
import {
  Row,
  Col,
  Card,
  Form,
  InputGroup,
  FormControl,
  Button,
}
from "react-bootstrap";

import "./Style.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  
  faEnvelope,
  faLock,
  faUndo,
  faUserPlus,
 faAddressCard,
  faUser,
} from "@fortawesome/free-solid-svg-icons";
//import {registerUser} from "E:\FinalProject\Student\reactjs\reactjs\src\services\index";
import { registerUser } from "../../services/index";
import MyToast from "../MyToast";
import pic from "./logo.png";

const Register = (props) => {
  const [show, setShow] = useState(false);
  const [message, setMessage] = useState("");
  const initialState = {
    name: "",
    email: "",
    password: "",
    mobile: "",
    faculty:"",
  };
  const [user, setUser] = useState(initialState);
  const userChange = (event) => {
    const { name, value } = event.target;
    setUser({ ...user, [name]: value });
  };
 const dispatch = useDispatch();
  const saveUser = () => {
    dispatch(registerUser(user))
      .then((response) => {
        setShow(true);
        setMessage(response.message);
        resetRegisterForm();
        setTimeout(() => {
          setShow(false);
          props.history.push("/login");
        }, 2000);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const resetRegisterForm = () => {
    setUser(initialState);
  };

 const styles = {
    row: {
        marginLeft: 370,
        marginRight: 0,
        padding: "5rem",
        width: "900px" 
    },
    col: {
        paddingLeft: 0,
        paddingRight: 0
    }
};

  return (
    <div>
      <div style={{ display: show ? "block" : "none" }}>

        <MyToast show={show} message={message} type={"success"} />
      </div>
      <Row style={styles.row}>
      
        <Col xs={10}>
          <Card className={"border border-dark bg-dark text-white"}>
          
            <Card.Header >
              
              <img className="d-block mx-auto w-25 h-25"
          src={pic}
          
          alt="brand"
          
        />
          
            </Card.Header>
            <Card.Body>
            <h2 align="center"><FontAwesomeIcon icon={faUserPlus} />&nbsp; REGISTER</h2>
               
              <Form.Row>
                <Form.Group as={Col}>
                  <InputGroup>
                    <InputGroup.Prepend>
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faUser} />
                      </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                      autoComplete="off"
                      type="text"
                      name="name"
                      value={user.name}
                      onChange={userChange}
                      className={"bg-dark text-white"}
                      placeholder="Enter Name"
                    />
                  </InputGroup>
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col}>
                  <InputGroup>
                    <InputGroup.Prepend>
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faEnvelope} />
                      </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                      required
                      autoComplete="off"
                      type="text"
                      name="email"
                      value={user.email}
                      onChange={userChange}
                      className={"bg-dark text-white"}
                      placeholder="Enter PTU email Address"
                    />
                  </InputGroup>
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col}>
                  <InputGroup>
                    <InputGroup.Prepend>
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faLock} />
                      </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                      required
                      autoComplete="off"
                      type="password"
                      name="password"
                      value={user.password}
                      onChange={userChange}
                      className={"bg-dark text-white"}
                      placeholder="Enter Password"
                    />
                  </InputGroup>
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col}>
                  <InputGroup>
                    <InputGroup.Prepend>
                      <InputGroup.Text>
                      <FontAwesomeIcon icon={faAddressCard} />
                      </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                      autoComplete="off"
                      type="text"
                      name="mobile"
                      value={user.mobile}
                      onChange={userChange}
                      className={"bg-dark text-white"}
                      placeholder="Enter Register Number"
                    />
                  </InputGroup>
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col}>
                  <InputGroup>
                    <InputGroup.Prepend>
                      <InputGroup.Text>
                      <FontAwesomeIcon icon={faUser} />
                      </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                      autoComplete="off"
                      as="select"
                      name="faculty"
                      value={user.faculty}
                      onChange={userChange}
                      className={"bg-dark text-white"}
                      placeholder="Enter Faculty Number"
                    
                      >
                      <option value="op">Select Faculty </option>
                      <option value="Dr.Sathiyamurthy">Dr.Sathiyamurthy </option>
                      <option value="Dr.Akila">Dr. Akila</option>
                      <option value="Dr. Sheeba">Dr. Sheeba</option>
                      <option value="Dr. karunakaran">Dr. karunakaran</option>
                      <option value="Dr. Sarala">Dr. Sarala</option>
                      <option value="Dr. Kavitha kumar">Dr. Kavitha kumar</option>

                    </FormControl>
                  </InputGroup>
                </Form.Group>
              </Form.Row>
            </Card.Body>
            <Card.Footer style={{ textAlign: "right" }}>
              <Button
                size="sm"
                type="button"
                variant="success"
                onClick={saveUser}
                disabled={user.email.length === 0 || user.password.length === 0}
              >
                <FontAwesomeIcon icon={faUserPlus} /> Register
              </Button>{" "}
              <Button
                size="sm"
                type="button"
                variant="info"
                onClick={resetRegisterForm}
              >
                <FontAwesomeIcon icon={faUndo} /> Reset
              </Button>
            </Card.Footer>
          </Card>
        </Col>
      </Row>
    </div>
  );
};
export default Register;
