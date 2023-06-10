package com.conectaidea.tarea.infraestructura.repositorio.mysql;

import com.conectaidea.tarea.dominio.modelo.Tarea;
import com.conectaidea.tarea.dominio.puertos.salida.TareaRepositoryPort;
import com.conectaidea.tarea.infraestructura.entidad.TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TareaRepositoryAdapter implements TareaRepositoryPort {
    @Autowired
    TareaRepository tareaRepository;
    @Override
    public Tarea save(Tarea tarea) {
        TareaEntity tareaEntity=TareaEntity.mapearDominioModel(tarea);
        TareaEntity saveTarea=tareaRepository.save(tareaEntity);
        return saveTarea.toDominioModel();
    }

    @Override
    public Tarea edit(Long id, Tarea tarea) {
        Optional<TareaEntity> tareaEntityfind = tareaRepository.findById(id);
        if(tareaEntityfind.isPresent()){
            TareaEntity tareaEntity=tareaEntityfind.get();
            tareaEntity.setId(id);
            tareaEntity.setNombre(tarea.getNombre());
            tareaEntity.setDescripcion(tarea.getDescripcion());
            tareaEntity.setId_tema(tarea.getId_tema());
            tareaEntity = tareaRepository.save(tareaEntity);
            return tareaEntity.toDominioModel();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if(tareaRepository.existsById(id))
            tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> getAllTarea() {
        return tareaRepository.findAll().stream().map(TareaEntity::toDominioModel).collect(Collectors.toList());
    }

    @Override
    public Tarea getTarea(Long id) {
        Optional<TareaEntity> tareaEntityfind = tareaRepository.findById(id);
        if(tareaEntityfind.isPresent()){
            TareaEntity tareaEntity = tareaEntityfind.get();
            return tareaEntity.toDominioModel();
        }
        return null;
    }
}
