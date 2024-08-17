package com.example.databaseconnectivity;

public class User {
    private String userName;
    private String password;

    // Constructor
    public User() {
    }

    // Parameterized constructor
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getter and setter for userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Override the toString method for easier debugging and logging
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

