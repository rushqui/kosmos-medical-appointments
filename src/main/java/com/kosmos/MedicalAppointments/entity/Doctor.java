package com.kosmos.MedicalAppointments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstLastname;
    private String secondLastname;
    private String specialty;

    protected Doctor(){}

    public Doctor(String name, String firstLastname, String secondLastname, String specialty) {
        this.name = name;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstLastname='" + firstLastname + '\'' +
                ", secondLastname='" + secondLastname + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public String getSpecialty() {
        return specialty;
    }
}
