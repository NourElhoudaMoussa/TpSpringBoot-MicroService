package com.service.patient.service;


import com.service.patient.entity.Patient;
import com.service.patient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServicePatient implements IServicePatient{
    private final PatientRepository patientRepository;
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> readAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getById(int id) {
        return patientRepository.findById(id);
    }
}
