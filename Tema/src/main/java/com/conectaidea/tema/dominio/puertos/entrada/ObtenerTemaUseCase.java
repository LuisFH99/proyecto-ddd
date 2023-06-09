package com.conectaidea.tema.dominio.puertos.entrada;

import com.conectaidea.tema.dominio.modelo.Tema;

import java.util.List;

public interface ObtenerTemaUseCase {
    List<Tema> listarTemas();
    Tema obtenerTema(Long id);
}
