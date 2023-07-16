package com.conectaidea.recurso.dominio.puertos.entrada;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.modelo.Tema;

import java.util.List;

public interface ObtenerRecursoUseCase {
    List<Recurso> listarRecurso();
    Recurso obtenerRecurso(Long id);

    List<Recurso> getRecursosTema(Long temaid);

}
