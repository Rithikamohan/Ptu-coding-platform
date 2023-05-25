package com.project;
import static org.mockito.BDDMockito.willDoNothing;
import org.springframework.test.annotation.Rollback;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.project.domain.User;
import com.project.repository.UserRepository;

import com.project.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.DisplayName;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ApplicationTests {
		
	  @Mock
	    private UserRepository employeeRepository;

	    @InjectMocks
	    private UserServiceImpl employeeService;

	    private User employee;

	    @BeforeEach
	    public void setup(){
	        //employeeRepository = Mockito.mock(EmployeeRepository.class);
	       //employeeService = new EmployeeServiceImpl(employeeRepository);
	        employee = User.builder()
	                
	                .name("rithika")
					.email("Rit@gmail.com")			
					.mobile("1234567891")
					.password("00000000")
	                .build();
	    }
	   
	    // JUnit test for saveEmployee method
	    @DisplayName("JUnit test for saveEmployee method")
	    @Test
	    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject(){


	        // when -  action or the behaviour that we are going test
	        User savedEmployee = employeeService.saveOrUpdate(employee);

	        System.out.println(savedEmployee);
	        // then - verify the output
	        assertThat(savedEmployee).isNull();
	    }
	    // JUnit test for getAllEmployees method
	    @DisplayName("JUnit test for getAllEmployees method")
	    @Test
	    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList(){
	        // given - precondition or setup

	        User employee1 = User.builder()
	               
	        		.name("rithika")
					.email("Rit@gmail.com")		
					.mobile("1234567891")
					.password("00000000")
	                .build();

	        given(employeeRepository.findAll()).willReturn(List.of(employee,employee1));

	        // when -  action or the behaviour that we are going test
	        List<User> employeeList = (List<User>) employeeService.getAllEmp();
	        // then - verify the output
	        assertThat(employeeList).isNotNull();
	        assertThat(employeeList.size()).isEqualTo(2);
	    }
	    
	    // JUnit test for deleteEmployee method
	    @DisplayName("JUnit test for deleteEmployee method")
	    @Test
	    public void givenEmployeeId_whenDeleteEmployee_thenNothing(){
	        // given - precondition or setup
	        long employeeId = 1L;

	        willDoNothing().given(employeeRepository).deleteById(employeeId);

	        // when -  action or the behaviour that we are going test
	        employeeService.deleteById(employeeId);

	        // then - verify the output
	        verify(employeeRepository, times(1)).deleteById(employeeId);
	    }
	    
	    
	    
    @Test
    public void contextLoads() {
    }

	  @Autowired
	    private UserRepository studentRepository;
	  Long id;


	    // JUnit test for saveEmployee
	    @Test
	    @Order(1)
	    @Rollback(value = false)
	    public Long saveStudentTest(){

	     User employee = User.builder()
	        		.name("rithika")
					.email("Rit@gmail.com")
					.mobile("1234567891")
					.password("00000000")
	                .build();
	                 
	        studentRepository.saveAndFlush(employee);
	        System.out.println( "Id in save employee"+id);
	        Assertions.assertThat(employee.getId()).isGreaterThan(0);
	        Long id=employee.getId();
	        return id;
	    
	    }
	

	    @Test
	    @Order(2)
	    public void getEmployeeTest(){
	    	Long id=saveStudentTest();
	    	System.out.println( "Id in get employee"+id);
	        User employee =  studentRepository.findById(id).get();

	        Assertions.assertThat(employee.getId()).isEqualTo(id);

	    }
	
	    @Test
	    @Order(3)
	    public void getListOfStudentTest(){

	        List<User> employees =  studentRepository.findAll();

	        Assertions.assertThat(employees.size()).isGreaterThan(0);

	    }
	
	    @Test
	    @Order(4)
	    @Rollback(value = false)
	    public void updateUpdateTest(){
	    	Long id=saveStudentTest();
	        User employee =  studentRepository.findById(id).get();

	        employee.setEmail("ram@gmail.com");

	        User employeeUpdated =   studentRepository.save(employee);

	        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("ram@gmail.com");

	    }
	    @Test
	    @Order(5)
	    @Rollback(value = false)
	    public void deleteStudentTest(){
	    	Long id=saveStudentTest();
	        User employee =  studentRepository.findById(id).get();

	        studentRepository.delete(employee);

	        //employeeRepository.deleteById(1L);

	        User employee1 = null;

	        Optional<User> optionalEmployee =  studentRepository.findById(id);

	        if(optionalEmployee.isPresent()){
	            employee1 = optionalEmployee.get();
	        }
	        Assertions.assertThat(employee1).isNull();
	    }

}
	
