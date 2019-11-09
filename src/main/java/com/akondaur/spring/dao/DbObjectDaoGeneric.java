package main.java.com.akondaur.spring.dao;

import java.util.List;

public interface DbObjectDaoGeneric<T> {
    T getById(Long id);

    List<T> getAll();

    boolean delete(T object);

    boolean update(T object);

    boolean create(T object);
}
