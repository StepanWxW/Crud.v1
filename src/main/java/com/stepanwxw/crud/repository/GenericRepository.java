package main.java.com.stepanwxw.crud.repository;

import java.util.List;

interface GenericRepository<T, L> {
    T create(T t);
    List<T> getAll();
    T getByID(L id);
    T update(T t);
    void remove (L id);
}