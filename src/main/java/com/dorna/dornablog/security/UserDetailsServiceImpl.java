package com.dorna.dornablog.security;

import java.util.Optional;

import com.dorna.dornablog.repositorys.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dorna.dornablog.domains.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private UserRepository userRepository;
	
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user=userRepository.findByEmail(email);
		
		if(!user.isPresent()) {
			throw new UsernameNotFoundException(email);
		}
		return user.get();
	}

}
