package com.conectaidea.tarea.infraestructura.internal.mysql;

import com.conectaidea.tarea.dominio.modelo.Tarea;
import com.conectaidea.tarea.dominio.puertos.salida.TareaRepositoryPort;
import com.conectaidea.tarea.infraestructura.external.TemaClientRest;
import com.conectaidea.tarea.infraestructura.internal.entidad.TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service("serviceFeign")
@Component
public class TareaRepositoryAdapter implements TareaRepositoryPort {
    @Autowired
    TareaRepository tareaRepository;
    @Autowired
    TemaClientRest temaClientRest;
    @Override
    public Tarea save(Tarea tarea) {
        TareaEntity tareaEntity=TareaEntity.mapearDominioModel(tarea);
        TareaEntity saveTarea=tareaRepository.save(tareaEntity);
        return saveTarea.toDominioModel(temaClientRest);
    }

    @Override
    public Tarea edit(Long id, Tarea tarea) {
        Optional<TareaEntity> tareaEntityfind = tareaRepository.findById(id);
        if(tareaEntityfind.isPresent()){
            TareaEntity tareaEntity=tareaEntityfind.get();
            tareaEntity.setId(id);
            tareaEntity.setNombre(tarea.getNombre());
            tareaEntity.setDescripcion(tarea.getDescripcion());
            tareaEntity.setId_tema(tarea.getTema().getId());
            tareaEntity = tareaRepository.save(tareaEntity);
            return tareaEntity.toDominioModel(temaClientRest);
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
        return tareaRepository.findAll().stream().map(
                t->t.toDominioModel(temaClientRest)
        ).collect(Collectors.toList());
    }

    @Override
    public Tarea getTarea(Long id) {
        Optional<TareaEntity> tareaEntityfind = tareaRepository.findById(id);
        if(tareaEntityfind.isPresent()){
            TareaEntity tareaEntity = tareaEntityfind.get();
            return tareaEntity.toDominioModel(temaClientRest);
        }
        return null;
    }

    @Override
    public List<Tarea> getTareasTema(Long temaid) {
        return tareaRepository.findByTemaId(temaid).stream().map(
                t->t.toDominioModel(temaClientRest)
        ).collect(Collectors.toList());
    }
}
