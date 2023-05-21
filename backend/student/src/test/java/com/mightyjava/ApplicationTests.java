//package com.mightyjava;
//import static org.mockito.BDDMockito.willDoNothing;
//import org.springframework.test.annotation.Rollback;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import java.util.Optional;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.junit.jupiter.api.BeforeEach;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.mightyjava.domain.User;
//import com.mightyjava.repository.UserRepository;
//
//import com.mightyjava.service.impl.UserServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.junit.jupiter.api.DisplayName;
//
//import static org.mockito.BDDMockito.given;
//import static org.assertj.core.api.Assertions.assertThat;
////@RunWith(SpringRunner.class)
//@SpringBootTest
////@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(MockitoExtension.class)
//public class ApplicationTests {
//		
//	  @Mock
//	    private UserRepository employeeRepository;
//
//	    @InjectMocks
//	    private UserServiceImpl employeeService;
//
//	    private User employee;
//
//	    @BeforeEach
//	    public void setup(){
//	        //employeeRepository = Mockito.mock(EmployeeRepository.class);
//	       //employeeService = new EmployeeServiceImpl(employeeRepository);
//	        employee = User.builder()
//	                
//	                .name("rithika")
//					.email("Rit@gmail.com")			
//					.mobile("1234567891")
//					.password("00000000")
//	                .build();
//	    }
//	   
//	    // JUnit test for saveEmployee method
//	    @DisplayName("JUnit test for saveEmployee method")
//	    @Test
//	    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject(){
//	        // given - precondition or setup
////	        given(employeeRepository.findByEmail(employee.getEmail()))
////	                .willReturn(employee);
//
////	        given(employeeRepository.save(employee)).willReturn(employee);
////
////	        System.out.println(employeeRepository);
////	        System.out.println(employeeService);
//
//	        // when -  action or the behaviour that we are going test
//	        User savedEmployee = employeeService.saveOrUpdate(employee);
//
//	        System.out.println(savedEmployee);
//	        // then - verify the output
//	        assertThat(savedEmployee).isNull();
//	    }
//	    // JUnit test for getAllEmployees method
//	    @DisplayName("JUnit test for getAllEmployees method")
//	    @Test
//	    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList(){
//	        // given - precondition or setup
//
//	        User employee1 = User.builder()
//	               
//	        		.name("rithika")
//					.email("Rit@gmail.com")		
//					.mobile("1234567891")
//					.password("00000000")
//	                .build();
//
//	        given(employeeRepository.findAll()).willReturn(List.of(employee,employee1));
//
//	        // when -  action or the behaviour that we are going test
//	        List<User> employeeList = (List<User>) employeeService.findAll();
//	        // then - verify the output
//	        assertThat(employeeList).isNotNull();
//	        assertThat(employeeList.size()).isEqualTo(2);
//	    }
//	    
//	    // JUnit test for deleteEmployee method
//	    @DisplayName("JUnit test for deleteEmployee method")
//	    @Test
//	    public void givenEmployeeId_whenDeleteEmployee_thenNothing(){
//	        // given - precondition or setup
//	        long employeeId = 1L;
//
//	        willDoNothing().given(employeeRepository).deleteById(employeeId);
//
//	        // when -  action or the behaviour that we are going test
//	        employeeService.deleteById(employeeId);
//
//	        // then - verify the output
//	        verify(employeeRepository, times(1)).deleteById(employeeId);
//	    }
//	    
//	    
//	    
//    @Test
//    public void contextLoads() {
//    }
//
//	  @Autowired
//	    private UserRepository studentRepository;
//	  Long id;
//
//
//	    // JUnit test for saveEmployee
//	    @Test
//	    @Order(1)
//	    @Rollback(value = false)
//	    public Long saveStudentTest(){
//
//	     User employee = User.builder()
//	        		.name("dannyboy")
//					.email("Rit@gmail.com")
//					.mobile("1234567891")
//					.password("00000000")
//	                .build();
//	                 
//	        studentRepository.saveAndFlush(employee);
//	        System.out.println( "Id in save employee"+id);
//	        Assertions.assertThat(employee.getId()).isGreaterThan(0);
//	        Long id=employee.getId();
//	        return id;
//	    
//	    }
//	
//
//	    @Test
//	    @Order(2)
//	    public void getEmployeeTest(){
//	    	Long id=saveStudentTest();
//	    	System.out.println( "Id in get employee"+id);
//	        User employee =  studentRepository.findById(id).get();
//
//	        Assertions.assertThat(employee.getId()).isEqualTo(id);
//
//	    }
//	
//	    @Test
//	    @Order(3)
//	    public void getListOfStudentTest(){
//
//	        List<User> employees =  studentRepository.findAll();
//
//	        Assertions.assertThat(employees.size()).isGreaterThan(0);
//
//	    }
//	
//	    @Test
//	    @Order(4)
//	    @Rollback(value = false)
//	    public void updateUpdateTest(){
//	    	Long id=saveStudentTest();
//	        User employee =  studentRepository.findById(id).get();
//
//	        employee.setEmail("ram@gmail.com");
//
//	        User employeeUpdated =   studentRepository.save(employee);
//
//	        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("ram@gmail.com");
//
//	    }
//	    @Test
//	    @Order(5)
//	    @Rollback(value = false)
//	    public void deleteStudentTest(){
//	    	Long id=saveStudentTest();
//	        User employee =  studentRepository.findById(id).get();
//
//	        studentRepository.delete(employee);
//
//	        //employeeRepository.deleteById(1L);
//
//	        User employee1 = null;
//
//	        Optional<User> optionalEmployee =  studentRepository.findById(id);
//
//	        if(optionalEmployee.isPresent()){
//	            employee1 = optionalEmployee.get();
//	        }
//	        Assertions.assertThat(employee1).isNull();
//	    }
//
//}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	    
//	    
//	
//	
//	
//	
//	
//	
////	@InjectMocks
////	private UserServiceImpl userService;
////	
////
////	@MockBean	
////	private UserRepository userRepository;
////	
////	@MockBean	
////	private IService<User> IService;
////	
////	private User user;
////	//setup
////	@BeforeEach
////	public void setUp() {
////		System.out.println("Setup");
////	    user = new User();
////		user.setName("dannyboy");
////		user.setEmail("Rit@gmail.com");
////		user.setId(1L);
////		user.setMobile("1234567891");
////		user.setPassword("00000000");
////		userRepository.save(user);
////	}
////	
//////	@Autowired
//////	private AuthenticationManager authenticationManager;
////	//private User user;
////	
////	//Save user
//////	@Test
//////	public void updateuser() throws ResourceNotFoundException{
//////		User user1=new User(1L,"Rithika","rit@g.co","12345","asdf");
//////		//Long id = 10L;
////////		user.setName("rithika");
////////		user.setId(1L);
////////		user.setEmail("Rit@gmail.com");
////////		user.setMobile("1234567891");
////////		user.setPassword("00000000");
//////		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));	
//////		User savedUser = userRepository.save(user1);
//////	//final User updatedEmployee = userRepository.save(user);
//////		System.out.println("Savedd User");
//////	//assertEquals("Hello Junit", result);
//////	  assertEquals("rithika",savedUser.getName());
//////		
//////	}
////	@Test
////	public void saveUser() {
////
////		user = new User();
////		user.setName("rithika");
////		user.setId(10L);
////		user.setEmail("Rit@gmail.com");
////		user.setMobile("1234567891");
////		user.setPassword("00000000");
////		IService.saveOrUpdate(user);
////		verify(IService, times(1)).saveOrUpdate(user);
////		System.out.println("Save User");
////	}
////	
////	@Test
////	public void testGetAllEmployees() {
////		HttpHeaders headers = new HttpHeaders();
////		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
////				assertNotNull(entity.getBody());
////	}
////	
////	
////	@Test
////	public void getById() throws ResourceNotFoundException {
////		 
////		Long id = 10L;
////		User users = userRepository.findById(id)
////				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
////		assertNotNull(users);
////		//assertEquals("Hello Junit", result);
////		assertEquals(users.getId(),id);
////	}
////	
////	//get all users
////	@Test
////	public void getAllUsers() {
////
////		Collection<User> users = userRepository.findAll();
////		Assert.assertEquals(users.size(),0);
////		System.out.println("get User");
////	}
////	//Load user by username
//////	@Test
//////	public void loadByUsername()
//////	{
//////		user.setEmail("Rit@gmail.com");
//////		String email="Rit@gmail.com";
//////		User user = userRepository.findByEmail(email);
//////		//user.setEmail("Rit@gmail.com");
//////		if (user == null) {
//////			System.out.println("Email  not found");
//////		}
//////		else {
//////			System.out.println("Load by username");
//////		}
//////	}
////	
////	
//////	@Test
//////	public void authenticate()
//////	{
//////		user = new User();	
//////		System.out.println("NOt Authenticated");
//////		user.setEmail("Rit@gmail.com");
//////		user.setPassword("00000000");
//////		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//////		assertNotNull(authentication);
//////		assertEquals(authentication.isAuthenticated(), authentication);
//////		System.out.println("Authenticated");
//////		if (authentication.isAuthenticated()) {
//////			System.out.println("Authenticated");
//////		}
//////	}
////	
////	//delete by id
////	@Test
////	public void deleteall() {
////		User user = new User();	
////		user.setId(2L);
////		IService.deleteById(user.getId());
////		System.out.println("User deleted successfully");
////		}
////	
////	//delete all
////	@Test
////    public void testDeleteAllUsers() {
////       userRepository.deleteAll();
////       System.out.println(" all users deleted successfully");
////	}
////
//
//	
//	
//	
//	
//
//
