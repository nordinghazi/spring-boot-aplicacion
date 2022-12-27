package com.example.concesionario.Coches;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.concesionario.Coches.DTO.cocheInsertDTO;
import com.example.concesionario.Proyecciones.cocheConTipo;
import com.example.concesionario.Proyecciones.cocheSinTipo;

@RequestMapping("/coche")
@RestController
public class CocheController {

    private final CocheService coche;

    public CocheController(CocheService coche) {
        this.coche = coche;
    }

    @GetMapping()
    public List<cocheSinTipo> getCoches(@RequestParam(required = false, defaultValue = "0") int tipo) {
        if (tipo == 0) {
            return coche.getCochesSinTipo();
        }
        return coche.getCoches(tipo);
    }

    @GetMapping("/{id}")
    public cocheConTipo getCocheById(@PathVariable int id) {
        return coche.getCocheById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public cocheConTipo insertar(@RequestBody cocheInsertDTO c) {
        return coche.insertCoche(c);
    }

    @PutMapping("/{id}")
    public CocheEntidad updateCoche(@RequestBody CocheEntidad c, @PathVariable int id) {
        return coche.updateCoche(c, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        coche.deleteCocheById(id);
    }

}
