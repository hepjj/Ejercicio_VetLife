package com.ejercicio2.vetlife2.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Long id;
    private String nombreMascota;
    private Long edad;
    private String nombreDuenio;
    private Long peso;
    private String estadoSalud;
}
