package com.conectaidea.tarea.infraestructura.config;

import com.conectaidea.tarea.aplicacion.servicio.TareaServicio;
import com.conectaidea.tarea.aplicacion.usecase.MantenimientoTareaUseCaseImpl;
import com.conectaidea.tarea.aplicacion.usecase.ObtenerTareaUseCaseImpl;
import com.conectaidea.tarea.dominio.puertos.salida.TareaRepositoryPort;
import com.conectaidea.tarea.infraestructura.repositorio.mysql.TareaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TareaServicio tareaServicio(TareaRepositoryPort tareaRepositoryPort){
        return new TareaServicio(
                new MantenimientoTareaUseCaseImpl(tareaRepositoryPort),
                new ObtenerTareaUseCaseImpl(tareaRepositoryPort)
        );
    }
    @Bean
    public TareaRepositoryPort tareaRepositoryPort(TareaRepositoryAdapter tareaRepositoryAdapter){
        return tareaRepositoryAdapter;
    }

}
