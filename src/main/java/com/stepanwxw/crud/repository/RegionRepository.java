package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public interface RegionRepository extends GenericRepository<Region, Long>{

    @Override
    Region create(Region region) throws IOException;

    @Override
    List<Region> getAll() throws FileNotFoundException;

    @Override
    Region getByID(Long id) throws IOException, ClassNotFoundException;

    @Override
    Region update(Region region);

    @Override
    String remove(Long id) throws FileNotFoundException;
}
