package com.project.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.domain.User;
import com.project.service.*;
import java.util.ArrayList;
import java.util.List;
import com.project.repository.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class ControllerTest {
@Mock
private  IService service;
@Mock
private  UserRepository rep;

private UserResourceImpl cont;

@BeforeEach
void setup() {
    MockitoAnnotations.openMocks(this);
    cont = new UserResourceImpl(rep);
}
    @Test
    void saveFaculty() {
        // Create a donation
    	User user=new User();
    	user.setName("rithika");
    	user.setEmail("Rit@gmail.com");
    	user.setId(1L);
    	user.setMobile("1234567891");
    	user.setPassword("00000000");
    	user.setLastlogindate("12345");

        // Set up mock behavior
        when(service.saveOrUpdate(user)).thenReturn(user);

        // Perform the request
        ResponseEntity<User> response = cont.register(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    @Test
    void getFacultyById() throws ResourceNotFoundException {
        // Create a donation
        User user = new User();
        user.setName("rithika");
    	user.setEmail("Rit@gmail.com");
    	user.setId(1L);
    	user.setMobile("1234567891");
    	user.setPassword("00000000");
    	user.setLastlogindate("12345");

        // Set up mock behavior
        when(service.findById(1L)).thenReturn(user);

        // Perform the request
        ResponseEntity<User> response =cont.getFacById(1L);
        // Check the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
       // assertEquals(donation, response.getBody());
    }

}



