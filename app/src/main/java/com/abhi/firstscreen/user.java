package com.abhi.firstscreen;

public class user {
    public String Username, Email;

    public user(){

    }

    public user(String username, String email) {
        Username = username;
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
