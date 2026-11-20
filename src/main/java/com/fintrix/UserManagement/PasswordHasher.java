package com.fintrix.UserManagement;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher
{
    //Generate a secure hash from a plain-text password

    public static String hashPassword(String password)
    {
        if(password == null || password.isEmpty())
        {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    //Verify a password against its stored hash

    public static boolean verifyPassword(String password, String hashedPassword)
    {
        if(password == null || password.isEmpty())
        {
            return false;   
        }

        return BCrypt.checkpw(password, hashedPassword);
    }
}