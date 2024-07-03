package com.example.teamfive.taskmanagement.Entity.Authentication;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleid;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 20)
    private ERole rolename;

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public Role() {

    }

    public Long getRoleid() {
        return roleid;
    }

    public ERole getRolename() {
        return rolename;
    }

    public void setRolename(ERole rolename) {
        this.rolename = rolename;
    }
}
