package com.example.concesionario.formulario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface formularioRepository extends JpaRepository<formularioEntidad, Integer> {

  @Query(value = "DELETE from formulario WHERE tel = :tel", nativeQuery = true)
  void deleteByTel(@Param("tel") int tel);

}
