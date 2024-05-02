package com.example.teamfive.taskmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teamfive.taskmanagement.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
