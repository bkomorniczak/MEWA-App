package com.project.app.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Speed")
@AllArgsConstructor
@NoArgsConstructor
public class Speed {

    private Long id;
    private double TurbineSpeed;
    private double GeneratorSpeed;




    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "TurbineSpeed")
    public double getTurbineSpeed() {
        return TurbineSpeed;
    }
    @Column(name = "GeneratorSpeed")
    public double getGeneratorSpeed() {
        return GeneratorSpeed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTurbineSpeed(double turbineSpeed) {
        TurbineSpeed = turbineSpeed;
    }

    public void setGeneratorSpeed(double generatorSpeed) {
        GeneratorSpeed = generatorSpeed;
    }

}
