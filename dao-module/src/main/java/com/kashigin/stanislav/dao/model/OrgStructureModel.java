package com.kashigin.stanislav.dao.model;


public class OrgStructureModel {
    private int id;
    private String name;
    private int head;
    private int parent;

    public OrgStructureModel(int id, String name, int headId, int parentId) {
        this.id = id;
        this.name = name;
        this.head = headId;
        this.parent = parentId;
    }

    public OrgStructureModel() {
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

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
