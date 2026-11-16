package com.fintrix.UserManagement;

import java.time.LocalDateTime;

public class User
{
    private int userId;

    private String passwordHash;

    private String fullName;

    private String email;

    private String role;

    private boolean isActive;

    private LocalDateTime createdAt;

    public User(int userId, String fullName, String email, String passwordHash, String role)
    {
        this.userId = userId;

        this.fullName = fullName;

        this.email = email;

        this.passwordHash = passwordHash;

        this.role = role;

        this.isActive = true;

        this.createdAt = LocalDateTime.now();
    }

    //Getters

    public int getUserId()
    {
        return userId;
    }

    public int getFullName()
    {
        return fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public String getRole()
    {
        return role;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    //Setters

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public void setActive(boolean active)
    {
        this.isActive = active;
    }
}