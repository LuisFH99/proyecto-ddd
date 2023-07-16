package com.conectaidea.recurso.infraestructura.adaptador.mysql;

import com.conectaidea.recurso.infraestructura.entidad.RecursoEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursoRepository extends JpaRepository<RecursoEntity,Long> {
    @Query(
            value = "SELECT * FROM recurso r WHERE r.id_tema = :temaId",
            nativeQuery = true)
    List<RecursoEntity> findByTemaId(@Param("temaId") Long temaId);

//    List<RecursoEntity> findByIdTema(Long temaid);
}
