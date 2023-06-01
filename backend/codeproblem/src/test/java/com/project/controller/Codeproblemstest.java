package com.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.model.*;
import com.project.service.CodeService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class Codeproblemstest {

@Mock
private CodeService service;
private  CodeController ccontroller;
private  CplusController cpluscontroller;
private  PyController pycontroller;

@BeforeEach
void setup() {
    MockitoAnnotations.openMocks(this);
    ccontroller = new CodeController(service);
    cpluscontroller = new CplusController(service);
    pycontroller = new PyController(service);
}

@Test
void saveCode_shouldReturnSavedCCode() {
    // Create a code
	Code c=new Code();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase1("testing testcase");
	
    // Set up mock behavior
    when(service.createEmp(c)).thenReturn(c);

    // Perform the request
    ResponseEntity<Code> response = ccontroller.createEmp(c);

    // Verify the mock interactions
    verify(service, times(1)).createEmp(c);

    // Check the response
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(c, response.getBody());
}

@Test
void saveCplusCode_shouldReturnSavedCplusCode() {
    // Create a code
	Cplus c=new Cplus();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
	
    // Set up mock behavior
    when(service.createcplus(c)).thenReturn(c);

    // Perform the request
    ResponseEntity<Cplus> response = cpluscontroller.createEmp(c);

    // Verify the mock interactions
    verify(service, times(1)).createcplus(c);

    // Check the response
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(c, response.getBody());
}

@Test
void savePyCode_shouldReturnSavedPyCode() {
    // Create a code
	Pycode c=new Pycode();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
	
    // Set up mock behavior
    when(service.createpy(c)).thenReturn(c);

    // Perform the request
    ResponseEntity<Pycode> response = pycontroller.createEmp(c);

    // Verify the mock interactions
    verify(service, times(1)).createpy(c);

    // Check the response
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(c, response.getBody());
}

@Test
void getCodeById_shouldReturnCodeById() {
    // Create a donation
	Code c=new Code();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase1("testing testcase");


    // Set up mock behavior
    when(service.getCodeById(1)).thenReturn(c);

    // Perform the request
    ResponseEntity<Code> response = ccontroller.getEmpById(1);

    // Verify the mock interactions
    verify(service, times(1)).getCodeById(1);

    // Check the response
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(c, response.getBody());
}

@Test
void getCplusById_shouldReturnCodeById() {
    // Create a donation
	Cplus c=new Cplus();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");


    // Set up mock behavior
    when(service.getcplusById(1)).thenReturn(c);

    // Perform the request
    ResponseEntity<Cplus> response = cpluscontroller.getEmpById(1);

    // Verify the mock interactions
    verify(service, times(1)).getcplusById(1);

    // Check the response
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(c, response.getBody());
}
@Test
void getPyById_shouldReturnCodeById() {
    // Create a donation
	Pycode c=new Pycode();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");


    // Set up mock behavior
    when(service.getpyById(1)).thenReturn(c);

    // Perform the request
    ResponseEntity<Pycode> response = pycontroller.getEmpById(1);

    // Verify the mock interactions
    verify(service, times(1)).getpyById(1);

    // Check the response
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(c, response.getBody());
}


@Test
void getAllCcode_shouldReturnAllCcode() {
    // Create a list of donations
    List<Code> ccode = new ArrayList<>();
    Code c = new Code();
    c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase1("testing testcase");
    ccode.add(c);
    Code c1 = new Code();
    c1.setId(2);
	c1.setCodetype("basic");
	c1.setQuestion("testing");
	c1.setTestcase1("testing testcase");
    ccode.add(c1);

    // Set up mock behavior
    when(service.getAllEmp()).thenReturn(ccode);

    // Perform the request
    ResponseEntity<List<Code>> response = ccontroller.getAllEmp();

    // Verify the mock interactions
    verify(service, times(1)).getAllEmp();

    // Check the response
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(ccode, response.getBody());
}
//cplus
@Test
void getAllCplus() {
    // Create a list of donations
    List<Cplus> cpluscode = new ArrayList<>();
    Cplus c = new Cplus();
    c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
    cpluscode.add(c);
    Cplus c1 = new Cplus();
    c1.setId(2);
	c1.setCodetype("basic");
	c1.setQuestion("testing");
	c1.setTestcase("testing testcase");
    cpluscode.add(c1);

    // Set up mock behavior
    when(service.getAllCplus()).thenReturn(cpluscode);

    // Perform the request
    ResponseEntity<List<Cplus>> response = cpluscontroller.getAllEmp();

    // Verify the mock interactions
    verify(service, times(1)).getAllCplus();

    // Check the response
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(cpluscode, response.getBody());
}
//cplus
@Test
void getAllpy() {
  // Create a list of donations
  List<Pycode> py = new ArrayList<>();
  Pycode c = new Pycode();
  c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
  py.add(c);
  Pycode c1 = new Pycode();
  c1.setId(2);
	c1.setCodetype("basic");
	c1.setQuestion("testing");
	c1.setTestcase("testing testcase");
  py.add(c1);

  // Set up mock behavior
  when(service.getAllPy()).thenReturn(py);

  // Perform the request
  ResponseEntity<List<Pycode>> response = pycontroller.getAllEmp();

  // Verify the mock interactions
  verify(service, times(1)).getAllPy();

  // Check the response
  assertEquals(HttpStatus.OK, response.getStatusCode());
  assertEquals(py, response.getBody());
}


}
