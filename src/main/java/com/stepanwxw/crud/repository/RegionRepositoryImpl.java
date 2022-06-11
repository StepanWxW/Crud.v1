package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class RegionRepositoryImpl implements RegionRepository {
    String separator = File.separator;
    File fileRegions = new File("src" + separator + "main"
            + separator + "resources" + separator + "regions.txt");

    Region mapperRegion(String line) {
        String[] word = line.split(" r ");
        return new Region(Long.parseLong(word[0]), word[1]);
    }
    public Long generateId() throws FileNotFoundException {
        Scanner scanner = new Scanner(fileRegions);
        long id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (Objects.equals(line, ""));
            else {
                Region r = mapperRegion(line);
                id = r.getId();
            }
        }
        return ++id;
    }

    @Override
    public Region create(Region region) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegions, true));
        pw.println(region.toString());
        pw.close();
        return region;
    }

    @Override
    public List<Region> getAll() throws FileNotFoundException {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner = new Scanner(fileRegions);
        while (scanner.hasNextLine()) {
            regionList.add(mapperRegion(scanner.nextLine()));
        }
        return regionList;
    }

    @Override
    public Region getByID(Long id) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileRegions);
        Region region = null;
        while (scanner.hasNextLine()) {
            Region r = mapperRegion(scanner.nextLine());
            if (Objects.equals(r.getId(), id)) {
                region = new Region(id, r.getName());
            }
        }
        return region;
    }

    @Override
    public Region update(Region region) throws FileNotFoundException {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner = new Scanner(fileRegions);
        while (scanner.hasNextLine()) {
            Region r = mapperRegion(scanner.nextLine());
            if (Objects.equals(r.getId(), region.getId())) {
                regionList.add(region);
            } else regionList.add(r);
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegions, false));
        for (Region reg : regionList) {
            pw.println(reg.toString());
        }
        pw.close();
        return region;
    }

    @Override
    public void remove(Long id) throws FileNotFoundException {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner = new Scanner(fileRegions);
        while (scanner.hasNextLine()) {
            Region r = mapperRegion(scanner.nextLine());
            if (!Objects.equals(r.getId(), id))
                regionList.add(r);
        }
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileRegions, false));
            for (Region reg : regionList) {
                pw.println(reg.toString());
            }
            pw.close();
        }
    }

