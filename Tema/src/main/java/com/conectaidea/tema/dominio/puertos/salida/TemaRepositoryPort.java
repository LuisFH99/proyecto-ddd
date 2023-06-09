package com.conectaidea.tema.dominio.puertos.salida;

import com.conectaidea.tema.dominio.modelo.Tema;

import java.util.List;

public interface TemaRepositoryPort {
    Tema save(Tema tema);
    Tema edit(Long id, Tema tema);
    void delete(Long id);
    List<Tema> getAllTema();
    Tema getTema(Long id);
}
