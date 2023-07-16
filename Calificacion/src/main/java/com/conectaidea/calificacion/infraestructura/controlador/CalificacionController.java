package com.conectaidea.calificacion.infraestructura.controlador;


import com.conectaidea.calificacion.aplicacion.servicio.CalificacionServicio;
import com.conectaidea.calificacion.dominio.modelo.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calificacion")
public class CalificacionController {
    @Autowired
    CalificacionServicio calificacionServicio;

    @PostMapping
    public Calificacion crearCalificacion(@RequestBody Calificacion calificacion){
        return calificacionServicio.crearCalificacion(calificacion);
    }

    @PutMapping("/{id}")
    public Calificacion editarCalificacion(@PathVariable Long id,@RequestBody Calificacion calificacion){
        return calificacionServicio.editarCalificacion(id,calificacion);
    }
    @DeleteMapping("/{id}")
    public void eliminarCalificacion(@PathVariable Long id){
        calificacionServicio.eliminarCalificacion(id);
    }

    @GetMapping
    public List<Calificacion> listarRecursos(){
        return calificacionServicio.listarCalificacion();
    }

    @GetMapping("/{id}")
    public Calificacion obtenerRecurso(@PathVariable Long id){
        return calificacionServicio.obtenerCalificacion(id);
    }

    @GetMapping("/tema/{temaId}")
    public List<Calificacion> listarCalificacionTema(@PathVariable Long temaId){
        return calificacionServicio.obtenerCalificacionTema(temaId);
    }

}
