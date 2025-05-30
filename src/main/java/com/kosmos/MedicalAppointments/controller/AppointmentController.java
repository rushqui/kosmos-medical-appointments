package com.kosmos.MedicalAppointments.controller;

import com.kosmos.MedicalAppointments.entity.Appointment;
import com.kosmos.MedicalAppointments.entity.Doctor;
import com.kosmos.MedicalAppointments.entity.MedicalClinic;
import com.kosmos.MedicalAppointments.repository.DoctorRepository;
import com.kosmos.MedicalAppointments.repository.MedicalClinicRespository;
import com.kosmos.MedicalAppointments.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MedicalClinicRespository medicalClinicRepository;

    @GetMapping
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());

        List<Doctor> doctors = doctorRepository.findAll();
        List<MedicalClinic> clinics = medicalClinicRepository.findAll();

        model.addAttribute("doctors", doctors);
        model.addAttribute("clinics", clinics);

        return "appointment-form";
    }

    @PostMapping
    public String createAppointment(@RequestParam("doctorId") Long doctorId,
                                    @RequestParam("clinicId") Long clinicId,
                                    @ModelAttribute Appointment appointment, Model model) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
            MedicalClinic clinic = medicalClinicRepository.findById(clinicId).orElseThrow();

            appointment.setDoctor(doctor);
            appointment.setMedicalClinic(clinic);

            appointmentService.createAppointment(appointment);
            model.addAttribute("successMessage", "Cita agendada exitosamente.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }

        // Cargar nuevamente los doctores y clínicas para el formulario
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("clinics", medicalClinicRepository.findAll());
        return "appointment-form";
    }

}
