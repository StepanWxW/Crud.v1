package main.java.com.stepanwxw.crud.repository.implementation;

import main.java.com.stepanwxw.crud.model.User;
import java.util.List;

public interface UserRepository extends GenericRepository<User,Long> {
    @Override
    User create(User user);
    @Override
    List<User> getAll();
    @Override
    User getByID(Long id);
    @Override
    User update(User user);
    @Override
    void remove(Long id);
}
