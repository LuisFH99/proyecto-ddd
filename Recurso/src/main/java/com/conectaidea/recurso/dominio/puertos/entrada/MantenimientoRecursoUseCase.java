package com.conectaidea.recurso.dominio.puertos.entrada;

import com.conectaidea.recurso.dominio.modelo.Recurso;

public interface MantenimientoRecursoUseCase {
    Recurso crearRecurso (Recurso recurso);
    Recurso editarRecurso(Long id, Recurso recurso);
    void eliminarRecurso(Long id);
}
