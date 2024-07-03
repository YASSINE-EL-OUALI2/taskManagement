package com.example.teamfive.taskmanagement.ErrorHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public abstract class GlobalNotFoundException {
    private HttpStatus status;
    private String msg;
    private LocalDateTime timestamp;

    public GlobalNotFoundException() {
    }

    public GlobalNotFoundException(HttpStatus status, String msg, LocalDateTime timestamp) {
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
