package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long >{

}
