package com.example.concesionario.Coches;

import com.example.concesionario.Tipo_Coches.tipoCocheEntidad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coche")
public class CocheEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private String combustible;
    private int potencia;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "tipo_coche")
    private tipoCocheEntidad tipoCoche;

}
