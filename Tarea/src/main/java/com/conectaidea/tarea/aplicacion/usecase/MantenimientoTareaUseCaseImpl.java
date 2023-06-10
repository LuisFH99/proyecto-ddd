package com.conectaidea.tarea.aplicacion.usecase;

import com.conectaidea.tarea.dominio.modelo.Tarea;
import com.conectaidea.tarea.dominio.puertos.entrada.MantenimientoTareaUseCase;
import com.conectaidea.tarea.dominio.puertos.salida.TareaRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MantenimientoTareaUseCaseImpl implements MantenimientoTareaUseCase {

    private final TareaRepositoryPort tareaRepositoryPort;
    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepositoryPort.save(tarea);
    }

    @Override
    public Tarea editarTarea(Long id, Tarea tarea) {
        return tareaRepositoryPort.edit(id, tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepositoryPort.delete(id);
    }
}
