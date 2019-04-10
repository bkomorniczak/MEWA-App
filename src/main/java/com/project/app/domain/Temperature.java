package com.project.app.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Temperature")
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {


    private Long id;
    private double upperBearingTemp;
    private double lowerBearingTemp;



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


