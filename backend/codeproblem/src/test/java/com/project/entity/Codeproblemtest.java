package com.project.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.project.model.*;
public class Codeproblemtest {
@Test
public void saveC_Codeproblems() {
	Code c=new Code();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase1("testing testcase");
	
	Assertions.assertEquals(1, c.getId());
	Assertions.assertEquals("basic",c.getCodetype());
	Assertions.assertEquals("testing",c.getQuestion());
	Assertions.assertEquals("testing testcase",c.getTestcase1());
	}

@Test
public void saveCplusCodeproblems() {
	Cplus c=new Cplus();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
	
	Assertions.assertEquals(1, c.getId());
	Assertions.assertEquals("basic",c.getCodetype());
	Assertions.assertEquals("testing",c.getQuestion());
	Assertions.assertEquals("testing testcase",c.getTestcase());
}

@Test
public void savePythonCodeproblems() {
	Pycode c=new Pycode();
	c.setId(1);
	c.setCodetype("basic");
	c.setQuestion("testing");
	c.setTestcase("testing testcase");
	
	Assertions.assertEquals(1, c.getId());
	Assertions.assertEquals("basic",c.getCodetype());
	Assertions.assertEquals("testing",c.getQuestion());
	Assertions.assertEquals("testing testcase",c.getTestcase());
}
@Test
public void testConstructor() {
    // Create a donation object using the constructor
    Code c = new Code(1, "basic", "con testing", "testcase");

    // Assert the values using getters
    Assertions.assertEquals(1, c.getId());
    Assertions.assertEquals("basic", c.getCodetype());
    Assertions.assertEquals("con testing", c.getQuestion());
    Assertions.assertEquals("testcase", c.getTestcase1());
}
@Test
public void testCplusConstructor() {
    // Create a donation object using the constructor
    Cplus c = new Cplus(1, "basic", "con testing", "testcase");

    // Assert the values using getters
    Assertions.assertEquals(1, c.getId());
    Assertions.assertEquals("basic", c.getCodetype());
    Assertions.assertEquals("con testing", c.getQuestion());
    Assertions.assertEquals("testcase", c.getTestcase());
}
@Test
public void testpyConstructor() {
    // Create a donation object using the constructor
    Pycode c = new Pycode(1, "basic", "con testing", "testcase");

    // Assert the values using getters
    Assertions.assertEquals(1, c.getId());
    Assertions.assertEquals("basic", c.getCodetype());
    Assertions.assertEquals("con testing", c.getQuestion());
    Assertions.assertEquals("testcase", c.getTestcase());
}

}
