package com.project.app.repository;

import com.project.app.domain.Power;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PowerRepository extends CrudRepository<Power, Long> {


    @Override
    List<Power>findAll();

    @Override
    Power save(Power power);

   @Override
    Optional<Power> findById(Long id);
}
