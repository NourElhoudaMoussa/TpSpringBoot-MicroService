package com.service.patient.service;





import com.service.patient.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IServicePatient {
    Patient createPatient(Patient patient);
    List<Patient> readAllPatient();
    Optional<Patient> getById(int id);
}
