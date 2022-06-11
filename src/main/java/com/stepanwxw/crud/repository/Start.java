package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.IOException;
import java.sql.Timestamp;


public class Start {
    public static void main(String[] args) throws IOException {
        RegionRepositoryImpl region = new RegionRepositoryImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }
}
