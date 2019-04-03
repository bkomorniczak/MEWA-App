package com.project.app.mapper;

import com.project.app.domain.Temperature;
import com.project.app.domain.TemperatureDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TemperatureMapper {
    public Temperature mapToTemperature(final TemperatureDto temperatureDto){
        return new Temperature(
                temperatureDto.getId(),
                temperatureDto.getUpperBearingTemp(),
                temperatureDto.getLowerBearingTemp());

    }

    public TemperatureDto mapToTemperatureDto (final Temperature temperature){
        return new TemperatureDto(
                temperature.getId(),
                temperature.getUpperBearingTemp(),
                temperature.getLowerBearingTemp());

    }

    public List<TemperatureDto> mapToTemperatureDtoList(final List<Temperature> temperatureList){
        return temperatureList.stream().map(p -> new TemperatureDto(p.getId(), p.getLowerBearingTemp(),p.getLowerBearingTemp())).collect(Collectors.toList());
    }

}

