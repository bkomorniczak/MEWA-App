package com.project.app.service;

import com.project.app.domain.Speed;
import com.project.app.domain.Temperature;
import com.project.app.domain.WaterLevel;
import com.project.app.repository.PowerRepository;
import com.project.app.domain.Power;
import com.project.app.repository.SpeedRepository;
import com.project.app.repository.TemperatureRepository;
import com.project.app.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

   @Autowired
    private PowerRepository powerRepository;
   @Autowired
    private SpeedRepository speedRepository;
   @Autowired
   private WaterRepository waterRepository;
   @Autowired
   private TemperatureRepository temperatureRepository;

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

    public List<Speed> getAllSpeeds(){
        return speedRepository.findAll();
    }
    public Optional<Speed> getSpeed(final Long id){
        return speedRepository.findById(id);
    }
    public Speed saveSpeed(final Speed speed){
        return speedRepository.save(speed);
    }
    public void deleteSpeed(final Long id){
        speedRepository.deleteById(id);
    }

    public List<WaterLevel> getAllWaters(){
        return waterRepository.findAll();
    }
    public Optional<WaterLevel> getWater(final Long id){
        return waterRepository.findById(id);
    }
    public WaterLevel saveWaterLevel(final WaterLevel waterLevel){
        return waterRepository.save(waterLevel);
    }
    public void deleteWater(final Long id){
        waterRepository.deleteById(id);
    }

    public List<Temperature> getAllTemperature(){
        return temperatureRepository.findAll();
    }
    public Optional<Temperature> getTemperature(final Long id){
        return temperatureRepository.findById(id);
    }
    public Temperature saveTemperature(final Temperature temperature){
        return temperatureRepository.save(temperature);
    }
    public void deleteTemperature(final Long id){
        temperatureRepository.deleteById(id);
    }
}
