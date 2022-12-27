package com.example.concesionario.login;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "admin")
public class admin {
    @NotNull(message = "el email es obligatorio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    @Email(message = "el email no tiene el formato adecuado")
    private String email;
    @NotNull(message = "la contraseña es obligatoria")
    @Length(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    private String password;

}
