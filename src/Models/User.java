package src.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import src.Interfaces.UserInterface;
import src.Services.DateService;
import src.Services.QueryBuilderService;
import src.Services.DateService.DateFormat;

public class User implements UserInterface {
    private int id;
    private String fullName;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private Date createdAt;
    private Date updatedAt;

    // Constructor
    public User(int id, String fullName, String username, String email, String phoneNumber,
            String address, Date dateOfBirth, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters (you can generate these using your IDE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public HashMap<String, String> saveUser() {
        HashMap<String, String> result = new HashMap<>();
        QueryBuilderService qbs = new QueryBuilderService();
        qbs
                .insert()
                .table("USERS")
                .columns("full_name, username, email, phone_number, address, date_of_birth, created_at, updated_at")
                .values(
                        "'" + this.getFullName() + "'",
                        "'" + this.getUsername() + "'",
                        "'" + this.getEmail() + "'",
                        "'" + this.getPhoneNumber() + "'",
                        "'" + this.getAddress() + "'",
                        "'" + DateService.formatDate(createdAt, DateFormat.DATE_TIME) + "'",
                        "NOW()",
                        "NOW()")
                .runExecuteUpdate();

        result.put("status", "success");
        result.put("message", "User successfully saved");
        return result;

    }

    @Override
    public void getUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public void editUserr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editUserr'");
    }

    @Override
    public void deleteUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public ArrayList<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

}
