package com.example.teamfive.taskmanagement.Service.Authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamfive.taskmanagement.Entity.Authentication.Users;
import com.example.teamfive.taskmanagement.Repository.Authentication.UsersRepository;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public void addUser(Users user) {
        usersRepository.save(user);
    }

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users updateUser(Users user) {
        Users existingUser = getUserById(user.getUserId());
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRoles(user.getRoles());
            usersRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }
}
