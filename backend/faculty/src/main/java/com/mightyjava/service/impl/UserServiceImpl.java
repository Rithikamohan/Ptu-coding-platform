package com.mightyjava.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mightyjava.domain.User;

import com.mightyjava.repository.UserRepository;
import com.mightyjava.resource.impl.UserResourceImpl;
import com.mightyjava.service.IService;
import com.mightyjava.service.*;
@Service
public class UserServiceImpl implements IService<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User saveOrUpdate(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.deleteById(id);
			jsonObject.put("message", "Faculty deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public List<User> getAllFac() {
		return userRepository.findAll();
	}

	@Override
	public User updateFac(long id, User user) {
		User oldEmp = userRepository.findById(id).get();

		if (oldEmp != null) {
			user.setId(id);
			return userRepository.save(user);
		}		return null;
	}

	
	
	
}