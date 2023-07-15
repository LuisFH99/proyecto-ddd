package com.conectaidea.calificacion.infraestructura.adaptador.mysql;

import com.conectaidea.calificacion.dominio.modelo.Calificacion;
import com.conectaidea.calificacion.dominio.puertos.salida.CalificacionRepositoryPort;
import com.conectaidea.calificacion.infraestructura.adaptador.feignclient.TemaClientRest;
import com.conectaidea.calificacion.infraestructura.entidad.CalificacionEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service("serviceFeign")
@Component
public class CalificacionRepositoryAdapter implements CalificacionRepositoryPort {

    private final CalificacionRepository calificacionRepository;
    private final ConversionService conversionService;
    private final TemaClientRest temaClientRest;

    public CalificacionRepositoryAdapter(CalificacionRepository calificacionRepository, ConversionService conversionService, TemaClientRest temaClientRest){
        this.calificacionRepository = calificacionRepository;
        this.conversionService=conversionService;
        this.temaClientRest=temaClientRest;
    }
    @Override
    public Calificacion save(Calificacion calificacion) {
        /*var recursotm=conversionService.convert(recurso, RecursoEntity.class);
        RecursoEntity saveRecurso=recursoRepository.save(recursotm);
        return conversionService.convert(saveRecurso,Recurso.class);*/
        CalificacionEntity calificacionEntity=CalificacionEntity.mapearDominioModel(calificacion);
        CalificacionEntity saveCalificacion= calificacionRepository.save(calificacionEntity);
        return saveCalificacion.toDominioModel(temaClientRest);
    }

    @Override
    public Calificacion edit(Long id, Calificacion calificacion) {
        Optional<CalificacionEntity> calificacionEntityfind = calificacionRepository.findById(id);
        if(calificacionEntityfind.isPresent()){
            CalificacionEntity calificacionEntity=calificacionEntityfind.get();
            calificacionEntity.setId(id);
            calificacionEntity.setTitulo(calificacion.getTitulo());
            calificacionEntity.setPregunta1(calificacion.getPregunta1());
            calificacionEntity.setPregunta3(calificacion.getPregunta2());
            calificacionEntity.setPregunta2(calificacion.getPregunta3());
            calificacionEntity.setId_tema(calificacion.getTema().getId());
            calificacionEntity = calificacionRepository.save(calificacionEntity);
            /*return conversionService.convert(recursoEntity, Recurso.class);*/
            return calificacionEntity.toDominioModel(temaClientRest);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if(calificacionRepository.existsById(id))
            calificacionRepository.deleteById(id);
    }

    @Override
    public List<Calificacion> getAllCalificacion() {
        return calificacionRepository.findAll().stream().map(
                c->c.toDominioModel(temaClientRest)
        ).collect(Collectors.toList());
    }

    @Override
    public Calificacion getCalificacion(Long id) {
        Optional<CalificacionEntity> calificacionEntityfind = calificacionRepository.findById(id);
        if(calificacionEntityfind.isPresent()){
            CalificacionEntity calificaionEntity = calificacionEntityfind.get();
            return calificaionEntity.toDominioModel(temaClientRest);
        }
        return null;
    }
}
