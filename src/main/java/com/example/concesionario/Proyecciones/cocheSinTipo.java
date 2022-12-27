package com.example.concesionario.Proyecciones;

import org.springframework.beans.factory.annotation.Value;

public interface cocheSinTipo {
    int getId();

    String getModelo();

    String getCombustible();

    int getPotencia();

    double getPrecio();

    @Value("#{target.tipoCoche.id}")
    int getIdTipoCoche();

}
