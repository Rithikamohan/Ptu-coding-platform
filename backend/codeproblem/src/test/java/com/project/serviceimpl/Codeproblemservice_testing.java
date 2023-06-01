package com.project.serviceimpl;
import static org.mockito.Mockito.times;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.project.respository.*;
import com.project.service.CodeServiceimpl;
import com.project.model.*;
@SpringBootTest
@Transactional
public class Codeproblemservice_testing {
@Mock
private CodeRepository crep;

@Mock
private CplusRepository cplusrep;


@Mock
private PyRepository pyrep;
@InjectMocks
private CodeServiceimpl service;

@BeforeEach
public void setUp() {
    MockitoAnnotations.initMocks(this);
}
//c
@Test
public void testGetCodeById() {
    // Arrange
   int codeid = 1;
    Code c = new Code();
    c.setId(codeid);
    // You can set other properties of the donation object as needed

    
    when(crep.findById(codeid)).thenReturn(Optional.of(c));

    // Act
    Code ccode = service.getCodeById(codeid);

    // Assert
    verify(crep, times(1)).findById(codeid);
    assertEquals(c, ccode);
}
//cplus

@Test
public void testGetCplusById() {
    // Arrange
   int codeid = 1;
    Cplus c = new Cplus();
    c.setId(codeid);
    // You can set other properties of the donation object as needed

    
    when(cplusrep.findById(codeid)).thenReturn(Optional.of(c));

    // Act
    Cplus ccode = service.getcplusById(codeid);

    // Assert
    verify(cplusrep, times(1)).findById(codeid);
    assertEquals(c, ccode);
}
//py


@Test
public void testGetPyById() {
    // Arrange
   int codeid = 1;
    Pycode c = new Pycode();
    c.setId(codeid);
    // You can set other properties of the donation object as needed

    
    when(pyrep.findById(codeid)).thenReturn(Optional.of(c));

    // Act
    Pycode ccode = service.getpyById(codeid);

    // Assert
    verify(pyrep, times(1)).findById(codeid);
    assertEquals(c, ccode);
}
//c
@Test
public void saveCcode() {
	Code c=new Code();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase1("testing testcase");
	service.createEmp(c);
	verify(crep,times(1)).save(c);
}
//cplus
@Test
public void saveCpluscode() {
	Cplus c=new Cplus();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
	service.createcplus(c);
	verify(cplusrep,times(1)).save(c);
}
//py
@Test
public void savePycode() {
	Pycode c=new Pycode();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
	service.createpy(c);
	verify(pyrep,times(1)).save(c);
}

//c
@Test
public void getAllCode() {

	List<Code> ccoding = crep.findAll();
	 verify(crep, times(1)).findAll();
	
}
//cplus
@Test
public void getAllCplus() {

	List<Cplus> ccoding = cplusrep.findAll();
	 verify(cplusrep, times(1)).findAll();
	
}
//c
@Test
public void getAllPy() {

	List<Pycode> ccoding = pyrep.findAll();
	 verify(pyrep, times(1)).findAll();
	
}

}
