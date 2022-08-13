package com.dorna.dornablog.service;

import com.dorna.dornablog.repositorys.RoleRepository;
import org.springframework.stereotype.Service;

import com.dorna.dornablog.domains.Role;

@Service
public class RoleService {

	
	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Role findRoleByName(String name) {
		return roleRepository.findByName(name);
	}
}
