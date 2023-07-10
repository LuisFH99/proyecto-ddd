package com.conectaidea.calificacion.infraestructura.config;


import com.conectaidea.calificacion.aplicacion.servicio.CalificacionServicio;
import com.conectaidea.calificacion.aplicacion.usercase.MantenimientoCalificacionUseCaseImpl;
import com.conectaidea.calificacion.aplicacion.usercase.ObtenerCalificacionUseCaseImpl;
import com.conectaidea.calificacion.dominio.puertos.salida.CalificacionRepositoryPort;
import com.conectaidea.calificacion.infraestructura.adaptador.mysql.CalificacionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CalificacionServicio calificacionServicio(CalificacionRepositoryPort calificacionRepositoryPort){
        return new CalificacionServicio(
                new MantenimientoCalificacionUseCaseImpl(calificacionRepositoryPort),
                new ObtenerCalificacionUseCaseImpl(calificacionRepositoryPort)
        );
    }
    @Bean
    public CalificacionRepositoryPort calificacionRepositoryPort(CalificacionRepositoryAdapter calificacionRepositoryAdapter){
        return calificacionRepositoryAdapter;
    }
}
