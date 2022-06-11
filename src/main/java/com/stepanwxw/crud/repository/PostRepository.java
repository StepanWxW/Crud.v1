package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Post;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PostRepository extends GenericRepository<Post,Long>{
    @Override
    Post create(Post post) throws IOException;

    @Override
    List<Post> getAll() throws FileNotFoundException;

    @Override
    Post getByID(Long id) throws IOException;

    @Override
    Post update(Post post) throws FileNotFoundException;

    @Override
    void remove(Long id) throws FileNotFoundException;
}
