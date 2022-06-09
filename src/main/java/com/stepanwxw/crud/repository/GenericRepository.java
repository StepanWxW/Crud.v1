package main.java.com.stepanwxw.crud.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

interface GenericRepository<T, L> {
    T create(T t) throws IOException;
    List<T> getAll();
    T getByID(L id) throws IOException, ClassNotFoundException;
    T update(T t);
    void remove (L id);
}