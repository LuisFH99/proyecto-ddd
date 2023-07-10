package com.conectaidea.recurso.infraestructura.entidad;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="recurso")
@AllArgsConstructor
@NoArgsConstructor
public class RecursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private String ruta;

    private String type;

    private Long id_tema;

    public static RecursoEntity mapearDominioModel (Recurso recurso){
        return new RecursoEntity(recurso.getId(), recurso.getNombre(), recurso.getDescripcion(), recurso.getRuta(), recurso.getType(), recurso.getId_tema() );
    }
    public Recurso toDominioModel(){
        return new Recurso(id,nombre,descripcion, ruta,type,id_tema);
    }
}
