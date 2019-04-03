package com.project.app.controller;

import com.project.app.domain.Temperature;
import com.project.app.domain.TemperatureDto;
import com.project.app.mapper.TemperatureMapper;
import com.project.app.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/MEW/temperature")
public class TemperatureController {
    @Autowired
    private DbService service;
    @Autowired
    private TemperatureMapper temperatureMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTemperatures")
    public List<TemperatureDto> getWaters() {
        return temperatureMapper.mapToTemperatureDtoList(service.getAllTemperature());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTemperature")
    public TemperatureDto getWater(@RequestParam Long temperatureId) throws TemperatureNotFoundException {
        return temperatureMapper.mapToTemperatureDto(service.getTemperature(temperatureId).orElseThrow(TemperatureNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTemperature")
    public void deleteTemperature(@RequestParam Long temperatureId) {
        service.deleteTemperature(temperatureId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTemperature")
    public TemperatureDto updateTemperature(@RequestBody TemperatureDto temperatureDto) {
        return temperatureMapper.mapToTemperatureDto(service.saveTemperature(temperatureMapper.mapToTemperature(temperatureDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTemperature")
    public void createTemperature(TemperatureDto temperatureDtoDto) {

    }
}
