package com.example.concesionario.Tipo_Coches;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.concesionario.Proyecciones.tipoCocheConCoches;
import com.example.concesionario.Proyecciones.tipoCocheSinCoches;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class tipoCocheService {
    private final tipoCocheRepository tipoCoche;
   
    


    public List<tipoCocheSinCoches> getAllTipoCoche(){
        return tipoCoche.findBy();
    }
    
    public tipoCocheConCoches getCocheById(int id){
        return tipoCoche.findTipoCocheById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"La id del tipo_coche que busca no existe!"));
    }

    public tipoCocheEntidad insertTipoCoche(tipoCocheEntidad c){
       /* if (tipoCocheRepository.existsById(c.getTipo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "el tipo de coche ya existe", null);
        } */
        return tipoCoche.save(c);
    }

    public tipoCocheEntidad updateTipoCoche(tipoCocheEntidad c,int id){
        if (!tipoCoche.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"el tipo_coche que quiere actualizar no existe!");
        }
        c.setId(id);
        return tipoCoche.save(c);
    }
    public void deleteTipoCoche(int id){
         tipoCoche.deleteById(id);
    }

}
