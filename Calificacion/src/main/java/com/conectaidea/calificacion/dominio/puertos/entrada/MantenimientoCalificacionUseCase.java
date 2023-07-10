package com.conectaidea.calificacion.dominio.puertos.entrada;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;

public interface MantenimientoCalificacionUseCase {
    Calificacion crearCalificacion (Calificacion calificacion);
    Calificacion editarCalificacion(Long id, Calificacion calificacion);
    void eliminarCalificacion(Long id);
}
