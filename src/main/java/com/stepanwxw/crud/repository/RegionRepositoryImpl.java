package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class RegionRepositoryImpl implements RegionRepository {
    Long generateId() throws FileNotFoundException {
        Scanner scanner = new Scanner(fileId);
        long id = Long.parseLong(scanner.nextLine());
        Long idNew = ++id;
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileId, false));
        pw.println(idNew);
        pw.close();
        return id;
    }

    Region mapper(String line) {
        String[] word = line.split(" : ");
        String number = word[0];
        Long idArray = Long.parseLong(number);
        String nameArray = word[1];
        return new Region(idArray, nameArray);
    }

    String separator = File.separator;
    File fileId = new File("src" + separator + "main" + separator
            + "java" + separator + "com" + separator + "stepanwxw" + separator + "crud"
            + separator + "resource" + separator + "id.txt");

    File fileRegion = new File("src" + separator + "main" + separator
            + "java" + separator + "com" + separator + "stepanwxw" + separator + "crud"
            + separator + "resource" + separator + "region.txt");

    @Override
    public Region create(Region region) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegion, true));
        pw.println(region.toString());
        pw.close();
        return region;
    }

    @Override
    public List<Region> getAll() throws FileNotFoundException {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner = new Scanner(fileRegion);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Region r = mapper(line);
            regionList.add(r);
        }
        return regionList;
    }

    @Override
    public Region getByID(Long id) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileRegion);
        Region returtRegion = new Region(id, " This id was not found");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Region r = mapper(line);
            if (Objects.equals(r.getId(), id)) {
                returtRegion = r;
            }
        }
        return returtRegion;
    }

    @Override
    public Region update(Region region) throws FileNotFoundException {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner = new Scanner(fileRegion);
        Region returtRegion = new Region(region.getId(), " This id was not found");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Region r = mapper(line);
            if (Objects.equals(r.getId(), region.getId())) {
                returtRegion = region;
                regionList.add(region);
            } else regionList.add(r);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegion, false));
        for (Region reg : regionList) {
            pw.println(reg.toString());
        }
        pw.close();
        return returtRegion;
    }

    @Override
    public void remove(Long id) throws FileNotFoundException {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner = new Scanner(fileRegion);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Region r = mapper(line);
            if (Objects.equals(r.getId(), id)) {
            } else regionList.add(r);
        }
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegion, false));
            for (Region reg : regionList) {
                pw.println(reg.toString());
            }
            pw.close();
        }
    }

