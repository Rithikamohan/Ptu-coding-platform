package com.project.resource.impl;
import com.project.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.config.JwtTokenProvider;
import com.project.repository.UserRepository;
import com.project.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import com.project.domain.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;
@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "https://ptu-coding-platform.onrender.com")


@CrossOrigin(origins = "http://localhost:3000")
public class UserResourceImpl  {

	private static Logger log = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	private IService empService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserRepository userRepository;

    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
	
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody User user) {
		log.info("UserResourceImpl : register");
		JSONObject jsonObject = new JSONObject();
		try {	
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			log.info("UserResourceImpl : after password encoded");
			User savedUser = userRepository.saveAndFlush(user);
			jsonObject.put("message", savedUser.getName() + " saved succesfully");
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
		} catch (JSONException e) {
			try {
				jsonObject.put("exception", e.getMessage());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
		}	
	}
    
	@PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticate(@RequestBody User user) {
		log.info("UserResourceImpl : authenticate");
		JSONObject jsonObject = new JSONObject();
		try {
			log.info("UserResourceImpl : inside try authenticate");
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			
			if (authentication.isAuthenticated()) {
				log.info("UserResourceImpl :  is authenticate");
				 String email=user.getEmail();
				 String name= user.getName();
				 String n= userRepository.findBysname(email);
				 log.info(n);
				 userRepository.logindate(formattedDate,email);
					jsonObject.put("name", n);
					jsonObject.put("token", tokenProvider.createToken(email));
					

				return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
			}
			
		}catch (JSONException e) {
			try 
			{
				jsonObject.put("exception", e.getMessage());
			} catch (JSONException e1) 
			{
				e1.printStackTrace();
			}
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
		}
		return null;
	}		
	@GetMapping("/students")
	public ResponseEntity<java.util.List<User>> getAllEmployees() 
	{	
		
		return new ResponseEntity<List<User>>(empService.getAllEmp(), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ArrayList[] getAllname() 
	{	
			ArrayList[] names= userRepository.findAllname();
				return names;
	}
	
	@GetMapping("/allpoints")
	public ArrayList[] getAllpoints() 
	{	
			ArrayList[] names= userRepository.findAllpoints();
				return names;
	}
	
	@GetMapping("/points")
	public int setPoints(@RequestParam(value="mark") int mark, @RequestParam(value="name") String name)
	{	
		userRepository.setMark(mark,name);
		return mark;
	}

	@GetMapping("/mark")
	public int getPoints(@RequestParam(value="name") String name)
	{	
		 int m=userRepository.getMark(name);
		return m;
	}
	
	
	//c mark
	@GetMapping("/c")
	public int setc(@RequestParam(value="mark") int mark, @RequestParam(value="name") String name)
	{	
		userRepository.setC(mark,name);
		return mark;
	}
	
	@GetMapping("/cmark")
	public int getc(@RequestParam(value="name") String name)
	{	
		 int m=userRepository.getC(name);
		 return m;
	}
	
	
	  //cbasic 
	
		@GetMapping("/cbasic")
		public int setcbasic(@RequestParam(value="mark") int mark, @RequestParam(value="name") String name)
		{	
			userRepository.setCbasic(mark,name);
			return mark;
		}
		
		@GetMapping("/cmarkbasic")
		public int getcbasic(@RequestParam(value="name") String name)
		{	
			 int m=userRepository.getCbasic(name);
			 return m;
		}
		
		
		
		//cinter
		
			@GetMapping("/cinter")
			public int setcinter(@RequestParam(value="mark") int mark, @RequestParam(value="name") String name)
			{	
				userRepository.setCinter(mark,name);
				return mark;
			}
			
			@GetMapping("/cmarkinter")
			public int getcinter(@RequestParam(value="name") String name)
			{	
				 int m=userRepository.getCinter(name);
				 return m;
			}
		

		
	//cplus
	
	@GetMapping("/cplus")
	public int setcplus(@RequestParam(value="mark") int mark, @RequestParam(value="name") String name)
	{	
		userRepository.setCplus(mark,name);
		return mark;
	}
	
	@GetMapping("/cplusmark")
	public int getcplus(@RequestParam(value="name") String name)
	{	
		 int m=userRepository.getCplus(name);
		 return m;
	}
	
	
	@GetMapping("/update/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody User employeeDetails) throws ResourceNotFoundException 
	{
		log.info("UserResourceImpl : update student ");
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		user.setEmail(employeeDetails.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setName(employeeDetails.getName());
		user.setMobile(employeeDetails.getMobile());
		final User updatedEmployee = userRepository.save(user);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	
	@PostMapping("/stuupdate/{id}")
	public ResponseEntity<User> updateEmp(@PathVariable long id, @RequestBody User emp) 
	{
		return new ResponseEntity<User>(empService.updateEmp(id, emp), HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long StudentId)
		throws ResourceNotFoundException {
		log.info("UserResourceImpl : get user");
		User employee = userRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + StudentId));
		return ResponseEntity.ok().body(employee);
		}
	
	@GetMapping("/faculty/{faculty}")
	public ResponseEntity<java.util.List<User>> findByname(@PathVariable(value = "faculty") String faculty)throws ResourceNotFoundException 
	{
		List<User> users= userRepository.findByname(faculty);
						return ResponseEntity.ok().body(users);	
	}
	
	@GetMapping("/totalstu")
		public Long getcount()
	{
		 Long count = userRepository.count();
		 return count;
	}
	
    @GetMapping("/delete/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException 
    {
	log.info("UserResourceImpl : delete student ");
		userRepository.deleteById(studentId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}		
}
	
    
    
    
    
    

	
