package com.project.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.project.domain.User;



public interface IService<T> {
	
	public List<User> getAllEmp();
	
	Optional<T> findById(Long id);
	
	T saveOrUpdate(T t);
	
	public User updateEmp(long id, User emp);

	String deleteById(Long id);

	

	
}
