package com.conectaidea.tarea.infraestructura.internal.mysql;


import com.conectaidea.tarea.infraestructura.internal.entidad.TareaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TareaRepository extends JpaRepository<TareaEntity,Long> {
    @Query(
            value = "SELECT * FROM tarea r WHERE r.id_tema = :temaId",
            nativeQuery = true)
    List<TareaEntity> findByTemaId(@Param("temaId") Long temaId);
}
