package com.kosmos.MedicalAppointments.repository;

import com.kosmos.MedicalAppointments.entity.Appointment;
import com.kosmos.MedicalAppointments.entity.Doctor;
import com.kosmos.MedicalAppointments.entity.MedicalClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateBetween(LocalDateTime start, LocalDateTime end);

    boolean existsByMedicalClinicAndDate(MedicalClinic clinic, LocalDateTime date);
    boolean existsByDoctorAndDate(Doctor doctor, LocalDateTime date);

    @Query("SELECT a FROM Appointment a WHERE a.patientName = :patientName AND DATE(a.date) = DATE(:date)")
    List<Appointment> findByPatientNameAndDate(String patientName, LocalDateTime date);

    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.doctor = :doctor AND DATE(a.date) = DATE(:date)")
    long countByDoctorAndDate(Doctor doctor, LocalDateTime date);
}
