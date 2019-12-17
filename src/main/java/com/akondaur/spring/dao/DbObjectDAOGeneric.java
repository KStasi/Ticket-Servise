package com.akondaur.spring.dao;

import java.util.List;

public interface DbObjectDAOGeneric<T> {
    T getById(Long id);

    List<T> getAll();

    boolean deleteById(Long id);

    boolean update(T object);

    boolean create(T object);
}
