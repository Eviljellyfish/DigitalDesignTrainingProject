package com.kashigin.stanislav.dao;

import java.util.List;

public interface BaseDao<T> {

    T get(int id);

    List<T> getAll();

    boolean save(T t);

    boolean update(T t, String[] param);

    void delete(T t);
}
