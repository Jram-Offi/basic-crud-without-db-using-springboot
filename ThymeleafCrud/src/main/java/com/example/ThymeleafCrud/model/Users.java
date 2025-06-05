package com.example.ThymeleafCrud.model;

public class Users {
    private String name;
    private int id;

    public Users() {
    }

    public Users(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
