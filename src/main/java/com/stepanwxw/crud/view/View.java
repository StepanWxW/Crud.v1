package main.java.com.stepanwxw.crud.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class View {
    public void startMenu() throws FileNotFoundException {
        while (true) {
            switch (line()) {
                case ("Region"):
                case ("1"):
                case ("1)Region"):
                    new CrudMenuImpl().crudMenu();
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
