package com.dorna.dornablog.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorna.dornablog.domains.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByEmailAndActivationCode(String email, String activationCode);

}
