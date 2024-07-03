package com.example.teamfive.taskmanagement.Entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;

import com.example.teamfive.taskmanagement.Entity.Authentication.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @NonNull
    @Column(name = "created_date")
    @CreatedDate
    private Date createdAt = new Date();

    @Column(name = "priority", length = 20)
    private String priority;

    @Column(name = "status", length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Users assignee;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Users creator;

    public Task() {
    }

    public Task(String title, String description, Date dueDate, String priority, String status, Users assignee,
            Users creator) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.assignee = assignee;
        this.creator = creator;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getAssignee() {
        return assignee;
    }

    public void setAssignee(Users assignee) {
        this.assignee = assignee;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
                + ", createdAt=" + createdAt + ", priority=" + priority + ", status=" + status + ", assignee="
                + assignee + ", creator=" + creator + "]";
    }

    
}
