package com.kosmos.MedicalAppointments.service.appointment;

import com.kosmos.MedicalAppointments.entity.Appointment;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment) throws Exception;
}
