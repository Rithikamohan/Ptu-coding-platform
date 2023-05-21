package com.mightyjava;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mightyjava.domain.User;
import com.mightyjava.repository.UserRepository;

@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}
	 @Autowired
	    private UserRepository employeeRepository;
Long id;


	    @Test
	    @Order(1)
	    @Rollback(value = false)
	    public Long saveEmployeeTest(){

	        User employee = User.builder()
	        		.name("dannyboy")
					.email("Rit@gmail.com")
					
					.mobile("1234567891")
					.password("00000000")
	                .build();
	                 
	        employeeRepository.saveAndFlush(employee);
	        System.out.println( "Id in save employee"+id);
	        Assertions.assertThat(employee.getId()).isGreaterThan(0);
	        Long id=employee.getId();
	        return id;
	    
	    }
	
	
	    @Test
	    @Order(2)
	    public void getEmployeeTest(){
	    	Long id=saveEmployeeTest();
	    	System.out.println( "Id in get employee"+id);
	        User employee = employeeRepository.findById(id).get();

	        Assertions.assertThat(employee.getId()).isEqualTo(id);

	    }
	
	    @Test
	    @Order(3)
	    public void getListOfEmployeesTest(){

	        List<User> employees = employeeRepository.findAll();

	        Assertions.assertThat(employees.size()).isGreaterThan(0);

	    }
	
	    @Test
	    @Order(4)
	    @Rollback(value = false)
	    public void updateEmployeeTest(){
	    	Long id=saveEmployeeTest();
	        User employee = employeeRepository.findById(id).get();

	        employee.setEmail("ram@gmail.com");

	        User employeeUpdated =  employeeRepository.save(employee);

	        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("ram@gmail.com");

	    }
	    @Test
	    @Order(5)
	    @Rollback(value = false)
	    public void deleteEmployeeTest(){
	    	Long id=saveEmployeeTest();
	        User employee = employeeRepository.findById(id).get();

	        employeeRepository.delete(employee);

	        //employeeRepository.deleteById(1L);

	        User employee1 = null;

	        Optional<User> optionalEmployee = employeeRepository.findById(id);

	        if(optionalEmployee.isPresent()){
	            employee1 = optionalEmployee.get();
	        }

	        Assertions.assertThat(employee1).isNull();
	    }

}
