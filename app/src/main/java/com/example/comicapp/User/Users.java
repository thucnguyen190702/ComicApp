package com.example.comicapp.User;

public class Users {
//    private String _id;
    private String username;
    private String email;
    private String password;

    private String token;


    public Users() {
    }

    public Users(String email,String password ) {
        this.password = password;
        this.email = email;
    }

    public Users(String username,String email, String password ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.token = token;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
