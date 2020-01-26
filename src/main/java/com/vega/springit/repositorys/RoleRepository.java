package com.vega.springit.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domains.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);

}
