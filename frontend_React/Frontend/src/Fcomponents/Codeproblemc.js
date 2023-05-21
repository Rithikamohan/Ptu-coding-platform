import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import axios from 'axios';
import { useState } from 'react';
import "./Codeproblem.css"
import Sidebar from "./Sidebar";
import empService from ".././Codeproblems/code.service";

const Codeproblemc =() => {
    const initialValues = {
        codetype: '',
        question: '',
        testcase1: '',
      };
    const [values, setValues] = useState(initialValues);
    const [errors, setErrors] = useState({});


 
  const validationSchema = Yup.object().shape({
    codetype: Yup.string().required('Code type is required'),
    question: Yup.string().required('Question is required'),
    testcase1: Yup.string().required('Test case is required'),
  });
  
  const handleChange = (event) => {
    const { name, value } = event.target;
    setValues((prevValues) => ({
      ...prevValues,
      [name]: value,
    }));
  };
  const submitStu = (e) => 
  {
    e.preventDefault();
    empService
    .saveEmp(values).then((res) => {
      setValues({
        codetype: "",
        question: "",
        testcase1: "",
        
      });
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
      <div className="form-container text-white ">
        <h1>Add Code Problem</h1>
        <form onSubmit={(e) => submitStu(e)}>
      <label>
        Code Type:
        <input type="text" name="codetype" value={values.codetype} onChange={handleChange} />
        {errors.codetype && <div>{errors.codetype}</div>}
      </label>
      <label>
        Question:
        <input type="text" name="question" value={values.question} onChange={handleChange} />
        {errors.question && <div>{errors.question}</div>}
      </label>
      <label>
        Test Case:
        <input type="text" name="testcase1" value={values.testcase1} onChange={handleChange} />
        {errors.testcase1 && <div>{errors.testcase1}</div>}
      </label>
      <button type="submit">Submit</button>
    </form>
      </div>
      </div>
      </div>
      </div>
      </div>
      
    );
  }

export default Codeproblemc;
