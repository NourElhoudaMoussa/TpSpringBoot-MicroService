package com.service.rdvservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private int tel;
}
