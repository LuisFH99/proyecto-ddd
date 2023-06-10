package com.conectaidea.tarea.dominio.puertos.salida;

import com.conectaidea.tarea.dominio.modelo.Tarea;


import java.util.List;

public interface TareaRepositoryPort {
    Tarea save(Tarea tarea);
    Tarea edit(Long id, Tarea tarea);
    void delete(Long id);
    List<Tarea> getAllTarea();
    Tarea getTarea(Long id);
}
