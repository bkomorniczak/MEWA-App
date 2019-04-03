package com.project.app.controller;


import com.project.app.domain.SpeedDto;
import com.project.app.mapper.SpeedMapper;
import com.project.app.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/MEW/speed")
public class SpeedController {

    @Autowired
    private DbService service;
    @Autowired
    private SpeedMapper speedMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getSpeeds")
    public List<SpeedDto>getSpeeds(){
        return speedMapper.mapToSpeedDtoList(service.getAllSpeeds());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSpeed")
    public SpeedDto getSpeed(@RequestParam Long speedId) throws SpeedNotFoundException{
        return speedMapper.mapToSpeedDto(service.getSpeed(speedId).orElseThrow(SpeedNotFoundException::new));
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









}
