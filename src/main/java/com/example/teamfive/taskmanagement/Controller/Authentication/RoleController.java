package com.example.teamfive.taskmanagement.Controller.Authentication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamfive.taskmanagement.Entity.Authentication.Role;
import com.example.teamfive.taskmanagement.Service.Authentication.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/getAll")
    public List<Role> getRole() {
        return roleService.getRole();
    }

    // add Item
    @PostMapping("/addRole")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    // get Item by Id
    @GetMapping("/getRoleById")
    public Optional<Role> getItemById(@RequestParam(value = "id") Long id) {
        return roleService.getRoleById(id);
    }

    // update Role
    @PutMapping(value = "/updateRole", consumes = "application/json", produces = "application/json")
    public Role updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    // delete Role
    @DeleteMapping("/deleteRole")
    public void deleteRole(@RequestBody Role role) {
        roleService.deleteRole(role);
    }

}
