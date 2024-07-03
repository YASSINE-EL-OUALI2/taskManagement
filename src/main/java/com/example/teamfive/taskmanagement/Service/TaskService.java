package com.example.teamfive.taskmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamfive.taskmanagement.Entity.Task;
import com.example.teamfive.taskmanagement.Entity.Authentication.Users;
import com.example.teamfive.taskmanagement.Repository.TaskRepository;
import com.example.teamfive.taskmanagement.Service.Authentication.UsersService;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UsersService usersService;

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Task task) {
        Task existingTask = getTaskById(task.getTaskId());
        if (existingTask != null) {
            existingTask.setAssignee(task.getAssignee());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setStatus(task.getStatus());
            existingTask.setPriority(task.getPriority());
            Users existingCreator = usersService.getUserById(task.getCreator().getUserId());
            if (existingCreator != null) {
                existingTask.setCreator(existingCreator);
            }
            Users existingAssignee = usersService.getUserById(task.getAssignee().getUserId());
            if (existingAssignee != null) {
                existingTask.setAssignee(existingAssignee);
            }

            return taskRepository.save(existingTask);
        }
        return null;
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
