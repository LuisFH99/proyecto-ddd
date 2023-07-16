package com.conectaidea.recurso.dominio.puertos.salida;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.modelo.Tema;

import java.util.List;

public interface RecursoRepositoryPort {
    Recurso save(Recurso recurso);
    Recurso edit(Long id, Recurso recurso);
    void delete(Long id);
    List<Recurso> getAllRecurso();
    Recurso getRecurso(Long id);

    List<Recurso>  getRecursosTema(Long temaid);

}
