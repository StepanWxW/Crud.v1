package main.java.com.stepanwxw.crud.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

interface GenericRepository<T, L> {
    T create(T t) throws IOException;
    List<T> getAll() throws FileNotFoundException;
    T getByID(L id) throws IOException, ClassNotFoundException;
    T update(T t) throws FileNotFoundException;
    void remove (L id) throws FileNotFoundException;
}