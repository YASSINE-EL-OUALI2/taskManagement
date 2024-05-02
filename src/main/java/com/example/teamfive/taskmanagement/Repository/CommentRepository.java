package com.example.teamfive.taskmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teamfive.taskmanagement.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
