package com.project.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.User;
import com.project.repository.UserRepository;
import com.project.service.IService;

@Service
public class UserServiceImpl implements IService<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

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
			jsonObject.put("message", "Admin deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}