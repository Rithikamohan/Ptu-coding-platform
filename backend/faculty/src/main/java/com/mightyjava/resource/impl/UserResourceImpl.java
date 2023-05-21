package com.mightyjava.resource.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mightyjava.config.JwtTokenProvider;
import com.mightyjava.domain.User;
//import com.mightyjava.repository.RoleRepository;
import com.mightyjava.repository.UserRepository;
import com.mightyjava.service.IService;


@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "http://localhost:3000")
public class UserResourceImpl {

	private static Logger log = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private IService empService;

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
//			user.setRole(roleRepository.findByName(ConstantUtils.USER.toString()));
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
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			if (authentication.isAuthenticated()) {
				String email = user.getEmail();
				String name= user.getName();
				 userRepository.logindate(formattedDate,email);
				String n= userRepository.findByname(email);
				 log.info(n);				 
				jsonObject.put("name", n);
				jsonObject.put("authorities", authentication.getAuthorities());
				jsonObject.put("token", tokenProvider.createToken(email));
				//jsonObject.put("token", tokenProvider.createToken(email, userRepository.findByEmail(email).getRole()));
				
				return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
			}
		} catch (JSONException e) {
			try {
				jsonObject.put("exception", e.getMessage());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
		}
		return null;
	}

	@GetMapping("/faculty")
	public ResponseEntity<java.util.List<User>> getAllEmployees() {
		
		return new ResponseEntity<List<User>>(empService.getAllFac(), HttpStatus.OK);
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody User employeeDetails) throws ResourceNotFoundException {
		log.info("UserResourceImpl : update student ");
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		user.setEmail(employeeDetails.getEmail());
		//user.setPassword(employeeDetails.getPassword());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setName(employeeDetails.getName());
		user.setMobile(employeeDetails.getMobile());
		final User updatedEmployee = userRepository.save(user);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@PostMapping("/facupdate/{id}")
	public ResponseEntity<User> updateEmp(@PathVariable long id, @RequestBody User emp) {
		return new ResponseEntity<User>(empService.updateFac(id, emp), HttpStatus.OK);
	}
	
	@GetMapping("/faculty/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long StudentId)
		throws ResourceNotFoundException {
		log.info("UserResourceImpl : get user");
		User employee = userRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("faculty not found for this id :: " + StudentId));
		return ResponseEntity.ok().body(employee);
	}
	@GetMapping("/totalfac")
		public Long getcount(){
		 Long count = userRepository.count();
		 return count;
	}
	
    @GetMapping("/delete/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException {
	log.info("UserResourceImpl : delete student ");
	
		userRepository.deleteById(studentId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
   
	
}