package com.project.app.repository;

import com.project.app.domain.Power;
import com.project.app.domain.Temperature;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {


    @Override
    List<Temperature>findAll();

    @Override
    Temperature save(Temperature temperature);

    @Override
    Optional<Temperature> findById(Long id);
}
