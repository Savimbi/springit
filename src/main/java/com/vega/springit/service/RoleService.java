package com.vega.springit.service;

import org.springframework.stereotype.Service;

import com.vega.springit.domains.Role;
import com.vega.springit.repositorys.RoleRepository;

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
