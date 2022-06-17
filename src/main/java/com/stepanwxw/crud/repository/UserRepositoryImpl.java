package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Role;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.implementation.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import static java.io.File.separator;

public class UserRepositoryImpl implements UserRepository {
    final String fileUsers = "src" + separator + "main" + separator + "resources" + separator + "users.txt";
    public Long generateId() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileUsers));
        long id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) {
            id = mapperUser(line).getId();
        }
        }
        return ++id;
    }
    List<Post> mapperListPost(String line) {
        List<Post> posts = new ArrayList<>();
        line = line.replaceAll("[\\[\\]]", "");
        String[] word = line.split(", ");
        for (String w : word) {
            posts.add(new PostRepositoryImpl().mapperPost(w));
        }
        return posts;
    }
    User mapperUser(String line) {
        String[] word = line.split(" u ");
        return new User(Long.parseLong(word[0]), word[1], word[2],
                mapperListPost(word[4]),
                new RegionRepositoryImpl().mapperRegion(word[3]), Role.valueOf(word[5]));
    }
    @Override
    public User create(User user) throws IOException {
        if (user.getId() == 0) user.setId(generateId());
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileUsers, true));
        pw.println(user.toString());
        pw.close();
        return user;
    }

    @Override
    public List<User> getAll() throws FileNotFoundException {
        List<User> usersList = new ArrayList<>();
        Scanner scanner = new Scanner(fileUsers);
        while (scanner.hasNextLine()) {
            usersList.add(mapperUser(scanner.nextLine()));
        }
        return usersList;
    }

    @Override
    public User getByID(Long id) throws IOException {
        Scanner scanner = new Scanner(fileUsers);
        User user = null;
        while (scanner.hasNextLine()) {
            User u = mapperUser(scanner.nextLine());
            if (Objects.equals(u.getId(), id)) {
                user = new User(id, u.getFirstName(),u.getLastName(),u.getPosts(),u.getRegion(),u.getRole());
            }
        }
        return user;
    }

    @Override
    public User update(User user) throws FileNotFoundException {
        List<User> usersList = new ArrayList<>();
        Scanner scanner = new Scanner(fileUsers);
        while (scanner.hasNextLine()) {
            User u = mapperUser(scanner.nextLine());
            if (Objects.equals(u.getId(), user.getId())) {
                usersList.add(new User(user.getId(),user.getFirstName(),user.getLastName(),user.getPosts(),u.getRegion(),user.getRole()));
            } else usersList.add(u);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileUsers, false));
        for (User use : usersList) {
            pw.println(use.toString());
        }
        pw.close();
        return user;
    }

    @Override
    public void remove(Long id) throws FileNotFoundException {
        List<User> usersList = new ArrayList<>();
        Scanner scanner = new Scanner(fileUsers);
        while (scanner.hasNextLine()) {
            User u = mapperUser(scanner.nextLine());
            if (!Objects.equals(u.getId(), id))
                usersList.add(u);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileUsers, false));
        for (User use : usersList) {
            pw.println(use.toString());
        }
        pw.close();
    }
}
