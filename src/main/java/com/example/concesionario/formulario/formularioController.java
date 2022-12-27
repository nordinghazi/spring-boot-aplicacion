package com.example.concesionario.formulario;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/formulario")
@RestController
public class formularioController {

    private final formularioService formularioService;

    public formularioController(com.example.concesionario.formulario.formularioService formularioService) {
        this.formularioService = formularioService;
    }

    @GetMapping
    public List<formularioEntidad> getFormularios() {

        return formularioService.getFormularios();
    }

    @GetMapping("/{id}")
    public formularioEntidad getFormularioPorId(@PathVariable int id) {
        return formularioService.getFormularioPorTel(id);
    }

    @PostMapping
    public formularioEntidad insertFormulario(@RequestBody formularioEntidad c) {
        return formularioService.insertFormulario(c);
    }

    @DeleteMapping("/{id}")
    public void deleteFormularioById(@PathVariable int id) {
        formularioService.deleteFormularioById(id);
    }

}
