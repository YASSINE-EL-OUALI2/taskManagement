package com.example.teamfive.taskmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamfive.taskmanagement.Entity.Comment;
import com.example.teamfive.taskmanagement.Entity.Task;
import com.example.teamfive.taskmanagement.Entity.Users;
import com.example.teamfive.taskmanagement.Repository.CommentRepository;
import com.example.teamfive.taskmanagement.Repository.TaskRepository;
import com.example.teamfive.taskmanagement.Repository.UsersRepository;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TaskRepository taskRepository;

    public void addComment(Comment comment) throws Exception {
        testEntityRelations(comment);
        commentRepository.save(comment);
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment updateComment(Comment comment) throws Exception {
        Comment existingComment = commentRepository.findById(comment.getCommentId()).orElse(null);
        if (existingComment != null) {
            existingComment.setComment(comment.getComment());

            testEntityRelations(comment);
            existingComment.setTask(comment.getTask());
            existingComment.setUser(comment.getUser());
            return commentRepository.save(existingComment);
        }
        return null;
    }

    public void testEntityRelations(Comment comment) throws Exception{
        Long taskId = Optional.ofNullable(comment.getTask()).map(Task::getTaskId).orElse(null);
        if(taskId != null){
            Task existingTask = taskRepository.findById(taskId).orElseThrow(()-> new Exception("Task not present for this comment"));
            comment.setTask(existingTask);
        }

        Long userId = Optional.ofNullable(comment.getUser()).map(Users::getUserId).orElse(null);
        if(userId != null){
            Users existingUser = usersRepository.findById(userId).orElseThrow(()-> new Exception("User not present for this comment"));
            comment.setUser(existingUser);
        }


    }

    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }


}
