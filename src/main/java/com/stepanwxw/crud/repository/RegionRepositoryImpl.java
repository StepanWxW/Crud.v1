package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class RegionRepositoryImpl implements RegionRepository{
    String separator = File.separator;

    File fileRegion = new File("src" + separator + "main" + separator
            + "java" + separator + "com" + separator + "stepanwxw" + separator + "crud"
            + separator + "resource" + separator + "region.txt");
    @Override
    public Region create(Region region) throws IOException {
//        PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegion, true));
//        pw.println(region.toString());
//        pw.close();
//        return region;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileRegion, true));
        oos.writeObject(region);
        oos.close();
        return region;
   }

    @Override
    public List<Region> getAll() {
        return null;
    }

    @Override
    public Region getByID(Long id) throws IOException, ClassNotFoundException {
//        Scanner scanner = new Scanner(fileRegion);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
            FileInputStream fis = new FileInputStream(fileRegion);
            ObjectInputStream ois = new ObjectInputStream(fis);

                for (Region r : (Region) ois.readObject()) System.out.println(r);

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
