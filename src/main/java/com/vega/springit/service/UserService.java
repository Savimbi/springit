package com.vega.springit.service;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vega.springit.domains.User;
import com.vega.springit.repositorys.UserRepository;


@Service
public class UserService {
	
	private final Logger logger=LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder econder;
	private final RoleService roleService;
	private final MailService mailService;
	
	
	public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {
		this.userRepository = userRepository;
		this.roleService=roleService;
		this.mailService=mailService;
		econder=new BCryptPasswordEncoder();
	}
	
	

	public User register(User user) {
		String secret = "{bcrypt}" + econder.encode(user.getPassword());
		user.setPassword(secret);
		user.setConfirmPassword(secret);
		user.addRole(roleService.findRoleByName("ROLE_USER"));
		user.setActivationCode(UUID.randomUUID().toString());
		save(user);
		sendActivationEmail(user);
		return user;
	}
	
	public void sendActivationEmail(User user) {
		// TODO Auto-generated method stub
		
		mailService.sendActivationEmail(user);
		
	}



	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public void saveUsers(User...users ) {
		for(User user: users) {
			
			logger.info("Saving user: "+user.getEmail());
			userRepository.save(user);
		}
	}
	
	public void sendWelcomEmail(User user) {
		mailService.sendWelcomeEmail(user);
	}
	
	public Optional<User> findByEmailAndActicationCode(String email, String activationCode){
		return userRepository.findByEmailAndActivationCode(email, activationCode);
	}
}
