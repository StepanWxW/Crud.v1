package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Role;
import main.java.com.stepanwxw.crud.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    String separator = File.separator;
    File fileUsers = new File("src" + separator + "main" + separator + "resources" + separator + "users.txt");
    List<Post> mapperListPost(String line) {
        List<Post> posts = new ArrayList<>();
        String[] word = line.split(" lp ");
        for (String w : word) {
            posts.add(new PostRepositoryImpl().mapperPost(w));
        }
        return posts;
    }
    User mapperUser(String line) {
        String[] word = line.split(" u ");
        return new User(Long.parseLong(word[0]), word[1], word[2],
                mapperListPost(word[3]),
                new RegionRepositoryImpl().mapperRegion(word[4]), Role.valueOf(word[5]));
    }
    @Override
    public User create(User user) throws IOException {
        return null;
    }

    @Override
    public List<User> getAll() throws FileNotFoundException {
        return null;
    }

    @Override
    public User getByID(Long id) throws IOException {
        return null;
    }

    @Override
    public User update(User user) throws FileNotFoundException {
        return null;
    }

    @Override
    public void remove(Long id) throws FileNotFoundException {

    }
}
