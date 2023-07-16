package com.conectaidea.tarea.aplicacion.servicio;

import com.conectaidea.tarea.dominio.modelo.Tarea;
import com.conectaidea.tarea.dominio.puertos.entrada.MantenimientoTareaUseCase;
import com.conectaidea.tarea.dominio.puertos.entrada.ObtenerTareaUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TareaServicio implements MantenimientoTareaUseCase, ObtenerTareaUseCase {

    private final MantenimientoTareaUseCase mantenimientoTareaUseCase;
    private final ObtenerTareaUseCase obtenerTareaUseCase;
    @Override
    public Tarea crearTarea(Tarea tarea) {
        return mantenimientoTareaUseCase.crearTarea(tarea);
    }

    @Override
    public Tarea editarTarea(Long id, Tarea tarea) {
        return mantenimientoTareaUseCase.editarTarea(id,tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        mantenimientoTareaUseCase.eliminarTarea(id);
    }

    @Override
    public List<Tarea> listarTareas() {
        return obtenerTareaUseCase.listarTareas();
    }

    @Override
    public Tarea obtenerTarea(Long id) {
        return obtenerTareaUseCase.obtenerTarea(id);
    }

    @Override
    public List<Tarea> obtenerTareasTema(Long temaid) {
        return obtenerTareaUseCase.obtenerTareasTema(temaid);
    }
}
