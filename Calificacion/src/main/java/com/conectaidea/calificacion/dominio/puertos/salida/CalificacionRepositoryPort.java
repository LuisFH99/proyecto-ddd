package com.conectaidea.calificacion.dominio.puertos.salida;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;

import java.util.List;

public interface CalificacionRepositoryPort {
    Calificacion save(Calificacion calificacion);
    Calificacion edit(Long id, Calificacion calificacion);
    void delete(Long id);
    List<Calificacion> getAllCalificacion();
    Calificacion getCalificacion(Long id);
}
