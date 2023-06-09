package com.conectaidea.tema.infraestructura.config;

import com.conectaidea.tema.aplicacion.servicio.TemaServicio;
import com.conectaidea.tema.aplicacion.usecase.MantenimientoTareaUseCaseImpl;
import com.conectaidea.tema.aplicacion.usecase.ObtenerTemaUseCaseImpl;
import com.conectaidea.tema.dominio.puertos.salida.TemaRepositoryPort;
import com.conectaidea.tema.infraestructura.repositorio.mysql.MantenimientoTemaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TemaServicio temaServicio(TemaRepositoryPort temaRepositoryPort){
        return new TemaServicio(
                new MantenimientoTareaUseCaseImpl(temaRepositoryPort),
                new ObtenerTemaUseCaseImpl(temaRepositoryPort)
        );
    }
    @Bean
    public TemaRepositoryPort temaRepositoryPort(MantenimientoTemaAdapter mantenimientoTemaAdapter){
        return mantenimientoTemaAdapter;
    }

}
