package com.example.teamfive.taskmanagement.PayLoad.Request;

import java.util.Set;

import jakarta.annotation.Nonnull;

public class SignupRequest {
        @Nonnull
    private String username;

    @Nonnull
    private String email;

    private Set<String> role;

    @Nonnull
    private String password;

    public SignupRequest(@Nonnull String username, @Nonnull String email, Set<String> role, @Nonnull String password) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nonnull String username) {
        this.username = username;
    }

    @Nonnull
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }

}
