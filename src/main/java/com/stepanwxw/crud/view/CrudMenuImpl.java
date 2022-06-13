package main.java.com.stepanwxw.crud.view;

import java.util.Scanner;

public class CrudMenuImpl {
    private String lineCM() {
        System.out.println("Choose: 1)Create 2)ReadAll 3)ReadId 4)DeleteId 5)Update");
        return new Scanner(System.in).nextLine();
    }

    public void crudMenu() {
        while (true) {
            switch (lineCM()) {
                case ("Create"):
                case ("1"):
                case ("1)Create"):
                    System.out.println("");
                    region();
                    break;
                case ("Post"):
                case ("2"):
                case ("2)Post"):
                    post();
                    break;
                case ("User"):
                case ("3"):
                case ("3)User"):
                    user();
                    break;
                default:
                    line();
                    break;

            }
        }

    }
}

