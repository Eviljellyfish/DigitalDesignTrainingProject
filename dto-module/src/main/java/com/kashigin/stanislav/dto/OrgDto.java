package com.kashigin.stanislav.dto;

public class OrgDto {
    private long id;

    private String name;

    private long head;

    private long parent;

    public OrgDto() {
    }

    public OrgDto(long id, String name, long head, long parent) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.parent = parent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHead() {
        return head;
    }

    public void setHead(long head) {
        this.head = head;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }
}
