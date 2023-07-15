package com.conectaidea.calificacion.infraestructura.adaptador.feignclient;

import com.conectaidea.calificacion.dominio.modelo.Tema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-tema",url = "http://localhost:8040/api/tema")
public interface TemaClientRest {
    @GetMapping("/{id}")
    public Tema obtenerTema(@PathVariable Long id);
}
