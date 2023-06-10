package com.conectaidea.tarea.dominio.puertos.entrada;

import com.conectaidea.tarea.dominio.modelo.Tarea;


public interface MantenimientoTareaUseCase {
    Tarea crearTarea (Tarea tarea);
    Tarea editarTarea(Long id, Tarea tarea);
    void eliminarTarea(Long id);
}
