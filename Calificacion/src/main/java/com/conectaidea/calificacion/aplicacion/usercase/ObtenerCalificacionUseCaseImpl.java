package com.conectaidea.calificacion.aplicacion.usercase;


import com.conectaidea.calificacion.dominio.modelo.Calificacion;
import com.conectaidea.calificacion.dominio.puertos.entrada.ObtenerCalificacionUseCase;
import com.conectaidea.calificacion.dominio.puertos.salida.CalificacionRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ObtenerCalificacionUseCaseImpl implements ObtenerCalificacionUseCase {

    private final CalificacionRepositoryPort calificacionRepositoryPort;

    @Override
    public List<Calificacion> listarCalificacion() {
        return calificacionRepositoryPort.getAllCalificacion();
    }

    @Override
    public Calificacion obtenerCalificacion(Long id) {
        return calificacionRepositoryPort.getCalificacion(id);
    }

    @Override
    public List<Calificacion> obtenerCalificacionTema(Long temaid) {
        return calificacionRepositoryPort.getCalificacionTema(temaid);
    }


}
