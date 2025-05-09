package com.kosmos.MedicalAppointments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MedicalClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer number;
    private Integer floor;

    protected MedicalClinic(){}

    public MedicalClinic(Integer number, Integer floor) {
        this.number = number;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "MedicalClinic{" +
                "id=" + id +
                ", number=" + number +
                ", floor=" + floor +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getFloor() {
        return floor;
    }
}
