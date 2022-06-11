package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserRepository extends GenericRepository<User,Long>{
    @Override
    User create(User user) throws IOException;
    @Override
    List<User> getAll() throws FileNotFoundException;
    @Override
    User getByID(Long id) throws IOException;
    @Override
    User update(User user) throws FileNotFoundException;
    @Override
    void remove(Long id) throws FileNotFoundException;
}
