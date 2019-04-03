package com.project.app.mapper;



import com.project.app.domain.Speed;
import com.project.app.domain.SpeedDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpeedMapper {
    public Speed mapToSpeed(final SpeedDto speedDto){
        return new Speed(
                speedDto.getId(),
                speedDto.getTurbineSpeed(),
                speedDto.getGeneratorSpeed());

    }

    public SpeedDto mapToSpeedDto (final Speed speed){
        return new SpeedDto(
                speed.getId(),
                speed.getTurbineSpeed(),
                speed.getGeneratorSpeed());

    }

    public List<SpeedDto> mapToSpeedDtoList(final List<Speed> speedList){
        return speedList.stream().map(p -> new SpeedDto(p.getId(), p.getTurbineSpeed(),p.getGeneratorSpeed())).collect(Collectors.toList());
    }

}
