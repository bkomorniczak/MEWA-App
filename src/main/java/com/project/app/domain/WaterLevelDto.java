package com.project.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WaterLevelDto {
    private Long id;
    private double upperWaterLevel;
    private double lowerWaterLevel;
}
