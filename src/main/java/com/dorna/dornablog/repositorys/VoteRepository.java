package com.dorna.dornablog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorna.dornablog.domains.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long>{

}
