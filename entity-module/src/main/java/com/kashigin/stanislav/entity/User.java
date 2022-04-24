package com.kashigin.stanislav.entity;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRoleEnum role;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    private OrgStructure org;

    @Column(name = "position")
    private String position;

    public User(long id, String firstName, String secondName, UserRoleEnum role, OrgStructure org, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.org = org;
        this.position = position;
    }

    public User(String firstName, String secondName, UserRoleEnum role) {
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

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
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
