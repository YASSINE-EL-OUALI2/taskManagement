package com.example.teamfive.taskmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamfive.taskmanagement.Entity.Comment;
import com.example.teamfive.taskmanagement.Service.CommentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/comment")
@SecurityRequirement(name = "bearerAuth")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    public void addComment(@RequestBody Comment comment) throws Exception{
        commentService.addComment(comment);
    }

    @GetMapping("/getAll")
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/getCommentById")
    public Comment getCommentById(Long id){
        return commentService.getCommentById(id);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment comment) throws Exception{
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestBody Comment comment){
        commentService.deleteComment(comment);
    }



}
