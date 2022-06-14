package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.repository.implementation.PostRepository;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.io.File.separator;

public class PostRepositoryImpl implements PostRepository {
    public Timestamp tm() {
        return new Timestamp(System.currentTimeMillis());
    }
    final String filePosts = "src" + separator + "main" + separator + "resources" + separator + "posts.txt";
    Post mapperPost(String line) {
        String[] word = line.split(" p ");
        return new Post(Long.parseLong(word[0]), word[1],Timestamp.valueOf(word[2]),Timestamp.valueOf(word[3]));
    }
    public Long generateId() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePosts));
        long id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")){
                id = mapperPost(line).getId();
            }
        }
        return ++id;
    }
    @Override
    public Post create(Post post) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(filePosts, true));
        pw.println(post.toString());
        pw.close();
        return post;
    }
    @Override
    public List<Post> getAll() throws FileNotFoundException {
        List<Post> postsList = new ArrayList<>();
        Scanner scanner = new Scanner(filePosts);
        while (scanner.hasNextLine()) {
            postsList.add(mapperPost(scanner.nextLine()));
        }
        return postsList;
    }

    @Override
    public Post getByID(Long id) throws IOException {
        Scanner scanner = new Scanner(filePosts);
        Post posts = null;
        while (scanner.hasNextLine()) {
            Post p = mapperPost(scanner.nextLine());
            if (Objects.equals(p.getId(), id)) {
                posts = new Post(id, p.getContent(), p.getCreate(), p.getUpdate());
            }
        }
        return posts;
    }

    @Override
    public Post update(Post post) throws FileNotFoundException {
        List<Post> postsList = new ArrayList<>();
        Scanner scanner = new Scanner(filePosts);
        while (scanner.hasNextLine()) {
            Post p = mapperPost(scanner.nextLine());
            if (Objects.equals(p.getId(), post.getId())) {
                postsList.add(new Post(post.getId(),post.getContent(),p.getCreate(),post.getUpdate()));
            } else postsList.add(p);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream(filePosts, false));
        for (Post pos : postsList) {
            pw.println(pos.toString());
        }
        pw.close();
        return post;
    }

    @Override
    public void remove(Long id) throws FileNotFoundException {
        List<Post> postsList = new ArrayList<>();
        Scanner scanner = new Scanner(filePosts);
        while (scanner.hasNextLine()) {
            Post p = mapperPost(scanner.nextLine());
            if (!Objects.equals(p.getId(), id))
                postsList.add(p);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream(filePosts, false));
        for (Post pos : postsList) {
            pw.println(pos.toString());
        }
        pw.close();
    }
}