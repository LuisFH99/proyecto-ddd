package com.conectaidea.tarea.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {
    private Long id;

    private String nombre;

    private String descripcion;

    private Long id_tema;
}
