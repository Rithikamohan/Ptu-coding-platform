//package com.project.service;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import com.project.repository.*;
//import com.project.service.impl.*;
//import com.project.domain.*;
//@SpringBootTest
//@Transactional
//public class ServiceLevelTest {
//
//@Mock
//private UserRepository rep;
//
//@InjectMocks
//private UserServiceImpl service;
//
//@BeforeEach
//public void setUp() {
//    MockitoAnnotations.initMocks(this);
//}
//public void saveDonation() {
//
//	   User user = new User();
//		user.setName("rithika");
//		user.setEmail("Rit@gmail.com");
//		user.setId(1L);
//		user.setMobile("1234567891");
//		user.setPassword("00000000");
//		user.setLastlogindate("12345");
//
//	service.saveOrUpdate(user);
//	verify(rep, times(1)).save(user);
//}
//
//
//
//}
