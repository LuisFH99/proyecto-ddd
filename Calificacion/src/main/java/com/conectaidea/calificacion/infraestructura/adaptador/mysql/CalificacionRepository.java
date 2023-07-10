package com.conectaidea.calificacion.infraestructura.adaptador.mysql;

import com.conectaidea.calificacion.infraestructura.entidad.CalificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<CalificacionEntity,Long> {
}
