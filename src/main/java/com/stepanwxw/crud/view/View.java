package main.java.com.stepanwxw.crud.view;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class View {
    public void startMenu() throws IOException {
        while (true) {
            switch (line()) {
                case ("Region"):
                case ("1"):
                case ("1)Region"):
                    new RegionMenu().regionMenu();
                    break;
                case ("Post"):
                case ("2"):
                case ("2)Post"):
                    new PostMenu().postMenu();
                    break;
                case ("User"):
                case ("3"):
                case ("3)User"):
                    new UserMenu().userMenu();
                    break;
                default:
                    line();
                    break;
            }
        }
    }
    private String line() {
        System.out.println("Select action: \n work with 1)Region, 2)Post, 3)User" +
                "\n write number (example: \"1\" or word \"Region\")");
        return new Scanner(System.in).nextLine();
    }
    void region() {
        System.out.println("чики-пики");
    }
    private void post() {
    }
    private void user() {
    }




}
