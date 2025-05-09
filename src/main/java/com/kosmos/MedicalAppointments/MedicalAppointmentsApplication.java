package com.kosmos.MedicalAppointments;

import com.kosmos.MedicalAppointments.entity.Doctor;
import com.kosmos.MedicalAppointments.entity.MedicalClinic;
import com.kosmos.MedicalAppointments.repository.DoctorRepository;
import com.kosmos.MedicalAppointments.repository.MedicalClinicRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MedicalAppointmentsApplication {

	private static final Logger log = LoggerFactory.getLogger(MedicalAppointmentsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MedicalAppointmentsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DoctorRepository docRepository, MedicalClinicRespository clinicRespository) {
		return (args) -> {
			docRepository.save(new Doctor("Alejandro", "Vega", "Villa", "Internista"));
			docRepository.save(new Doctor("Miguel", "Ortega", "Ramirez", "Cardiologo"));
			docRepository.save(new Doctor("Monica", "Diaz", "Fernandez", "Dermatologo"));

			clinicRespository.save(new MedicalClinic(201, 2));
			clinicRespository.save(new MedicalClinic(202, 2));
			clinicRespository.save(new MedicalClinic(203, 2));

			log.info("Doctors found with findAll():");
			log.info("-------------------------------");
			docRepository.findAll().forEach(doctor -> {
				log.info(doctor.toString());
			});
			log.info("");


			log.info("Medical clinics found with findAll():");
			log.info("-------------------------------");
			clinicRespository.findAll().forEach(clinic -> {
				log.info(clinic.toString());
			});
			log.info("");

		};
	}
}
