package com.kashigin.stanislav.service;

import com.kashigin.stanislav.entity.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class UserService {

    public boolean addUser() {
        throw new NotImplementedException();
    }

    public boolean deleteUser(int id) {
        throw new NotImplementedException();
    }

    public User findUser(int id) {
        throw new NotImplementedException();
    }

    public List<User> findUsersByName(String name) {
        throw new NotImplementedException();
    }

    public List<User> findUsersByFirstNameAndSecondName(String firstName, String secondName) {
        throw new NotImplementedException();
    }

    public boolean moveUserToOrg(int id, OrgStructure org) {
        throw new NotImplementedException();
    }

    public boolean changeUserRole(int id, UserRoleEnum role) {
        throw new NotImplementedException();
    }

    public boolean changeUserPosition(int id, String pos) {
        throw new NotImplementedException();
    }

    public boolean changeUserFirstName(int id, String name) {
        throw new NotImplementedException();
    }

    public boolean changeUserSecondName(int id, String name) {
        throw new NotImplementedException();
    }

}
