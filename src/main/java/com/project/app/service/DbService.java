package com.project.app.service;

import com.project.app.repository.PowerRepository;
import com.project.app.domain.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

   @Autowired
    private PowerRepository powerRepository;

    public List<Power> getAllPower(){
        return powerRepository.findAll();
    }

    public Optional<Power> getPower(final Long id){
        return powerRepository.findById(id);
    }

    public Power savePower(final Power power){
        return powerRepository.save(power);
    }

    public void deletePower(final Long id){
        powerRepository.deleteById(id);
    }
}
