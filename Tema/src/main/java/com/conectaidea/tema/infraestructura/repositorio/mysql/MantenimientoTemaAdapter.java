package com.conectaidea.tema.infraestructura.repositorio.mysql;

import com.conectaidea.tema.dominio.modelo.Tema;
import com.conectaidea.tema.dominio.puertos.salida.TemaRepositoryPort;
import com.conectaidea.tema.infraestructura.entidad.TemaEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MantenimientoTemaAdapter implements TemaRepositoryPort {

    private final TemaRepository temaRepository;
    private final ConversionService conversionService;

    public MantenimientoTemaAdapter(TemaRepository temaRepository, ConversionService conversionService) {
        this.temaRepository = temaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Tema save(Tema tema) {
        //TemaEntity temaEntity=TemaEntity.mapearDominioModel(tema);
        /*var tm=conversionService.convert(tema,TemaEntity.class);
        TemaEntity saveTema=temaRepository.save(tm);
        return conversionService.convert(saveTema,Tema.class);*/
        TemaEntity temaEntity=TemaEntity.mapearDominioModel(tema);
        TemaEntity saveTema=temaRepository.save(temaEntity);
        return saveTema.toDominioModel();
    }

    @Override
    public Tema edit(Long id, Tema tema) {
        Optional<TemaEntity> temaEntityfind = temaRepository.findById(id);
        if(temaEntityfind.isPresent()){
            TemaEntity temaEntity=temaEntityfind.get();
            temaEntity.setId(id);
            temaEntity.setNombre(tema.getNombre());
            temaEntity = temaRepository.save(temaEntity);
            return temaEntity.toDominioModel();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if(temaRepository.existsById(id))
            temaRepository.deleteById(id);
    }

    @Override
    public List<Tema> getAllTema() {
        return temaRepository.findAll().stream().map(TemaEntity::toDominioModel).collect(Collectors.toList());
    }

    @Override
    public Tema getTema(Long id) {
        Optional<TemaEntity> temaEntityfind = temaRepository.findById(id);
        if(temaEntityfind.isPresent()){
            TemaEntity temaEntity = temaEntityfind.get();

            return temaEntity.toDominioModel();
        }
       return null;
    }
}
