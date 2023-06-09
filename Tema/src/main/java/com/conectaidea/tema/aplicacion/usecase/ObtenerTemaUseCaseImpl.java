package com.conectaidea.tema.aplicacion.usecase;

import com.conectaidea.tema.dominio.modelo.Tema;
import com.conectaidea.tema.dominio.puertos.entrada.ObtenerTemaUseCase;
import com.conectaidea.tema.dominio.puertos.salida.TemaRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class ObtenerTemaUseCaseImpl implements ObtenerTemaUseCase {
    private final TemaRepositoryPort temaRepositoryPort;
    @Override
    public List<Tema> listarTemas() {
        return temaRepositoryPort.getAllTema();
    }

    @Override
    public Tema obtenerTema(Long id) {
        return temaRepositoryPort.getTema(id);
    }
}
