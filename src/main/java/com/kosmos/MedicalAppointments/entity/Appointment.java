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

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public MedicalClinic getMedicalClinic() {
        return medicalClinic;
    }

    public void setMedicalClinic(MedicalClinic medicalClinic) {
        this.medicalClinic = medicalClinic;
    }
}
