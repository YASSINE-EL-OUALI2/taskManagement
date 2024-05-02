package com.example.teamfive.taskmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teamfive.taskmanagement.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
