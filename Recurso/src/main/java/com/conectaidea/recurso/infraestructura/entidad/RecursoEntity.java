package com.conectaidea.recurso.infraestructura.entidad;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.modelo.Tema;
import com.conectaidea.recurso.infraestructura.adaptador.servicefeign.TemaClientRest;
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
        return new RecursoEntity(recurso.getId(), recurso.getNombre(), recurso.getDescripcion(), recurso.getRuta(), recurso.getType(), recurso.getTema().getId() );
    }
    public Recurso toDominioModel(TemaClientRest temaClientRest){
        return new Recurso(id,nombre,descripcion, ruta,type,temaClientRest.obtenerTema(id_tema));
    }
}
