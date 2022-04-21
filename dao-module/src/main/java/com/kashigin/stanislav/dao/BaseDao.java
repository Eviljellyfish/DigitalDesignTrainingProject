package com.kashigin.stanislav.dao;

import java.util.List;

public interface BaseDao<T, ID> {

    T get(ID id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(ID id);
}
