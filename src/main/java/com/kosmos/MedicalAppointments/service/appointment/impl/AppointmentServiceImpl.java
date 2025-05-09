package com.kosmos.MedicalAppointments.service.appointment.impl;

import com.kosmos.MedicalAppointments.entity.Appointment;
import com.kosmos.MedicalAppointments.repository.AppointmentRepository;
import com.kosmos.MedicalAppointments.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) throws Exception {
        LocalDateTime date = appointment.getDate();
        String patient = appointment.getPatientName();

        // 1. Validar si ya hay una cita en el mismo consultorio a la misma hora
        if (appointmentRepository.existsByMedicalClinicAndDate(appointment.getMedicalClinic(), date)) {
            throw new Exception("Ya existe una cita en el mismo consultorio a esa hora.");
        }

        // 2. Validar si el doctor ya tiene una cita a esa hora
        if (appointmentRepository.existsByDoctorAndDate(appointment.getDoctor(), date)) {
            throw new Exception("El doctor ya tiene una cita a esa hora.");
        }

        // 3. Validar si el paciente tiene otra cita el mismo día con menos de 2 horas de diferencia
        List<Appointment> sameDayAppointments = appointmentRepository.findByPatientNameAndDate(patient, date);
        for (Appointment a : sameDayAppointments) {
            long minutesDiff = Duration.between(a.getDate(), date).abs().toMinutes();
            if (minutesDiff < 120) {
                throw new Exception("El paciente no puede tener otra cita con menos de 2 horas de diferencia el mismo día.");
            }
        }

        // 4. Validar que el doctor no tenga más de 8 citas ese día
        long count = appointmentRepository.countByDoctorAndDate(appointment.getDoctor(), date);
        if (count >= 8) {
            throw new Exception("El doctor no puede tener más de 8 citas en un día.");
        }

        return appointmentRepository.save(appointment);
    }
}
