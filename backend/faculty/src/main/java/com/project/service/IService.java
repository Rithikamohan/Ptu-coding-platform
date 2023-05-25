package com.project.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.project.domain.User;

public interface IService<T> {
	
	public List<User> getAllFac();
	
	
	Optional<T> findById(Long id);
	
	T saveOrUpdate(T t);
	
	public User updateFac(long id, User user);

	
	String deleteById(Long id);

	
}
