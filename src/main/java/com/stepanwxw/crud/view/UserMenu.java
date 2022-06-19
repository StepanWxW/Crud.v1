package main.java.com.stepanwxw.crud.view;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.model.Role;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.PostRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.RegionRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.UserRepositoryImpl;

import java.io.IOException;
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
                    long idPost;
                    while (flag) {
                        post = lineInput();
                        if (post.equals("exit") && !postList.isEmpty()) {
                            flag = false;
                            break;
                        }
                        if (post.equals("exit") && postList.isEmpty()) {
                            System.out.println("Enter please at least one id");
                        } else {
                            boolean flagIdPost = true;
                            while (flagIdPost) {
                                try {
                                    idPost = Long.parseLong(post);
                                    if (postRepository.getByID(idPost) == null) {
                                        System.out.println("Post is not found. Please choose post.");
                                        flagIdPost = false;
                                    } else {
                                        postList.add(new Post(idPost));
                                        flagIdPost = false;
                                        System.out.println("Id is save. Enter another id or \"exit\".");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Input number please" +
                                            "\n If you want to finish typing, then write \"exit\"");
                                }
                            }
                        }
                        }
                    System.out.println("Choose region: ");
                    System.out.println(regionRepository.getAll());
                    System.out.println("Enter id");
                    long idRegion = 0;
                    boolean flagRegion = true;
                    while (flagRegion) {
                        try {
                            idRegion = Long.parseLong(lineInput());
                            if (regionRepository.getByID(idRegion) == null) {
                                System.out.println("Region is not found. Please choose region.");
                            } else flagRegion = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Input number please");
                        }
                    }
                    System.out.println("Enter please Role (ADMIN, USER, MODERATOR):");
                    boolean flagRole = true;
                    Role role = Role.USER;
                    while (flagRole) {
                        try {
                            role = Role.valueOf(lineInput());
                            flagRole = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Enter please: \"USER\", \"ADMIN\", \"MODERATOR\".");
                        }
                    }
                    userRepository.create(new User(firstname,lastname,postList, new Region(idRegion), role));
                    System.out.println("Congratulation: create is complete.");
                    indicator = false;
                    break;
                case ("ReadALl"):
                case ("2"):
                case ("2)ReadAll"):
                    System.out.println(userRepository.getAll());
                    indicator = false;
                    break;
                case ("ReadId"):
                case ("3"):
                case ("3)ReadId"):
                    boolean flagRead = true;
                    while (flagRead) {
                        System.out.println("Enter Id: ");
                        try {
                            long id = Long.parseLong(lineInput());
                            System.out.println(userRepository.getByID(id));
                            flagRead = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Input number please");
                        }
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
                    long id = 0;
                    boolean indicatorUserUp = true;
                    while (indicatorUserUp) {
                        System.out.println("Enter Id for update: ");
                            try {
                                id = Long.parseLong(lineInput());
                                List<User> userList = new ArrayList<>(userRepository.getAll());
                                int indicatorSearch = 0;
                                for (User u : userList) {
                                    if (u.getId() == id) {
                                        indicatorSearch = 1;
                                        indicatorUserUp = false;
                                    }
                                }
                                if (indicatorSearch == 0) {
                                    System.out.println("This id = " + id + " not found.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input number please");
                            }
                        }
                            System.out.println("Input first name: ");
                            String firstNameUp = lineInput();
                            System.out.println("Input last name: ");
                            String lastNameUp = lineInput();
                            System.out.println("Choose post or posts: ");
                            System.out.println(postRepository.getAll());
                            System.out.println("Enter id post and press \"enter\" for next post. \n" +
                            "If you want to finish typing, then write \"exit\"" );
                            List<Post> postListUp = new ArrayList<>();
                            boolean flagUserUP = true;
                            String postUp;
                            long idPostUp;
                            while (flagUserUP) {
                                postUp = lineInput();
                                if (postUp.equals("exit") && !postListUp.isEmpty()) {
                                    flagUserUP = false;
                                    break;
                                }
                                if (postUp.equals("exit") && postListUp.isEmpty()) {
                                    System.out.println("Enter please at least one id");
                                } else {
                                    boolean flagIdPost = true;
                                    while (flagIdPost) {
                                        try {
                                            idPostUp = Long.parseLong(postUp);
                                            if (postRepository.getByID(idPostUp) == null) {
                                                System.out.println("Post is not found. Please choose post.");
                                                flagIdPost = false;
                                            } else {
                                                flagIdPost = false;
                                                postListUp.add(new Post(idPostUp));
                                                System.out.println("Id is save. Enter another id or \"exit\".");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Input number please" +
                                                    "\n If you want to finish typing, then write \"exit\"");
                                        }
                                    }
                                }
                            }
                            System.out.println("Choose region: ");
                            System.out.println(regionRepository.getAll());
                            System.out.println("Enter id");
                            long idRegionUp = 0;
                            boolean flagRegionUp = true;
                            while (flagRegionUp) {
                                try {
                                    idRegionUp = Long.parseLong(lineInput());
                                    if (regionRepository.getByID(idRegionUp) == null) {
                                        System.out.println("Region is not found. Please choose region.");
                                    } else flagRegionUp = false;
                                } catch (NumberFormatException e) {
                                    System.out.println("Input number please");
                                }
                            }
                            System.out.println("Enter please Role (ADMIN, USER, MODERATOR):");
                            boolean flagRoleUp = true;
                            Role roleUp = Role.USER;
                            while (flagRoleUp) {
                                try {
                                    roleUp = Role.valueOf(lineInput());
                                    flagRoleUp = false;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Enter please: \"USER\", \"ADMIN\", \"MODERATOR\".");
                                }
                            }
                            userRepository.update(new User(id,firstNameUp,lastNameUp,postListUp, new Region(idRegionUp), roleUp));
                            System.out.println("Congratulation: update " + id + " is complete.");
                        }
                        indicator = false;
                    }

            }
        }

    

