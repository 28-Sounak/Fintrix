package com.fintrix;

import com.fintrix.UserManagement.PasswordHasher;

public class TestPasswordHasher
{
    public static void main(String args[])
    {
        String password = "Fintrix@123";

        //Generate pasword hash

        String hashedPassword = PasswordHasher.hashPassword(password);

        System.out.println("Original password is: " + password);
        
        System.out.println("Hashed password is: " + hashedPassword);

        //Verify password

        boolean correct = PasswordHasher.verifyPassword("Fintrix@123", hashedPassword);

        System.out.println("Correct password: " + correct);

        //Verify incorrect password 
        
        boolean incorrect = PasswordHasher.verifyPassword("WrongPassword", hashedPassword);

        System.out.println("Incorrect password: " + incorrect);

    }
}