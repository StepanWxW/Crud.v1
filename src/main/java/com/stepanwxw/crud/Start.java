package main.java.com.stepanwxw.crud;

import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.repository.RegionRepositoryImpl;

import java.io.FileNotFoundException;

public class Start {
    public static void main(String[] args) throws FileNotFoundException {
        new RegionRepositoryImpl().create(new Region(new RegionRepositoryImpl().generateId(), "Вася"));
    }
}
