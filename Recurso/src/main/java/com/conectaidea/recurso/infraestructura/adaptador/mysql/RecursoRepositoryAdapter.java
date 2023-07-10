package com.conectaidea.recurso.infraestructura.adaptador.mysql;

import com.conectaidea.recurso.dominio.modelo.Recurso;
import com.conectaidea.recurso.dominio.puertos.salida.RecursoRepositoryPort;
import com.conectaidea.recurso.infraestructura.entidad.RecursoEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class RecursoRepositoryAdapter implements RecursoRepositoryPort {

    private final RecursoRepository recursoRepository;
    private final ConversionService conversionService;

    public RecursoRepositoryAdapter(RecursoRepository recursoRepository,ConversionService conversionService){
        this.recursoRepository=recursoRepository;
        this.conversionService=conversionService;
    }
    @Override
    public Recurso save(Recurso recurso) {
        /*var recursotm=conversionService.convert(recurso, RecursoEntity.class);
        RecursoEntity saveRecurso=recursoRepository.save(recursotm);
        return conversionService.convert(saveRecurso,Recurso.class);*/
        RecursoEntity recursoEntity=RecursoEntity.mapearDominioModel(recurso);
        RecursoEntity saveRecurso=recursoRepository.save(recursoEntity);
        return saveRecurso.toDominioModel();
    }

    @Override
    public Recurso edit(Long id, Recurso recurso) {
        Optional<RecursoEntity> recursoEntityfind = recursoRepository.findById(id);
        if(recursoEntityfind.isPresent()){
            RecursoEntity recursoEntity=recursoEntityfind.get();
            recursoEntity.setId(id);
            recursoEntity.setNombre(recurso.getNombre());
            recursoEntity.setDescripcion(recurso.getDescripcion());
            recursoEntity.setRuta(recurso.getRuta());
            recursoEntity.setType(recurso.getType());
            recursoEntity.setId_tema(recursoEntity.getId_tema());
            recursoEntity = recursoRepository.save(recursoEntity);
            /*return conversionService.convert(recursoEntity, Recurso.class);*/
            return recursoEntity.toDominioModel();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if(recursoRepository.existsById(id))
            recursoRepository.deleteById(id);
    }

    @Override
    public List<Recurso> getAllRecurso() {
        return recursoRepository.findAll().stream().map(RecursoEntity::toDominioModel).collect(Collectors.toList());
    }

    @Override
    public Recurso getRecurso(Long id) {
        Optional<RecursoEntity> recursoEntityfind = recursoRepository.findById(id);
        if(recursoEntityfind.isPresent()){
            RecursoEntity recursoEntity = recursoEntityfind.get();
            return recursoEntity.toDominioModel();
        }
        return null;
    }
}
