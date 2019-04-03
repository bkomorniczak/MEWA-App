package com.project.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpeedDto {
    private Long id;
    private double TurbineSpeed;
    private double GeneratorSpeed;
}
