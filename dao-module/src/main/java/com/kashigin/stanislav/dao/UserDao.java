package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.entity.User;
import java.util.List;

public class UserDao implements BaseDao<User> {
    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User userDao) {
        return false;
    }

    @Override
    public boolean update(User userDao, String[] param) {
        return false;
    }

    @Override
    public void delete(User userDao) {

    }
}
