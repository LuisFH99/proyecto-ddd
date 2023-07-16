package com.conectaidea.calificacion.infraestructura.adaptador.mysql;

import com.conectaidea.calificacion.infraestructura.entidad.CalificacionEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<CalificacionEntity,Long> {
    @Query(
            value = "SELECT * FROM calificacion r WHERE r.id_tema = :temaId",
            nativeQuery = true)
    List<CalificacionEntity> findByTemaId(@Param("temaId") Long temaId);
}
