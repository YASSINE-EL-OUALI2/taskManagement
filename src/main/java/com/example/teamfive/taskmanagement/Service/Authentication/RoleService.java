package com.example.teamfive.taskmanagement.Service.Authentication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamfive.taskmanagement.Entity.Authentication.Role;
import com.example.teamfive.taskmanagement.Repository.Authentication.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public List<Role> getRole() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role updateRole(Role role) {
        Role existingRole = roleRepository.findById(role.getRoleid()).orElse(null);
        if (existingRole != null) {
            return roleRepository.save(existingRole);

        }
        return null;
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

}
