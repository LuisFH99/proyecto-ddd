package com.conectaidea.recurso.aplicacion.usercase;


import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.puertos.entrada.ObtenerRecursoUseCase;
import com.conectaidea.recurso.dominio.puertos.salida.RecursoRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ObtenerRecursoUseCaseImpl implements ObtenerRecursoUseCase {

    private final RecursoRepositoryPort recursoRepositoryPort;

    @Override
    public List<Recurso> listarRecurso() {
        return recursoRepositoryPort.getAllRecurso();
    }

    @Override
    public Recurso obtenerRecurso(Long id) {
        return recursoRepositoryPort.getRecurso(id);
    }
}
