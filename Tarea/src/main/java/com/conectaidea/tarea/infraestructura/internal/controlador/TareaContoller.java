package com.conectaidea.tarea.infraestructura.internal.controlador;

import com.conectaidea.tarea.aplicacion.servicio.TareaServicio;
import com.conectaidea.tarea.dominio.modelo.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaContoller {
    @Autowired
    TareaServicio tareaServicio;

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea){
        return tareaServicio.crearTarea(tarea);
    }
    @PutMapping("/{id}")
    public Tarea editarTarea(@PathVariable Long id,@RequestBody Tarea tarea){
        return tareaServicio.editarTarea(id,tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id){
        tareaServicio.eliminarTarea(id);
    }

    @GetMapping
    public List<Tarea> listarTemas(){
        return tareaServicio.listarTareas();
    }

    @GetMapping("/{id}")
    public Tarea obtenerTema(@PathVariable Long id){
        return tareaServicio.obtenerTarea(id);
    }
}
