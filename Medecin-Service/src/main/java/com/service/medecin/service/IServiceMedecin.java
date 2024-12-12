package com.service.medecin.service;



import com.service.medecin.entity.Medecin;

import java.util.List;
import java.util.Optional;


public interface IServiceMedecin {
    Medecin createMedecin(Medecin medecin);
    List<Medecin> readAllMedecin();
    Optional<Medecin> getById(int id);

}
