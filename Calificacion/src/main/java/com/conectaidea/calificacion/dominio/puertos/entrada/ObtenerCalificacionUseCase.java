package com.conectaidea.calificacion.dominio.puertos.entrada;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;

import java.util.List;

public interface ObtenerCalificacionUseCase {
    List<Calificacion> listarCalificacion();
    Calificacion obtenerCalificacion(Long id);
}
