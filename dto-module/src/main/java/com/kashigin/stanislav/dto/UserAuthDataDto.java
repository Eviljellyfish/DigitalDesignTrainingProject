package com.kashigin.stanislav.dto;


public class UserAuthDataDto {

    private long id;

    private String login;

    private String hash;

    private long role;

    private long user;

    public UserAuthDataDto() {
    }

    public UserAuthDataDto(long id, String login, String hash, long role, long user) {
        this.id = id;
        this.login = login;
        this.hash = hash;
        this.role = role;
        this.user = user;
    }

    public UserAuthDataDto(String login, String hash) {
        this.login = login;
        this.hash = hash;
    }

    public UserAuthDataDto(long id, String login, String hash) {
        this.id = id;
        this.login = login;
        this.hash = hash;
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

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }
}
