package com.fintrix.UserManagement;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.List;

import java.util.Locale;

import java.util.Optional;

public class ExcelUserRepository
{
    private static final Path FILE_PATH = Paths.get("data", "fintrix_users.xlsx");

    private static final String[] HEADERS = {
        "user_id",
        "full_name",
        "email",
        "password",
        "role",
        "is_active",
        "created_at"
    };

    public ExcelUserRepository()
    {
        initializeWorkbook();
    }

    //Create the data directory and workbook if it doesn't exist

    public synchronized void initializeWorkbook()
    {
        try
        {
            Files.createDirectories(FILE_PATH.getParent());

            if(!Files.exists(FILE_PATH) || Files.size(FILE_PATH) == 0)
            {
                try (Workbook workbook = new XSSFWorkbook())
                {
                    Sheet sheet = workbook.createSheet("Users");

                    Row headerRow = sheet.createRow(0);

                    for(int i = 0; i < HEADERS.length; i++)
                    {
                        headerRow.createCell(i).setCellValue(HEADERS[i]);
                    }

                    saveWorkbook(workbook);
                }
            }

            else
            {
                //Validate that the existing workbook has the expected structure before using it

                try (Workbook workbook = loadWorkbook())
                { 
                    Sheet sheet = workbook.getSheet("Users");

                    if(sheet == null || sheet.getRow(0) == null)
                    {
                        throw new IllegalStateException("Invalid user workbok structure.");
                    }

                    Row header = sheet.getRow(0);

                    for(int i = 0; i < HEADERS.length; i++)
                    {
                        Cell cell = header.getCell(i);

                        if(cell == null || !HEADERS[i].equals(cell.getStringCellValue()))
                        {
                            throw new IllegalStateException("Unexpected Excel column at index " + i);
                        }
                    }
                }
            }
        }

        catch(IOException e)
        {
            throw new IllegalStateException("Could not initialize user workload.");
        }
    }

    public synchronized void saveUser(User user)
    {
        if(user == null)
        {
            throw new IllegalArgumentException("User cannot be null.");
        }

        if (emailExists(user.getEmail()))
        {
            throw new IllegalArgumentException("Email already exists.");
        }

        try(Workbook workbook = loadWorkbook())
        {
            Sheet sheet = workbook.getSheet("Users");

            int rowIndex = sheet.getLastRowNum() + 1;

            Row row = sheet.createRow(rowIndex);

            row.createCell(0).setCellValue(user.getUserId());

            row.createCell(1).setCellValue(user.getFullName());

            row.createCell(2).setCellValue(normalizeEmail(user.getEmail()));

            row.createCell(3).setCellValue(user.getPasswordHash());

            row.createCell(4).setCellValue(user.getRole().name());

            row.createCell(5).setCellValue(user.isActive());

            row.createCell(6).setCellValue(user.getCreatedAt().toString());

            saveWorkbook(workbook);
        }

        catch(IOException e)
        {
            throw new IllegalStateException("Could not get saved user.", e);
        }
    }

    //Find user by email

    public synchronized Optional<User> findByEmail(String email)
    {
        if(email == null || email.isBlank())
        {
            return Optional.empty();
        }

        try(Workbook workbook = loadWorkbook())
        {
            Sheet sheet = workbook.getSheet("Users");

            for(int i = 1; i < sheet.getLastRowNum(); i++)
            {
                Row row = sheet.getRow(i);

                if(row == null)
                {
                    continue;
                }

                String storedEmail = getString(row, 2);

                if(normalizeEmail(email).equals(storedEmail))
                {
                    return Optional.of(mapRowToUser(row));
                }
            }

            return Optional.empty();
        }

        catch(IOException e)
        {
            throw new IllegalStateException("Could not retrieve user.", e);
        }
    }

    //Check whether an email is already registered

    public synchronized boolean emailExists(String email)
    {
        return findByEmail(email).isPresent();
    }

    //Retieve all users

    public synchronized List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();

        try(Workbook workbook = loadWorkbook())
        {
            Sheet sheet = workbook.getSheet("Users");

            for(int i = 1; i < sheet.getLastRowNum(); i++)
            {
                Row row = sheet.getRow(i);

                if(row != null)
                {
                    users.add(mapRowToUser(row));
                }
            }
        }

        catch(IOException e)
        {
            throw new IllegalStateException("Could not retrieve users.", e);
        }

        return users;
    }

    //Convert an Excel row to User object

    private User mapRowToUser(Row row)
    {
        int userId = (int) row.getCell(0).getNumericCellValue();

        String fullName = getString(row, 1);

        String email = getString(row, 2);

        String passwordHash = getString(row, 3);

        Role role = Role.valueOf(getString(row, 4));

        boolean active = row.getCell(5).getBooleanCellValue();

        LocalDateTime createdAt = LocalDateTime.parse(getString(row, 6));

        User user = new User(userId, fullName, email, passwordHash, role);

        user.setActive(active);

        return user;
    }

    //Read a string cell safely

    private String getString(Row row, int columnIndex)
    {
        Cell cell = row.getCell(columnIndex);

        if(cell == null)
        {
            return "";
        }

        return cell.getStringCellValue();
    }

    //Normalize emails for case-insensitive comparison

    private String normalizeEmail(String email)
    {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    //Load an existing workbook

    private Workbook loadWorkbook() throws IOException
    {
        try(InputStream inputStream = Files.newInputStream(FILE_PATH))
        {
            return new XSSFWorkbook(inputStream);
        }
    }

    //Save workbook changes

    private void saveWorkbook(Workbook workbook) throws IOException
    {
        try(OutputStream outputStream = Files.newOutputStream(FILE_PATH))
        {
            workbook.write(outputStream);
        }
    }
}