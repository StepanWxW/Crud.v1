package main.java.com.stepanwxw.crud.view;

import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.RegionRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.UserRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegionMenu {
    RegionRepositoryImpl regionRepository = new RegionRepositoryImpl();
    private String lineCM() {
        System.out.println("Choose: 1)Create 2)ReadAll 3)ReadId 4)DeleteId 5)Update");
        return new Scanner(System.in).nextLine();
    }
    private String lineInput() {
        return new Scanner(System.in).nextLine();
    }

    public void regionMenu() {
        boolean indicator = true;
        while (indicator) {
            switch (lineCM()) {
                case ("Create"):
                case ("1"):
                case ("1)Create"):
                    System.out.println("Enter region: ");
                    regionRepository.create(new Region(lineInput()));
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
                        UserRepositoryImpl userRepository = new UserRepositoryImpl();
                        List<User> userList = new ArrayList<>(userRepository.getAll());
                        int ind = 0;
                        for (User u : userList) {
                            if (u.getRegion().getId() == id) {
                                System.out.println("Cannot be deleted, because region id = " + id + " use from User.");
                                ind = 1;
                            }
                        }
                            if (!(ind == 1)) {regionRepository.remove(id);
                                System.out.println("Congratulation. Id " + id + " is delete.");
                            }
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
            }
        }

    }
}
