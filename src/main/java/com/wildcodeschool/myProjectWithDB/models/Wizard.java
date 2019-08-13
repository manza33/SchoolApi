package com.wildcodeschool.myProjectWithDB.models;

public class Wizard {

    private int id;
    private String firstname;

    public Wizard(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }
}