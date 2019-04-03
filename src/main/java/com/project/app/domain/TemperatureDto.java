package com.project.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TemperatureDto {
    private Long id;
    private double upperBearingTemp;
    private double lowerBearingTemp;
}
