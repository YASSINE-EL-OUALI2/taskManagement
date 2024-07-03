package com.example.teamfive.taskmanagement.Controller.Authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamfive.taskmanagement.Entity.Authentication.Users;
import com.example.teamfive.taskmanagement.Service.Authentication.UsersService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "bearerAuth")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/add")
    public void addUser(@RequestBody Users user){
        usersService.addUser(user);
    }

    @GetMapping("/getAll")
    public List<Users> getAll(){
        return usersService.getAll();
    }

    @GetMapping("/getUserById")
    public Users getUserById(Long id){
        return usersService.getUserById(id);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user){
        return usersService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody Users user){
        usersService.deleteUser(user);
    }
}
