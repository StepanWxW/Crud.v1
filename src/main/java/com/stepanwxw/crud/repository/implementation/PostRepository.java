package main.java.com.stepanwxw.crud.repository.implementation;

import main.java.com.stepanwxw.crud.model.Post;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PostRepository extends GenericRepository<Post,Long> {
    @Override
    Post create(Post post);

    @Override
    List<Post> getAll();

    @Override
    Post getByID(Long id);

    @Override
    Post update(Post post);

    @Override
    void remove(Long id);
}
