package com.kashigin.stanislav.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_auth_data")
public class UserAuthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "hash")
    private String hash;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public UserAuthData() {
    }

    public UserAuthData(String login, String hash) {
        this.login = login;
        this.hash = hash;
    }

    public UserAuthData(long id, String login, String hash, User user) {
        this.id = id;
        this.login = login;
        this.hash = hash;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
