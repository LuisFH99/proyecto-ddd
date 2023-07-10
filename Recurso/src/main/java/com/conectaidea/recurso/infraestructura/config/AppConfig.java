package com.conectaidea.recurso.infraestructura.config;

import com.conectaidea.recurso.aplicacion.servicio.RecursoServicio;
import com.conectaidea.recurso.aplicacion.usercase.MantenimientoRecursoUseCaseImpl;
import com.conectaidea.recurso.aplicacion.usercase.ObtenerRecursoUseCaseImpl;
import com.conectaidea.recurso.dominio.puertos.salida.RecursoRepositoryPort;
import com.conectaidea.recurso.infraestructura.adaptador.mysql.RecursoRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RecursoServicio recursoServicio(RecursoRepositoryPort recursoRepositoryPort){
        return new RecursoServicio(
                new MantenimientoRecursoUseCaseImpl(recursoRepositoryPort),
                new ObtenerRecursoUseCaseImpl(recursoRepositoryPort)
        );
    }
    @Bean
    public RecursoRepositoryPort recursoRepositoryPort(RecursoRepositoryAdapter recursoRepositoryAdapter){
        return recursoRepositoryAdapter;
    }
}
