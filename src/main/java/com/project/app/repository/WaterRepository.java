package com.project.app.repository;


import com.project.app.domain.WaterLevel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WaterRepository extends CrudRepository<WaterLevel, Long> {


    @Override
    List<WaterLevel>findAll();

    @Override
    WaterLevel save(WaterLevel water);

    @Override
    Optional<WaterLevel> findById(Long id);
}
