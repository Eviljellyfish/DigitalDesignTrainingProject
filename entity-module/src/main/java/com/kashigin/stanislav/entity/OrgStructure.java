package com.kashigin.stanislav.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "org_structure")
public class OrgStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User head;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private OrgStructure parent;

    public OrgStructure(long id, String name, User head, OrgStructure parent) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.parent = parent;
    }

    public OrgStructure(String name) {
        this.name = name;
    }

    public OrgStructure() {
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
