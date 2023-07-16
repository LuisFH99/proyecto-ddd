package com.conectaidea.recurso.aplicacion.servicio;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.modelo.Tema;
import com.conectaidea.recurso.dominio.puertos.entrada.MantenimientoRecursoUseCase;
import com.conectaidea.recurso.dominio.puertos.entrada.ObtenerRecursoUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RecursoServicio implements MantenimientoRecursoUseCase, ObtenerRecursoUseCase {

    private final  MantenimientoRecursoUseCase mantenimientoRecursoUseCase;
    private final  ObtenerRecursoUseCase obtenerRecursoUseCase;

    @Override
    public Recurso crearRecurso(Recurso recurso) {
        return mantenimientoRecursoUseCase.crearRecurso(recurso);
    }

    @Override
    public Recurso editarRecurso(Long id, Recurso recurso) {
        return mantenimientoRecursoUseCase.editarRecurso(id,recurso);
    }

    @Override
    public void eliminarRecurso(Long id) {
        mantenimientoRecursoUseCase.eliminarRecurso(id);
    }

    @Override
    public List<Recurso> listarRecurso() {
        return obtenerRecursoUseCase.listarRecurso();
    }

    @Override
    public Recurso obtenerRecurso(Long id) {
        return obtenerRecursoUseCase.obtenerRecurso(id);
    }

    @Override
    public List<Recurso>  getRecursosTema(Long temaid) {
        return obtenerRecursoUseCase.getRecursosTema(temaid);
    }

}
