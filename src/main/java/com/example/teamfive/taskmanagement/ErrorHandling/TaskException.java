package com.example.teamfive.taskmanagement.ErrorHandling;

public class TaskException extends RuntimeException {
    
    public TaskException(String msg) {
        super(msg);
    }

    public TaskException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public TaskException(Throwable cause) {
        super(cause);
    }
}
