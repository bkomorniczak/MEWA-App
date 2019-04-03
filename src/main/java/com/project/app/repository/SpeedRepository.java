package com.project.app.repository;

import com.project.app.domain.Power;
import com.project.app.domain.Speed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpeedRepository extends CrudRepository<Speed, Long> {


    @Override
    List<Speed>findAll();

    @Override
    Speed save(Speed speed);

    @Override
    Optional<Speed> findById(Long id);
}
