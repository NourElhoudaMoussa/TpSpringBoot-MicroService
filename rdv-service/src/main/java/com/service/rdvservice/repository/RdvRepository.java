package com.service.rdvservice.repository;


import com.service.rdvservice.entity.Rdv;
import com.service.rdvservice.model.Medecin;
import com.service.rdvservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv,Integer> {

    public Rdv findRdvByMedecinIdAndDateRdv(int medecin_id, LocalDateTime dateRdv);
    public Rdv findRdvByPatientIdAndDateRdv(int patient_id, LocalDateTime dateRdv);
    List<Rdv> findAllByOrderByDateRdvAsc();
}
