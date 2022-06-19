package main.java.com.stepanwxw.crud.view;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.PostRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.UserRepositoryImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostMenu {
    PostRepositoryImpl postRepository = new PostRepositoryImpl();
    private String lineCM() {
        System.out.println("Choose: 1)Create 2)ReadAll 3)ReadId 4)DeleteId 5)Update");
        return new Scanner(System.in).nextLine();
    }
    private String lineInput() {
        return new Scanner(System.in).nextLine();
    }

    public void postMenu() throws IOException {
        boolean indicator = true;
        while (indicator) {
            switch (lineCM()) {
                case ("Create"):
                case ("1"):
                case ("1)Create"):
                    System.out.println("Enter post: ");
                    postRepository.create(new Post(lineInput()));
                    System.out.println("Congratulation: create is complete.");
                    indicator = false;
                    break;
                case ("ReadALl"):
                case ("2"):
                case ("2)ReadAll"):
                    System.out.println(postRepository.getAll());
                    indicator = false;
                    break;
                case ("ReadId"):
                case ("3"):
                case ("3)ReadId"):
                    System.out.println("Enter Id: ");
                    try {
                        long id = Long.parseLong(lineInput());
                        System.out.println(postRepository.getByID(id));
                    } catch (NumberFormatException e) {
                        System.out.println("Input number please");
                    }
                    indicator = false;
                    break;
                case ("DeleteId"):
                case ("4"):
                case ("4)DeleteId"):
                    System.out.println("Enter Id for delete: ");
                    try {
                        long id = Long.parseLong(lineInput());
                        UserRepositoryImpl userRepository = new UserRepositoryImpl();
                        List<User> userList = new ArrayList<>(userRepository.getAll());
                        int ind = 0;
                        for (User u : userList) {
                            List<Post> posts = new ArrayList<>(u.getPosts());
                            for (Post p : posts){
                                if (p.getId() == id) {
                                    System.out.println("Cannot be deleted, because region id = " + id + " use from User.");
                                    ind = 1;
                                }
                            }
                        }
                        if (!(ind == 1)) {
                            postRepository.remove(id);
                            System.out.println("Congratulation. Id " + id + " is delete.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input number please");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    indicator = false;
                    break;
                case ("Update"):
                case ("5"):
                case ("5)UpdateId"):
                    System.out.println("Enter Id for update: ");
                    try {
                        long id = Long.parseLong(lineInput());
                        System.out.println("Input post: ");
                        String name = lineInput();
                        Post p = new Post(id, name, new Timestamp(System.currentTimeMillis()));
                        Post p0 = new Post(0L, "0");
                        if (postRepository.update(p).getId() == (p0.getId())){
                            System.out.println("This id = " +  id + " not found.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Input number please");
                    }
                    indicator = false;
                    break;
                default:

                    break;

            }
        }

    }
}
