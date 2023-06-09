package com.conectaidea.tema.aplicacion.servicio;

import com.conectaidea.tema.dominio.modelo.Tema;
import com.conectaidea.tema.dominio.puertos.entrada.MantenimientoTemaUseCase;
import com.conectaidea.tema.dominio.puertos.entrada.ObtenerTemaUseCase;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class TemaServicio implements MantenimientoTemaUseCase, ObtenerTemaUseCase {

    private final MantenimientoTemaUseCase mantenimientoTemaUseCase;
    private final ObtenerTemaUseCase obtenerTemaUseCase;
    @Override
    public Tema crearTema(Tema tema) {
        return mantenimientoTemaUseCase.crearTema(tema);
    }

    @Override
    public Tema editarTema(Long id, Tema tema) {
        return mantenimientoTemaUseCase.editarTema(id,tema);
    }

    @Override
    public void eliminarTema(Long id) {
        mantenimientoTemaUseCase.eliminarTema(id);
    }

    @Override
    public List<Tema> listarTemas() {
        return obtenerTemaUseCase.listarTemas();
    }

    @Override
    public Tema obtenerTema(Long id) {
        return obtenerTemaUseCase.obtenerTema(id);
    }
}
