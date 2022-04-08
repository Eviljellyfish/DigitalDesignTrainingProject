package com.kashigin.stanislav.dao.model;


public class OrgStructureModel {
    private int id;
    private String name;
    private int headId;
    private int parentId;

    public OrgStructureModel(int id, String name, int headId, int parentId) {
        this.id = id;
        this.name = name;
        this.headId = headId;
        this.parentId = parentId;
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

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
