package com.example.concesionario.Coches;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.concesionario.Proyecciones.cocheConTipo;
import com.example.concesionario.Proyecciones.cocheSinTipo;
import com.example.concesionario.Tipo_Coches.tipoCocheEntidad;


public interface CocheRepository extends JpaRepository<CocheEntidad, Integer> {

    @Query("SELECT p FROM CocheEntidad p WHERE p.tipoCoche.id = :tipo")
    List<cocheSinTipo> findByTipo(@Param("tipo") int tipo);

    Optional<cocheConTipo> findCocheById(int id);

    List<cocheSinTipo> findBy();

    tipoCocheEntidad findTipoCocheById(int id);

    String getTipoById(int id);
}
