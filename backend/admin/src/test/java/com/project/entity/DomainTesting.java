package com.project.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DomainTesting {
	@Test
	public void createAdmin() {
		User user=new User();
		user.setName("rithika");
		user.setEmail("Rit@gmail.com");
		user.setId(1L);
		user.setMobile("1234567891");
		user.setPassword("00000000");
		
		
		Assertions.assertEquals(1L, user.getId());
		Assertions.assertEquals("Rit@gmail.com",user.getEmail());
		Assertions.assertEquals("rithika",user.getName());
		Assertions.assertEquals("1234567891",user.getMobile());
		Assertions.assertEquals("00000000",user.getPassword());
		
	}
	@Test
	public void testConstructor() {
	    // Create a donation object using the constructor
	    User u = new User(1L, "rithika", "Rit@gmail.com","1234567895","12345");

	    // Assert the values using getters
	    Assertions.assertEquals(1L, u.getId());
	    Assertions.assertEquals("rithika", u.getName());
	    Assertions.assertEquals("Rit@gmail.com", u.getEmail());
	    Assertions.assertEquals("1234567895", u.getMobile());
	    Assertions.assertEquals("12345", u.getPassword());

	}


}
