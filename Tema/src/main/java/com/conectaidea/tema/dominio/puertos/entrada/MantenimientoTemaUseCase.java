package com.conectaidea.tema.dominio.puertos.entrada;

import com.conectaidea.tema.dominio.modelo.Tema;


public interface MantenimientoTemaUseCase {
    Tema crearTema (Tema tema);
    Tema editarTema(Long id, Tema tema);
    void eliminarTema(Long id);
}
