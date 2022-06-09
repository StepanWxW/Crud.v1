package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.*;
import java.util.List;

public class RegionRepositoryImpl implements RegionRepository{

    File fileRegion = new File("C:\\JavaCore1\\Crud.v1\\src\\main\\java\\com\\stepanwxw\\crud\\resource\\region.txt");
    @Override
    public Region create(Region region) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegion, true));
        pw.println(region.toString());
        pw.close();
        return region;
    }

    @Override
    public List<Region> getAll() {
        return null;
    }

    @Override
    public Region getByID(Long id) throws IOException {
        FileInputStream fis = new FileInputStream(fileRegion);
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
