package com.conectaidea.calificacion.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {
    private Long id;

    private String titulo;

    private String pregunta1;

    private String pregunta2;

    private String pregunta3;

    private Long id_tema;
}
