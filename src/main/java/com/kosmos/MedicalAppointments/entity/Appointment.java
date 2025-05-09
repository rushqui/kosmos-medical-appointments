package com.kosmos.MedicalAppointments.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private String patientName;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private MedicalClinic medicalClinic;

    public Appointment(){}

    public Appointment(LocalDateTime date, String patientName, Doctor doctor, MedicalClinic medicalClinic) {
        this.date = date;
        this.patientName = patientName;
        this.doctor = doctor;
        this.medicalClinic = medicalClinic;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPatientName() {
        return patientName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public MedicalClinic getMedicalClinic() {
        return medicalClinic;
    }
}
