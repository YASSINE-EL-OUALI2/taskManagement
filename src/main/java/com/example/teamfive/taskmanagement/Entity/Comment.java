package com.example.teamfive.taskmanagement.Entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @NonNull
    @Column(name = "created_date")
    @CreatedDate
    private Date createdAt = new Date();

    public Comment() {
    }

    public Comment(Task task, Users user, String comment) {
        this.task = task;
        this.user = user;
        this.comment = comment;
    }

    public Long getCommentId() {
        return commentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment [commentId=" + commentId + ", task=" + task + ", user=" + user + ", comment=" + comment
                + ", createdAt=" + createdAt + "]";
    }

    
}
