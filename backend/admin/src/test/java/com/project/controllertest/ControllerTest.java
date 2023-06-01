package com.project.controllertest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.project.controller.UserResourceImpl;
import com.project.domain.User;
import com.project.repository.UserRepository;
import com.project.service.IService;
import com.project.service.impl.UserServiceImpl;

public class ControllerTest {
	@Mock
	private  IService service;
	@Mock
	private  UserRepository rep;

	private UserResourceImpl cont;
	@InjectMocks
	private UserServiceImpl sservice;
	@BeforeEach
	void setup() {
	    MockitoAnnotations.openMocks(this);
	    cont = new UserResourceImpl(rep);
	}
//	    @Test
//	    void saveAdmin() {
//	        // Create a donation
//	    	User user=new User();
//	    	user.setName("Admin");
//	    	user.setEmail("Rit@gmail.com");
//	    	user.setId(1L);
//	    	user.setMobile("1234567891");
//	    	user.setPassword("00000000");
//	    	
//
//	        // Set up mock behavior
//	        when(service.saveOrUpdate(user)).thenReturn(user);
//
//	        // Perform the request
//	        ResponseEntity<User> response = cont.register(user);
//
//	        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//	    }
}
