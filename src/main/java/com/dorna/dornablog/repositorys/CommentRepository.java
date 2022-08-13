package com.dorna.dornablog.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorna.dornablog.domains.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
