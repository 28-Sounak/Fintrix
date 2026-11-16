package com.fintrix;

import com.fintrix.UserManagement.User;

import com.fintrix.UserManagement.Role;

public class Test
{
    public static void main(String args[])
    {
        User user = new User(
        101,
        "Sounak Banerjee",
        "sounakbanerjee28@gmail.com",
        "samplePassword",
        Role.MANAGER
        );

        System.out.println("User ID: " + user.getUserId());
        System.out.println("Name: " + user.getFullName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Role: " + user.getRole());
        System.out.println("Active: " + user.isActive());
        System.out.println("Created: " + user.getCreatedAt());
    }
}