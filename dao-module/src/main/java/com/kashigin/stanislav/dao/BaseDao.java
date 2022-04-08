package com.kashigin.stanislav.dao;

import java.util.List;

public interface BaseDao<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(int id, T t);

    void delete(int id);
}
