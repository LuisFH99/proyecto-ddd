package com.conectaidea.tema.aplicacion.usecase;

import com.conectaidea.tema.dominio.modelo.Tema;
import com.conectaidea.tema.dominio.puertos.entrada.MantenimientoTemaUseCase;
import com.conectaidea.tema.dominio.puertos.salida.TemaRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MantenimientoTareaUseCaseImpl implements MantenimientoTemaUseCase {
    private final TemaRepositoryPort temaRepositoryPort;

    @Override
    public Tema crearTema(Tema tema) {
        return temaRepositoryPort.save(tema);
    }

    @Override
    public Tema editarTema(Long id, Tema tema) {
        return temaRepositoryPort.edit(id,tema);
    }

    @Override
    public void eliminarTema(Long id) {
        temaRepositoryPort.delete(id);
    }
}
