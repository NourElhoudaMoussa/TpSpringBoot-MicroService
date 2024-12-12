package com.service.rdvservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.rdvservice.model.Medecin;
import com.service.rdvservice.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateRdv;
    private String etat;
    @Transient
    private Patient patient;
    private int patientId;
    @Transient
    private Medecin medecin;
    private int medecinId;
}
