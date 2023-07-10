package com.conectaidea.recurso.infraestructura.controlador;

import com.conectaidea.recurso.aplicacion.servicio.RecursoServicio;
import com.conectaidea.recurso.dominio.modelo.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recurso")
public class RecursoController {
    @Autowired
    RecursoServicio recursoServicio;

    @PostMapping
    public Recurso crearRecurso(@RequestBody Recurso recurso){
        return recursoServicio.crearRecurso(recurso);
    }

    @PutMapping("/{id}")
    public Recurso editarRecurso(@PathVariable Long id,@RequestBody Recurso recurso){
        return recursoServicio.editarRecurso(id,recurso);
    }
    @DeleteMapping("/{id}")
    public void eliminarRecurso(@PathVariable Long id){
        recursoServicio.eliminarRecurso(id);
    }

    @GetMapping
    public List<Recurso> listarRecursos(){
        return recursoServicio.listarRecurso();
    }

    @GetMapping("/{id}")
    public Recurso obtenerRecurso(@PathVariable Long id){
        return recursoServicio.obtenerRecurso(id);
    }
}
