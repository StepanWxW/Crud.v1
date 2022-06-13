package main.java.com.stepanwxw.crud.repository.implementation;

import main.java.com.stepanwxw.crud.model.Region;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface RegionRepository extends GenericRepository<Region, Long> {

    @Override
    Region create(Region region) throws IOException;

    @Override
    List<Region> getAll() throws FileNotFoundException;

    @Override
    Region getByID(Long id) throws IOException;

    @Override
    Region update(Region region) throws FileNotFoundException;

    @Override
    void remove(Long id) throws FileNotFoundException;
}
