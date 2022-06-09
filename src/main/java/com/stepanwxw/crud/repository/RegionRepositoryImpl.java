package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.*;
import java.util.List;

public class RegionRepositoryImpl implements RegionRepository{

    File fileRegion = new File("\\main\\java\\com\\stepanwxw\\crud\\resource\\region.txt");
    @Override
    public Region create(Region region) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileRegion);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(region);
        oos.close();
        return region;
    }

    @Override
    public List<Region> getAll() {
        return null;
    }

    @Override
    public Region getByID(Long id) throws IOException {
        FileInputStream fis = new FileInputStream("\\main\\java\\com\\stepanwxw\\crud\\resource\\region.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return null;
        }


    @Override
    public Region update(Region region) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
