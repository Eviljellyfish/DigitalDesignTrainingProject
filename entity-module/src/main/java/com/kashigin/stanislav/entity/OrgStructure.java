package com.kashigin.stanislav.entity;

import java.util.List;

public class OrgStructure {
    private int id;
    private String name;
    private User head;
    private List<User> staff;
    private OrgStructure parent;
    private List<OrgStructure> subOrgs;

    public OrgStructure(int id, String name, User head, List<User> staff, OrgStructure parent, List<OrgStructure> subOrgs) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.staff = staff;
        this.parent = parent;
        this.subOrgs = subOrgs;
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

    public List<User> getStaff() {
        return staff;
    }

    public void setStaff(List<User> staff) {
        this.staff = staff;
    }

    public OrgStructure getParent() {
        return parent;
    }

    public void setParent(OrgStructure parent) {
        this.parent = parent;
    }

    public List<OrgStructure> getSubOrgs() {
        return subOrgs;
    }

    public void setSubOrgs(List<OrgStructure> subOrgs) {
        this.subOrgs = subOrgs;
    }
}
