package com.service.patient.service;





import com.service.patient.entity.Patient;

import java.util.List;

public interface IServicePatient {
    Patient createPatient(Patient patient);
    List<Patient> readAllPatient();
}
