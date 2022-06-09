package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Region;

import java.util.List;

public interface RegionRepository extends GenericRepository<Region, Long>{
    @Override
    Region create(Region region);

    @Override
    List<Region> getAll();

    @Override
    Region getByID(Long id);

    @Override
    Region update(Region region);

    @Override
    void remove(Long id);
}
