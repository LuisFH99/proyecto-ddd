package com.conectaidea.calificacion.aplicacion.usercase;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;
import com.conectaidea.calificacion.dominio.puertos.entrada.MantenimientoCalificacionUseCase;
import com.conectaidea.calificacion.dominio.puertos.salida.CalificacionRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MantenimientoCalificacionUseCaseImpl implements MantenimientoCalificacionUseCase {

    private final CalificacionRepositoryPort calificacionRepositoryPort;
    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        return calificacionRepositoryPort.save(calificacion);
    }

    @Override
    public Calificacion editarCalificacion(Long id, Calificacion calificacion) {
        return calificacionRepositoryPort.edit(id, calificacion);
    }

    @Override
    public void eliminarCalificacion(Long id) {
        calificacionRepositoryPort.delete(id);
    }
}
