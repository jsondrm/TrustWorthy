package com.example.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

//    @Id
//    private long _id;
    private String username;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +

                " username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    /*public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User( String username, String password, String role) {
//        this._id = _id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
