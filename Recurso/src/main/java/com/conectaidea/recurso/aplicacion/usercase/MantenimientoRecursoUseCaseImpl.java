package com.conectaidea.recurso.aplicacion.usercase;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.puertos.entrada.MantenimientoRecursoUseCase;
import com.conectaidea.recurso.dominio.puertos.salida.RecursoRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MantenimientoRecursoUseCaseImpl implements MantenimientoRecursoUseCase {

    private final RecursoRepositoryPort recursoRepositoryPort;
    @Override
    public Recurso crearRecurso(Recurso recurso) {
        return recursoRepositoryPort.save(recurso);
    }

    @Override
    public Recurso editarRecurso(Long id, Recurso recurso) {
        return recursoRepositoryPort.edit(id, recurso);
    }

    @Override
    public void eliminarRecurso(Long id) {
        recursoRepositoryPort.delete(id);
    }
}
