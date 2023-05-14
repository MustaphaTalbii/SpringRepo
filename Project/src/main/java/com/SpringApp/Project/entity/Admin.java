package com.SpringApp.Project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Admin {
    
    @Id
    private String Mail;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="name",nullable = false)
    private String name;

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin(String mail, String password, String name) {
        Mail = mail;
        this.password = password;
        this.name = name;
    }

    public Admin() {
    }

    public Admin(String mail, String password) {
        Mail = mail;
        this.password = password;
    }
}
