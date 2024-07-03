package com.example.teamfive.taskmanagement.Repository.Authentication;

import com.example.teamfive.taskmanagement.Entity.Authentication.ERole;
import com.example.teamfive.taskmanagement.Entity.Authentication.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long>  {
    
        Optional<Role> findByRolename(ERole name);

}
