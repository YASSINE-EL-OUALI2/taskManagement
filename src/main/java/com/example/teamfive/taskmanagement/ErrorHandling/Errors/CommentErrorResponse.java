package com.example.teamfive.taskmanagement.ErrorHandling.Errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.example.teamfive.taskmanagement.ErrorHandling.GlobalNotFoundException;

public class CommentErrorResponse extends GlobalNotFoundException {
    
    public CommentErrorResponse(){

    }

    public CommentErrorResponse(HttpStatus status, String msg, LocalDateTime timestamp){
        super(status, msg, timestamp);
    }
}
