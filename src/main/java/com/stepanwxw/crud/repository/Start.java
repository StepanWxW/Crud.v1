package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RegionRepositoryImpl region = new RegionRepositoryImpl();
        region.create(new Region(15L,"Moscow"));
       region.create(new Region(10L,"Tomsk"));
        region.getByID(15L);

    }
}
