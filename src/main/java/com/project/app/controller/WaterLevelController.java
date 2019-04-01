package com.project.app.controller;

import com.project.app.domain.WaterLevelDto;
import com.project.app.mapper.WaterLevelMapper;
import com.project.app.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/MEW/water")
public class WaterLevelController {

    @Autowired
    private DbService service;
    @Autowired
    private WaterLevelMapper waterLevelMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getWaters")
    public List<WaterLevelDto> getWaters(){
        return waterLevelMapper.mapToWaterLevelDtoList(service.getAllWaters());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getWater")
    public WaterLevelDto getSpeed(@RequestParam Long waterId) throws WaterLevelNotFoundException{
        return waterLevelMapper.mapToWaterLevelDto(service.getWater(waterId).orElseThrow(WaterLevelNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSpeed")
    public void deleteSpeed(@RequestParam Long speedId){
        service.deleteSpeed(speedId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateSpeed")
    public SpeedDto updateSpeed(@RequestBody SpeedDto speedDto){
        return speedMapper.mapToSpeedDto(service.saveSpeed(speedMapper.mapToSpeed(speedDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createSpeed")
    public void createSpeed(SpeedDto speedDto){

    }
