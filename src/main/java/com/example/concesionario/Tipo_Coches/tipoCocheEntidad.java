package com.example.concesionario.Tipo_Coches;


import java.util.List;
import com.example.concesionario.Coches.CocheEntidad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity 
@Table(name = "tipo_coche")
public class tipoCocheEntidad {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    @OneToMany(mappedBy = "tipoCoche", cascade = CascadeType.PERSIST)
    private List<CocheEntidad> coches;
    
    
    
}
