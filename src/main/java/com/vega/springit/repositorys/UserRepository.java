package com.vega.springit.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domains.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);

}
