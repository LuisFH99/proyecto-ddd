package com.conectaidea.tarea.infraestructura.repositorio.mysql;

import com.conectaidea.tarea.infraestructura.entidad.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaEntity,Long> {
}
