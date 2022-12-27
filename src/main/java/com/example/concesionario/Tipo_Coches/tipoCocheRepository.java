package com.example.concesionario.Tipo_Coches;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.concesionario.Proyecciones.tipoCocheConCoches;
import com.example.concesionario.Proyecciones.tipoCocheSinCoches;



public interface tipoCocheRepository extends JpaRepository<tipoCocheEntidad,Integer>{

    List<tipoCocheSinCoches> findBy();
    Optional<tipoCocheConCoches> findTipoCocheById(int id);
    tipoCocheEntidad findById(int id);
    

    
    
}
