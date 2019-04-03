package com.project.app.controller;


import com.project.app.domain.PowerDto;
import com.project.app.mapper.PowerMapper;
import com.project.app.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/MEW/power")
public class PowerController {

    @Autowired
    private DbService service;
    @Autowired
    private PowerMapper powerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getPowers")
    public List<PowerDto>getPowers(){
        return powerMapper.mapToPowerDtoList(service.getAllPower());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getPower")
    public PowerDto getPower(@RequestParam Long powerId) throws PowerNotFoundException{
        return powerMapper.mapToPowerDto(service.getPower(powerId).orElseThrow(PowerNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePower")
    public void deletePower(@RequestParam Long powerId){
        service.deletePower(powerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePower")
    public PowerDto updatePower(@RequestBody PowerDto powerDto){
        return powerMapper.mapToPowerDto(service.savePower(powerMapper.mapToPower(powerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createPower")
    public void createPower(PowerDto powerDto){

    }









}
