package com.vega.springit.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domains.Link;

public interface LinkRepository extends JpaRepository<Link, Long >{

}
