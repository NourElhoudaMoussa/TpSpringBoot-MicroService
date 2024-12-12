package com.service.medecin.service;


import com.service.medecin.entity.Medecin;
import com.service.medecin.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceMedecin implements IServiceMedecin{
    private final MedecinRepository medecinRepository;
    @Override
    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> readAllMedecin() {
        return medecinRepository.findAll();
    }

    @Override
    public Optional<Medecin> getById(int id) {
        return medecinRepository.findById(id);
    }
}
