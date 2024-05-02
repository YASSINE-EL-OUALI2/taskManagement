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

import com.example.teamfive.taskmanagement.Entity.Task;
import com.example.teamfive.taskmanagement.Service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/add")
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }


    @GetMapping("/getAll")
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/getTaskById")
    public Task getTaskById(Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestBody Task task){
        taskService.deleteTask(task);
    }
}
