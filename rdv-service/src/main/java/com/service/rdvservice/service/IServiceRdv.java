package com.service.rdvservice.service;


import com.service.rdvservice.entity.Rdv;
import com.service.rdvservice.model.Medecin;
import com.service.rdvservice.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IServiceRdv {
    Rdv getRdvById(int id);
    Rdv createRdv(Rdv rdv);
    List<Rdv> readAllRdv();
    Rdv GetRdvByMedecinAndDateRdv(int medecin_id, LocalDateTime dateRdv);
    Rdv GetRdvByPatientAndDateRdv(int patient_id, LocalDateTime dateRdv);
    List<Rdv> GetAllByDateRdv();
}
