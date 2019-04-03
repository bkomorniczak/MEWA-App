package com.project.app.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Temperature")
public class Temperature {


    private Long id;
    private double upperBearingTemp;
    private double lowerBearingTemp;

    public Temperature(Long id, double upperBearingTemp, double lowerBearingTemp) {
    }

    public Temperature(double upperBearingTemp, double lowerBearingTemp) {
        this.upperBearingTemp = upperBearingTemp;
        this.lowerBearingTemp = lowerBearingTemp;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }
    @Column(name = "UpperBearingTemperature")
    public double getUpperBearingTemp() {
        return upperBearingTemp;
    }
    @Column(name = "LowerBearingTemperature")
    public double getLowerBearingTemp() {
        return lowerBearingTemp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpperBearingTemp(double upperBearingTemp) {
        this.upperBearingTemp = upperBearingTemp;
    }

    public void setLowerBearingTemp(double lowerBearingTemp) {
        this.lowerBearingTemp = lowerBearingTemp;
    }
}


