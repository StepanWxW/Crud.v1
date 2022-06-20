package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.repository.implementation.RegionRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.io.File.separator;


public class RegionRepositoryImpl implements RegionRepository {
    final String fileRegions = "src" + separator + "main" + separator + "resources" + separator + "regions.txt";

    Region mapperRegion(String line) {
        String[] word = line.split(" r ");
        return new Region(Long.parseLong(word[0]), word[1]);
    }

    private Long generateId() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileRegions));
        long id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) {
                id = mapperRegion(line).getId();
            }
        }
        return ++id;
    }

    @Override
    public Region create(Region region) {
        if (region.getId() == 0) {
            try {
                region.setId(generateId());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream(fileRegions, true));
            pw.println(region);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return region;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileRegions));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            regionList.add(mapperRegion(scanner.nextLine()));
        }
        return regionList;
    }

    @Override
    public Region getByID(Long id) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileRegions));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
    public Region update(Region region) {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileRegions));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int indicator = 0;
        while (scanner.hasNextLine()) {
            Region r = mapperRegion(scanner.nextLine());
            if (Objects.equals(r.getId(), region.getId())) {
                regionList.add(region);
                indicator = 1;
            } else regionList.add(r);
        }
        if (indicator == 0) {
            region.setId(0L);
            region.setName("0");
        }
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream(fileRegions, false));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Region reg : regionList) {
            pw.println(reg.toString());
        }
        pw.close();
        return region;
    }

    @Override
    public void remove(Long id) {
        List<Region> regionList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileRegions));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            Region r = mapperRegion(scanner.nextLine());
            if (!Objects.equals(r.getId(), id))
                regionList.add(r);
        }
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream(fileRegions, false));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Region reg : regionList) {
            pw.println(reg.toString());
        }
        pw.close();
    }
}

