package com.example.concesionario.Coches;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.concesionario.Coches.DTO.cocheInsertDTO;
import com.example.concesionario.Proyecciones.cocheConTipo;
import com.example.concesionario.Proyecciones.cocheSinTipo;
import com.example.concesionario.Tipo_Coches.tipoCocheRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CocheService {

    private final CocheRepository coche;
    private final tipoCocheRepository gettipocoche;

    public List<cocheSinTipo> getCochesSinTipo() {
        return coche.findBy();
    }

    public List<cocheSinTipo> getCoches(int id) {
        return coche.findByTipo(id);
    }

    public cocheConTipo getCocheById(int id) {
        return coche.findCocheById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coche No Encontrado"));
    }

    public cocheConTipo insertCoche(cocheInsertDTO insertCoche) {
        CocheEntidad cocheInsertar = new CocheEntidad();
        cocheInsertar.setTipoCoche(gettipocoche.findById(insertCoche.getTipoCoche()));
        cocheInsertar.setCombustible(insertCoche.getCombustible());
        cocheInsertar.setModelo(insertCoche.getModelo());
        cocheInsertar.setPotencia(insertCoche.getPotencia());
        cocheInsertar.setPrecio(insertCoche.getPrecio());
        coche.save(cocheInsertar);
        return coche.findCocheById(cocheInsertar.getId()).get();
    }

    public CocheEntidad updateCoche(CocheEntidad c, int id) {

        if (!coche.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Coche que quiere actualizar no existe");
        }
        c.setId(id);
        return coche.save(c);

    }

    public void deleteCocheById(int id) {
        if (!coche.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID del coche que quiere borrar no existe");
        }
        coche.deleteById(id);
    }

}