package com.conectaidea.calificacion.infraestructura.entidad;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="calificacion")
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String pregunta1;

    private String pregunta2;

    private String pregunta3;

    private Long id_tema;

    public static CalificacionEntity mapearDominioModel (Calificacion calificacion){
        return new CalificacionEntity(calificacion.getId(), calificacion.getTitulo(), calificacion.getPregunta1(), calificacion.getPregunta2(), calificacion.getPregunta3(), calificacion.getId_tema() );
    }
    public Calificacion toDominioModel(){
        return new Calificacion(id,titulo,pregunta1, pregunta2,pregunta3,id_tema);
    }
}
