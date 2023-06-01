package com.project;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.project.domain.User;
import com.project.repository.UserRepository;

@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void main() {
	Application.main(new String[] {});
	}
	
}
