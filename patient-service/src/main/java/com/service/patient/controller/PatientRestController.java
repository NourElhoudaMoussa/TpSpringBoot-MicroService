package com.service.patient.controller;


import com.service.patient.entity.Patient;
import com.service.patient.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patient/")
public class PatientRestController {
    private IServicePatient iServicePatient;

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient){
        return iServicePatient.createPatient(patient);
    }

    @GetMapping("all")
    public List<Patient> allPatient(){
        return iServicePatient.readAllPatient();
    }
    @GetMapping("{id}")
    public Optional<Patient> getPatientById(@PathVariable int id){
        return iServicePatient.getById(id);
    }
}
