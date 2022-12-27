package com.example.concesionario.formulario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;

@Data
@Service
public class formularioService {

    private final formularioRepository formularioRepository;

    public List<formularioEntidad> getFormularios() {

        return formularioRepository.findAll();
    }

    public formularioEntidad getFormularioPorTel(int id) {

        return formularioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente  No Encontrado"));
    }

    public formularioEntidad insertFormulario(formularioEntidad c) {

        return formularioRepository.save(c);
    }

    public void deleteFormularioById(int id) {
        formularioRepository.deleteByTel(id);

    }

}
