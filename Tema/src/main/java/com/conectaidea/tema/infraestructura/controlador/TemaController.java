package com.conectaidea.tema.infraestructura.controlador;

import com.conectaidea.tema.aplicacion.servicio.TemaServicio;
import com.conectaidea.tema.dominio.modelo.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tema")
public class TemaController {
    @Autowired
    TemaServicio temaServicio;

    @PostMapping
    public Tema crearTema(@RequestBody Tema tema){
        return temaServicio.crearTema(tema);
    }
    @PutMapping("/{id}")
    public Tema editarTema(@PathVariable Long id,@RequestBody Tema tema){
        return temaServicio.editarTema(id,tema);
    }

    @DeleteMapping("/{id}")
    public void eliminarTema(@PathVariable Long id){
        temaServicio.eliminarTema(id);
    }

    @GetMapping
    public List<Tema> listarTemas(){
        return temaServicio.listarTemas();
    }

    @GetMapping("/{id}")
    public Tema obtenerTema(@PathVariable Long id){
        return temaServicio.obtenerTema(id);
    }

}
