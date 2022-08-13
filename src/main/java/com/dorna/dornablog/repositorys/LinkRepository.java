package com.dorna.dornablog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorna.dornablog.domains.Link;

public interface LinkRepository extends JpaRepository<Link, Long >{

}
