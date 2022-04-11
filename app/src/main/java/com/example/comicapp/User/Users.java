package com.example.comicapp.User;

public class Users {
//    private String _id;
    private String username;
    private String password;
    private String birth;
    private String gender;
    private String email;
    private String phone;

    public Users() {
    }


    public Users( String username, String password, String birth, String gender, String email, String phone) {
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }


    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
