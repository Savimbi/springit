package com.dorna.dornablog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorna.dornablog.domains.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);

}
