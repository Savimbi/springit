package com.vega.springit.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domains.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
