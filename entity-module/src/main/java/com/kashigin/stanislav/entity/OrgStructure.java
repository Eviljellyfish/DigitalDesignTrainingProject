package com.kashigin.stanislav.entity;

public class OrgStructure {
    private int id;
    private String name;
    private User head;
    private OrgStructure parent;

    public OrgStructure(int id, String name, User head, OrgStructure parent) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.parent = parent;
    }

    public OrgStructure() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getHead() {
        return head;
    }

    public void setHead(User head) {
        this.head = head;
    }

    public OrgStructure getParent() {
        return parent;
    }

    public void setParent(OrgStructure parent) {
        this.parent = parent;
    }
}
