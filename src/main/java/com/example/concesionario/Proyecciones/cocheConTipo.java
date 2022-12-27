package com.example.concesionario.Proyecciones;

public interface cocheConTipo {
    int getId();

    String getModelo();

    String getCombustible();

    int getPotencia();

    double getPrecio();

    tipoCocheSinCoches getTipoCoche();
}
