package com.example.concesionario.Coches.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class cocheInsertDTO {

    private String modelo;
    private String combustible;
    private int potencia;
    private double precio;
    private int tipoCoche;
}
