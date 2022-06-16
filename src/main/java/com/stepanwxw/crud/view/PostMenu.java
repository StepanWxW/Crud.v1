package main.java.com.stepanwxw.crud.view;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.repository.PostRepositoryImpl;


import java.io.FileNotFoundException;
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

    public void postMenu() throws FileNotFoundException {
        boolean indicator = true;
        while (indicator) {
            switch (lineCM()) {
                case ("Create"):
                case ("1"):
                case ("1)Create"):
                    System.out.println("Enter region: ");
                    postRepository.create(new Post(lineInput()));
                    System.out.println("Congratulation: create is complete.");
                    indicator = false;
                    break;
                case ("ReadALl"):
                case ("2"):
                case ("2)ReadAll"):
                    System.out.println(regionRepository.getAll());
                    indicator = false;
                    break;
                case ("ReadId"):
                case ("3"):
                case ("3)ReadId"):
                    System.out.println("Enter Id: ");
                    try {
                        long id = Long.parseLong(lineInput());
                        System.out.println(regionRepository.getByID(id));
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
                        regionRepository.remove(id);
                        System.out.println("Congratulation. Id " + id + " is delete.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input number please");
                    }
                    indicator = false;
                    break;
                case ("Update"):
                case ("5"):
                case ("5)DeleteId"):
                    System.out.println("Enter Id for update: ");
                    try {
                        long id = Long.parseLong(lineInput());
                        System.out.println("Input name region: ");
                        String name = lineInput();
                        Region r = new Region(id, name);
                        Region r0 = new Region(0L, "0");
                        if (regionRepository.update(r).getId().equals(r0.getId())){
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
