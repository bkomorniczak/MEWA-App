package com.project.app.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WaterLevel")
@AllArgsConstructor
@NoArgsConstructor
public class WaterLevel {


    private Long id;
    private double upperWaterLevel;
    private double lowerWaterLevel;


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }
    @Column(name="UpperWaterLevel")
    public double getUpperWaterLevel() {
        return upperWaterLevel;
    }
    @Column(name = "LowerWaterLevel")
    public double getLowerWaterLevel() {
        return lowerWaterLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpperWaterLevel(double upperWaterLevel) {
        this.upperWaterLevel = upperWaterLevel;
    }

    public void setLowerWaterLevel(double lowerWaterLevel) {
        this.lowerWaterLevel = lowerWaterLevel;
    }
}
