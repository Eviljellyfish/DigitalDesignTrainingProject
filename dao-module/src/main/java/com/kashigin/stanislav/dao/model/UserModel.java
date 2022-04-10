package com.kashigin.stanislav.dao.model;

public class UserModel {
    private int id;
    private String firstName;
    private String secondName;
    private int role;
    private int org;
    private String position;

    public UserModel(int id, String firstName, String secondName, int roleIid, int orgId, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.org = orgId;
        this.position = position;
    }

    public UserModel() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getOrg() {
        return org;
    }

    public void setOrg(int org) {
        this.org = org;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
