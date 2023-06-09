package com.conectaidea.calificacion.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="calificacion")
public class Calificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String pregunta1;

    private String pregunta2;

    private String pregunta3;

    private String pregunta4;

    private Long id_tema;
}
