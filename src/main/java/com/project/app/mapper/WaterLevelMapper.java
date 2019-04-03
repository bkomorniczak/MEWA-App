package com.project.app.mapper;

import com.project.app.domain.Speed;
import com.project.app.domain.WaterLevel;
import com.project.app.domain.WaterLevelDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;



    @Component
    public class WaterLevelMapper {
        public WaterLevel mapToWaterLevel(final WaterLevelDto waterLevelDto){
            return new WaterLevel(
                    waterLevelDto.getId(),
                    waterLevelDto.getUpperWaterLevel(),
                    waterLevelDto.getLowerWaterLevel());

        }

        public WaterLevelDto mapToWaterLevelDto (final WaterLevel waterLevel){
            return new WaterLevelDto(
                    waterLevel.getId(),
                    waterLevel.getUpperWaterLevel(),
                    waterLevel.getLowerWaterLevel());
        }
        public List<WaterLevelDto> mapToWaterLevelDtoList(final List<WaterLevel> waterLevelList){
            return waterLevelList.stream().map(p -> new WaterLevelDto(p.getId(), p.getUpperWaterLevel(),p.getLowerWaterLevel())).collect(Collectors.toList());
        }

    }




