package main.java.com.stepanwxw.crud.view;

import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.repository.RegionRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrudMenuImpl {
    RegionRepositoryImpl regionRepository = new RegionRepositoryImpl();
    View view = new View();
    private String lineCM() {
        System.out.println("Choose: 1)Create 2)ReadAll 3)ReadId 4)DeleteId 5)Update");
        return new Scanner(System.in).nextLine();
    }
    private String lineInput() {
        return new Scanner(System.in).nextLine();
    }

    public void crudMenu() throws FileNotFoundException {
        while (true) {
            switch (lineCM()) {
                case ("Create"):
                case ("1"):
                case ("1)Create"):
                    System.out.println("Enter region");
                    regionRepository.create(new Region(lineInput()));
                    System.out.println("Congratulation:");
                    view.startMenu();
                    break;
                case ("Post"):
                case ("2"):
                case ("2)Post"):

                    break;
                case ("User"):
                case ("3"):
                case ("3)User"):

                    break;
                default:

                    break;

            }
        }

    }
}

