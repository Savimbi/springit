package com.vega.springit.service;

import org.springframework.stereotype.Service;

import com.vega.springit.domains.Vote;
import com.vega.springit.repositorys.VoteRepository;

@Service
public class VoteService {

	private final VoteRepository voteRepository;

	public VoteService(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}
	
	public Vote save(Vote vote) {
		return voteRepository.save(vote);
	}
}
