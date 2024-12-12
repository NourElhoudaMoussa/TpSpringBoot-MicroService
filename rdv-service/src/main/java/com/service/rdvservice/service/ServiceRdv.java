package com.service.rdvservice.service;


import com.service.rdvservice.entity.Rdv;
import com.service.rdvservice.model.Medecin;
import com.service.rdvservice.model.Patient;
import com.service.rdvservice.repository.RdvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
//@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class ServiceRdv implements IServiceRdv{
    private final RdvRepository rdvRepository;

    @Override
    public Rdv getRdvById(int id) {
        return rdvRepository.findById(id).get();
    }

    @Override
    public Rdv createRdv(Rdv rdv) {
        Rdv existingRdvMedecin = rdvRepository.findRdvByMedecinIdAndDateRdv(rdv.getMedecinId(),rdv.getDateRdv());
        Rdv existingRdvPatient = rdvRepository.findRdvByPatientIdAndDateRdv(rdv.getPatientId(),rdv.getDateRdv());
        if (existingRdvMedecin==null && existingRdvPatient==null){
            return rdvRepository.save(rdv);
        }else {
            return null;
        }
    }
    @Override
    public List<Rdv> readAllRdv() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv GetRdvByMedecinAndDateRdv(int medecin_id, LocalDateTime dateRdv) {
        return rdvRepository.findRdvByMedecinIdAndDateRdv(medecin_id,dateRdv);
    }
    @Override
    public Rdv GetRdvByPatientAndDateRdv(int patient_id, LocalDateTime dateRdv) {
        return rdvRepository.findRdvByPatientIdAndDateRdv(patient_id,dateRdv);
    }

    @Override
    public List<Rdv> GetAllByDateRdv() {
        return rdvRepository.findAllByOrderByDateRdvAsc();
    }


}
