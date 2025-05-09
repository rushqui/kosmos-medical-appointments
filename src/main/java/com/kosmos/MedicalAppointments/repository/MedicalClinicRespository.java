package com.kosmos.MedicalAppointments.repository;

import com.kosmos.MedicalAppointments.entity.MedicalClinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalClinicRespository extends JpaRepository<MedicalClinic, Long> {
}
