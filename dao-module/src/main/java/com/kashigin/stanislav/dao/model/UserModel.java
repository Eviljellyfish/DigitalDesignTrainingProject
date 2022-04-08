package com.kashigin.stanislav.dao.model;

public class UserModel {
    private int id;
    private String firstName;
    private String secondName;
    private int roleId;
    private int orgId;
    private String position;

    public UserModel(int id, String firstName, String secondName, int roleIid, int orgId, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.roleId = roleId;
        this.orgId = orgId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
