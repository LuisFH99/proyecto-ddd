package com.conectaidea.tarea.dominio.puertos.entrada;

import com.conectaidea.tarea.dominio.modelo.Tarea;

import java.util.List;

public interface ObtenerTareaUseCase {
    List<Tarea> listarTareas();
    Tarea obtenerTarea(Long id);
    List<Tarea> obtenerTareasTema(Long temaid);
}
