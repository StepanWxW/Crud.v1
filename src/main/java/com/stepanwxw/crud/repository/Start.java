package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.IOException;
import java.util.ArrayList;

public class Start {
    public static void main(String[] args) throws IOException {
        RegionRepositoryImpl region = new RegionRepositoryImpl();
//        region.create(new Region(15L,"Moscow!@3"));
//        region.create(new Region(1L,"Tomsk"));
//       System.out.println(region.getByID(3L));
//        System.out.println(region.remove(15L));
        System.out.println(region.getAll());
    }
}
