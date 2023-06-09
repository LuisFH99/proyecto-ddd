package com.conectaidea.tema.infraestructura.entidad;

import com.conectaidea.tema.dominio.modelo.Tema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tema")
@AllArgsConstructor
@NoArgsConstructor
public class TemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public static TemaEntity mapearDominioModel(Tema tema){
        return new TemaEntity(tema.getId(),tema.getNombre());
    }

    public Tema toDominioModel(){
        return new Tema(id,nombre);
    }
}
