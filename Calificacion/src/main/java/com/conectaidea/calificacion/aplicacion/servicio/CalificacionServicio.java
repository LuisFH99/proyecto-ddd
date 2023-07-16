package com.conectaidea.calificacion.aplicacion.servicio;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;
import com.conectaidea.calificacion.dominio.puertos.entrada.MantenimientoCalificacionUseCase;
import com.conectaidea.calificacion.dominio.puertos.entrada.ObtenerCalificacionUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CalificacionServicio implements MantenimientoCalificacionUseCase, ObtenerCalificacionUseCase {

    private final  MantenimientoCalificacionUseCase mantenimientoCalificacionUseCase;
    private final  ObtenerCalificacionUseCase obtenerCalificacionUseCase;

    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        return mantenimientoCalificacionUseCase.crearCalificacion(calificacion);
    }

    @Override
    public Calificacion editarCalificacion(Long id, Calificacion calificacion) {
        return mantenimientoCalificacionUseCase.editarCalificacion(id,calificacion);
    }

    @Override
    public void eliminarCalificacion(Long id) {
        mantenimientoCalificacionUseCase.eliminarCalificacion(id);
    }

    @Override
    public List<Calificacion> listarCalificacion() {
        return obtenerCalificacionUseCase.listarCalificacion();
    }

    @Override
    public Calificacion obtenerCalificacion(Long id) {
        return obtenerCalificacionUseCase.obtenerCalificacion(id);
    }

    @Override
    public List<Calificacion> obtenerCalificacionTema(Long temaid) {
        return obtenerCalificacionUseCase.obtenerCalificacionTema(temaid);
    }


}
