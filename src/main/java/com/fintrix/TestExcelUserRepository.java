package com.fintrix;

import com.fintrix.UserManagement.*;

public class TestExcelUserRepository 
{

    public static void main(String[] args) 
    {

        ExcelUserRepository repository = new ExcelUserRepository();

        String password = "Fintrix@123";

        String passwordHash = PasswordHasher.hashPassword(password);

        User user = new User(
                101,
                "Rahul Sharma",
                "rahul@example.com",
                passwordHash,
                Role.EMPLOYEE
        );

        // Save user only if the email is not registered.

        if (!repository.emailExists(user.getEmail())) 
        {
            repository.saveUser(user);

            System.out.println("User saved successfully.");
        } 

        else 
        {
            System.out.println("User already exists.");
        }

        // Retrieve user.

        repository.findByEmail("rahul@example.com").ifPresent(foundUser -> {

                    System.out.println("Name: " + foundUser.getFullName());

                    System.out.println("Email: " + foundUser.getEmail());

                    System.out.println("Role: " + foundUser.getRole());

                    System.out.println(
                            "Password verified: " +
                            PasswordHasher.verifyPassword(
                                    password,
                                    foundUser.getPasswordHash()
                            )
                    );
                });
    }
}
