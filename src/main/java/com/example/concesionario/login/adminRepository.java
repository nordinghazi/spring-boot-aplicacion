package com.example.concesionario.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface adminRepository extends JpaRepository<admin, Integer> {

  Optional<admin> findByEmailAndPassword(String emailString, String password);

  @Query(value = "DELETE from admin WHERE email = :email", nativeQuery = true)
  void deleteByEmail(@Param("email") String emailString);
}
