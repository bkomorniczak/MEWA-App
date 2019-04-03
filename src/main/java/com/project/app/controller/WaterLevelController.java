package com.project.app.controller;

import com.project.app.domain.WaterLevel;
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
    public List<WaterLevelDto> getWaters() {
        return waterLevelMapper.mapToWaterLevelDtoList(service.getAllWaters());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getWater")
    public WaterLevelDto getWater(@RequestParam Long waterId) throws WaterLevelNotFoundException {
        return waterLevelMapper.mapToWaterLevelDto(service.getWater(waterId).orElseThrow(WaterLevelNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteWater")
    public void deleteWater(@RequestParam Long waterId) {
        service.deleteWater(waterId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateWater")
    public WaterLevelDto updateWater(@RequestBody WaterLevelDto waterLevelDto) {
        return waterLevelMapper.mapToWaterLevelDto(service.saveWaterLevel(waterLevelMapper.mapToWaterLevel(waterLevelDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createWater")
    public void createWater(WaterLevelDto waterLevelDtoDto) {

    }

}
