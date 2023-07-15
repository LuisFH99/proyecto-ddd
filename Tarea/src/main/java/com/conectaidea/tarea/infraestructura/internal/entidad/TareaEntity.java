package com.conectaidea.tarea.infraestructura.internal.entidad;

import com.conectaidea.tarea.dominio.modelo.Tarea;
import com.conectaidea.tarea.dominio.modelo.Tema;
import com.conectaidea.tarea.infraestructura.external.TemaClientRest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="tarea")
@AllArgsConstructor
@NoArgsConstructor
public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private Long id_tema;

    public static TareaEntity mapearDominioModel (Tarea tarea){
        return new TareaEntity(tarea.getId(),tarea.getNombre(),tarea.getDescripcion(),tarea.getTema().getId());
    }
    public Tarea toDominioModel(TemaClientRest temaClientRest){
        return new Tarea(id,nombre,descripcion,temaClientRest.obtenerTema(id_tema));
    }
}
