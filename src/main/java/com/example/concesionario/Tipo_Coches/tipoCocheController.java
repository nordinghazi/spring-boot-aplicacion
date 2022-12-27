package com.example.concesionario.Tipo_Coches;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.concesionario.Proyecciones.tipoCocheConCoches;
import com.example.concesionario.Proyecciones.tipoCocheSinCoches;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/tipocoche")
@RestController

public class tipoCocheController {
    private final tipoCocheService tipoCoche;
    

    @GetMapping
    public List<tipoCocheSinCoches> getAllTipoCoche(){
        return tipoCoche.getAllTipoCoche();
    }

    @GetMapping("/{id}")
    
    public tipoCocheConCoches getTipoCocheById(@PathVariable int id){
        return tipoCoche.getCocheById(id);
    }

    @PostMapping
    public tipoCocheEntidad insertarTipoCoche(@RequestBody tipoCocheEntidad tc){

        return tipoCoche.insertTipoCoche(tc);
    }


    @PutMapping("/{id}")
    public tipoCocheEntidad actualizarTipoCoche(@RequestBody tipoCocheEntidad tc, @PathVariable int id){
        return tipoCoche.updateTipoCoche(tc, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoCoche(@PathVariable int id){
        tipoCoche.deleteTipoCoche(id);
    }





}
