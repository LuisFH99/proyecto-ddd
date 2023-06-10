package com.conectaidea.tarea.aplicacion.usecase;

import com.conectaidea.tarea.dominio.modelo.Tarea;
import com.conectaidea.tarea.dominio.puertos.entrada.ObtenerTareaUseCase;
import com.conectaidea.tarea.dominio.puertos.salida.TareaRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class ObtenerTareaUseCaseImpl implements ObtenerTareaUseCase {

    private final TareaRepositoryPort tareaRepositoryPort;
    @Override
    public List<Tarea> listarTareas() {
        return tareaRepositoryPort.getAllTarea();
    }

    @Override
    public Tarea obtenerTarea(Long id) {
        return tareaRepositoryPort.getTarea(id);
    }
}
