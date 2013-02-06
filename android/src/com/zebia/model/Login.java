package com.zebia.model;

import com.google.gson.Gson;

public class Login {

    private String mail;
    private String city;
    private String username;



    public Login(String city, String mail, String userName) {
        this.city = city;
        this.mail = mail;
        this.username = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
