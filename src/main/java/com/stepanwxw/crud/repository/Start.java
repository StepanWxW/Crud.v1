package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.IOException;


public class Start {
    public static void main(String[] args) throws IOException {
        RegionRepositoryImpl region = new RegionRepositoryImpl();
        region.create(new Region(region.generateId(), "Moscow"));
        region.create(new Region(region.generateId(),"Tomsk"));
        region.create(new Region(region.generateId(),"Vlad"));
        region.create(new Region(region.generateId(),"Ekb"));
//       System.out.println(region.getByID(3L));
//        region.remove(15L);
//        region.getAll();
//        region.update(new Region(15L, "Piter"));
    }
}
