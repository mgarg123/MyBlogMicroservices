package com.myblog.microservices.userservices.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.microservices.userservices.model.Role;
import com.myblog.microservices.userservices.model.User;
import com.myblog.microservices.userservices.repo.RoleRepository;
import com.myblog.microservices.userservices.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User registerUser(User user) {
		boolean isUserExist = userRepository.existsById(user.getUsername());
		if(!isUserExist) {
			String pass = user.getPassword();
			String encPass = bCryptPasswordEncoder.encode(pass);
			user.setPassword(encPass);
			userRepository.save(user);
			return user;
		}
		return  null;
	}
	
	public User findUserByUserName(String userName) {
		User user = userRepository.findById(userName).get();
		
		return user;
	}

    public User createNewUser(User user) {
        Role role = roleRepository.findById("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


}
