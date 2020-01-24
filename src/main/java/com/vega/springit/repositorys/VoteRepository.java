package com.vega.springit.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domains.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long>{

}
