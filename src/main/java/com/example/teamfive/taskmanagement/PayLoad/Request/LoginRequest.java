package com.example.teamfive.taskmanagement.PayLoad.Request;

import jakarta.annotation.Nonnull;

public class LoginRequest {
        @Nonnull
    private String username;

    @Nonnull
    private String password;

    public LoginRequest(@Nonnull String username, @Nonnull String password) {
        this.username = username;
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
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }

}
