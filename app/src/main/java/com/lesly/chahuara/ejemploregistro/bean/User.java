package com.lesly.chahuara.ejemploregistro.bean;

/**
 * Created by Asus on 26/05/2017.
 */

public class User {
    private Long id;
    private String name;
    private String lastName;
    private String user;
    private String pass;

    public User() {
    }

    public User(Long id, String name, String lastName, String user, String pass) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override

    public String toString() {

        return name + " " + lastName + " - "+user;

    }


}
