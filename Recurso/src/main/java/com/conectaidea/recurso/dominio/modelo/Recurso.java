package com.conectaidea.recurso.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recurso {
    private Long id;

    private String nombre;

    private String descripcion;

    private String ruta;

    private String type;

    private Tema tema;
}
