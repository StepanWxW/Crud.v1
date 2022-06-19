package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Role;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.implementation.UserRepository;

import java.io.*;
import java.util.*;

import static java.io.File.separator;

public class UserRepositoryImpl implements UserRepository {
    final String fileUsers = "src" + separator + "main" + separator + "resources" + separator + "users.txt";
    public Long generateId(){
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileUsers));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
            long id = Long.parseLong(w);
            try {
                posts.add(new PostRepositoryImpl().getByID(id));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return posts;
    }
    public User mapperUser(String line) {
        String[] word = line.split(" u ");
        return new User(Long.parseLong(word[0]), word[1], word[2],
                mapperListPost(word[4]),
                new RegionRepositoryImpl().getByID(Long.parseLong(word[3])), Role.valueOf(word[5]));
    }
    @Override
    public User create(User user){
        if (user.getId() == 0) user.setId(generateId());
        String u = user.toString();
        u = u.replaceAll(" r null", "");
        u = u.replaceAll(" p null", "");
        u = u.replaceAll("null", "");
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream(fileUsers, true));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.println(u);
        pw.close();
        return user;
    }

    @Override
    public List<User> getAll(){
        List<User> usersList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileUsers));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            usersList.add(mapperUser(scanner.nextLine()));
        }
        return usersList;
    }

    @Override
    public User getByID(Long id) {
        User user = null;
        try {
            Scanner scanner = new Scanner(new File(fileUsers));
            while (scanner.hasNextLine()) {
                User u = mapperUser(scanner.nextLine());
                if (Objects.equals(u.getId(), id)) {
                    user = new User(id, u.getFirstName(), u.getLastName(), u.getPosts(), u.getRegion(), u.getRole());
                }
            }
        } catch (IOException e)
        {
            System.out.println("Mistake in gitID");
        }
        return user;
    }

    @Override
    public User update(User user) {
        String u = user.toString();
        u = u.replaceAll(" r null", "");
        u = u.replaceAll(" p null", "");
        u = u.replaceAll("null", "");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileUsers));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String userListScan = scanner.nextLine();
            User userList = mapperUser(userListScan);
            if (Objects.equals(userList.getId(), user.getId())) {
                strings.add(u);
            } else strings.add(userListScan);
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(fileUsers, false));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (String s : strings) {
                pw.println(s);
            }
            pw.close();
        return user;
    }

    @Override
    public void remove(Long id) {
        List<User> usersList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileUsers));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            User u = mapperUser(scanner.nextLine());
            if (!Objects.equals(u.getId(), id))
                usersList.add(u);
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(fileUsers, false));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (User use : usersList) {
            pw.println(use.toString());
        }
        pw.close();
    }
}
