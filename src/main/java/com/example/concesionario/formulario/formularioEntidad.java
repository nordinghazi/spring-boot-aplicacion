package com.example.concesionario.formulario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "formulario")
public class formularioEntidad {
    @Id
    private int tel;
    private String nombre;
    private String apellidos;
    private String email;

}
