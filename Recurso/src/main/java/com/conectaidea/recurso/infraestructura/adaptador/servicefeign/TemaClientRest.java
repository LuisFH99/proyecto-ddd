package com.conectaidea.recurso.infraestructura.adaptador.servicefeign;

import com.conectaidea.recurso.dominio.modelo.Tema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "servicio-tema",url = "http://localhost:8040/api/tema")
public interface TemaClientRest {
    @GetMapping("/{id}")
    public Tema obtenerTema(@PathVariable Long id);
}
