package com.kashigin.stanislav.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role", nullable = false)
    private Role role;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    private OrgStructure org;

    @Column(name = "position")
    private String position;

    public User(long id, String firstName, String secondName, Role role, OrgStructure org, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.org = org;
        this.position = position;
    }

    public User(String firstName, String secondName, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public OrgStructure getOrg() {
        return org;
    }

    public void setOrg(OrgStructure org) {
        this.org = org;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
