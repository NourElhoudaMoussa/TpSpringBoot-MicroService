package com.service.rdvservice.controller;


import com.service.rdvservice.clients.MedecinRestClient;
import com.service.rdvservice.clients.PatientRestClient;
import com.service.rdvservice.entity.Rdv;
import com.service.rdvservice.model.Medecin;
import com.service.rdvservice.model.Patient;
import com.service.rdvservice.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {
    private IServiceRdv iServiceRdv;
    private PatientRestClient patientRestClient;
    private MedecinRestClient medecinRestClient;

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody Rdv rdv){
        Rdv save_rdv=null;
        Optional<Patient> patient=patientRestClient.getPatientById(rdv.getPatientId());
        Optional<Medecin> medecin=medecinRestClient.getMedecinById(rdv.getMedecinId());
        if(patient.isPresent() && medecin.isPresent()){
             save_rdv= iServiceRdv.createRdv(rdv);
        }
        if(save_rdv!=null){
            return new ResponseEntity<>(save_rdv, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Le RDV ne pas être créer,merci de vérifier vos données ",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("all")
    public List<Rdv> allRdv() {
        List<Rdv> liste = iServiceRdv.readAllRdv();
        for (Rdv rdv : liste) {
            // Fetch Patient and Medecin using Optional and check if they exist
            Optional<Patient> patient = patientRestClient.getPatientById(rdv.getPatientId());
            Optional<Medecin> medecin = medecinRestClient.getMedecinById(rdv.getMedecinId());

            // Set patient only if it exists
            patient.ifPresent(rdv::setPatient);  // Set patient if it's present
            // Set medecin only if it exists
            medecin.ifPresent(rdv::setMedecin);  // Set medecin if it's present

            // Optionally log or handle the case where patient or medecin is not found
            if (!patient.isPresent()) {
                System.out.println("Patient not found for Rdv ID: " + rdv.getId());
            }
            if (!medecin.isPresent()) {
                System.out.println("Medecin not found for Rdv ID: " + rdv.getId());
            }
        }
        return liste;
    }


    @GetMapping("RdvOrderByDateRdv")
    private List<Rdv> RdvOrderbyDateRdv(){
        return iServiceRdv.GetAllByDateRdv();
    }

    @GetMapping("{id}")
    public Rdv getById(@PathVariable int id){
        Rdv rdv=iServiceRdv.getRdvById(id);
        Optional<Patient> patient=patientRestClient.getPatientById(rdv.getPatientId());
        Optional<Medecin> medecin=medecinRestClient.getMedecinById(rdv.getMedecinId());
        rdv.setPatient(patient.get());
        rdv.setMedecin(medecin.get());
        return rdv;
    }
}
