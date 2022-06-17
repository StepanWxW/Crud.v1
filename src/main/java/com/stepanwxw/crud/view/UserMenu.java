package main.java.com.stepanwxw.crud.view;

import javafx.geometry.Pos;
import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.model.Role;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.PostRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.RegionRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.UserRepositoryImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    RegionRepositoryImpl regionRepository = new RegionRepositoryImpl();
    PostRepositoryImpl postRepository = new PostRepositoryImpl();
    private String lineCM() {
        System.out.println("Choose: 1)Create 2)ReadAll 3)ReadId 4)DeleteId 5)Update");
        return new Scanner(System.in).nextLine();
    }
    private String lineInput() {
        return new Scanner(System.in).nextLine();
    }

    public void userMenu() throws IOException {
        boolean indicator = true;
        while (indicator) {
            switch (lineCM()) {
                case ("Create"):
                case ("1"):
                case ("1)Create"):
                    System.out.println("Enter First name: ");
                    String firstname = lineInput();
                    System.out.println("Enter Last name: ");
                    String lastname = lineInput();
                    System.out.println("Choose post or posts: ");
                    System.out.println(postRepository.getAll());
                    System.out.println("Enter id post and press \"enter\" for next post. \n" +
                            "If you want to finish typing, then write \"exit\"" );
                    List<Post> postList = new ArrayList<>();
                    boolean flag = true;
                    String post;
                    long idPost = 0;
                    while (flag) {
                        post = lineInput();
                        if (post.equals("exit")) flag = false;
                        if (post.equals("exit") && postList.isEmpty()) {
                            System.out.println("Enter please at least one id");
                            flag = true;
                        } else {
                            try {
                                idPost = Long.parseLong(post);
                            } catch (NumberFormatException e) {
                                System.out.println("Input number please"  +
                                        "\n If you want to finish typing, then write \"exit\"");
                            }
                           postList.add(new Post(idPost));
                        }

                    }
                    System.out.println("Choose region: ");
                    System.out.println(regionRepository.getAll());
                    System.out.println("Enter id");
                    long idRegion = 0;
                    try {
                        idRegion = Long.parseLong(lineInput());
                    } catch (NumberFormatException e) {
                        System.out.println("Input number please");
                    }
                    System.out.println("Enter please Role (ADMIN, USER, MODERATOR):");
                    Role role = Role.valueOf(lineInput());
                   userRepository.create(new User(firstname,lastname,postList, new Region(idRegion), role));
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
                        postRepository.remove(id);
                        System.out.println("Congratulation. Id " + id + " is delete.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input number please");
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
