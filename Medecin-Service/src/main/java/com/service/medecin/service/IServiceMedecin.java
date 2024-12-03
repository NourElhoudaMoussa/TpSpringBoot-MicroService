package com.service.medecin.service;



import com.service.medecin.entity.Medecin;

import java.util.List;


public interface IServiceMedecin {
    Medecin createMedecin(Medecin medecin);
    List<Medecin> readAllMedecin();

}
