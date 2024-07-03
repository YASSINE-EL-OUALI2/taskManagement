package com.example.teamfive.taskmanagement.ErrorHandling;

public class CommentException extends RuntimeException {
    public CommentException(String msg) {
        super(msg);
    }

    public CommentException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CommentException(Throwable cause) {
        super(cause);
    }
}
