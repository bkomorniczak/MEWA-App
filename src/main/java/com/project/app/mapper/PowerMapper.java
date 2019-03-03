package com.project.app.mapper;


import com.project.app.domain.Power;
import com.project.app.domain.PowerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PowerMapper {
    public Power mapToPower(final PowerDto powerDto){
        return new Power(
                powerDto.getId(),
                powerDto.getPower());

    }

    public PowerDto mapToPowerDto (final Power power){
        return new PowerDto(
                power.getId(),
                power.getPower());

    }

    public List<PowerDto> mapToPowerDtoList(final List<Power> powerList){
        return powerList.stream().map(p -> new PowerDto(p.getId(), p.getPower())).collect(Collectors.toList());
    }

}
