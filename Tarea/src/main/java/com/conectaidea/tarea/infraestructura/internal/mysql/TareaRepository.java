package com.conectaidea.tarea.infraestructura.internal.mysql;


import com.conectaidea.tarea.infraestructura.internal.entidad.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaEntity,Long> {
}
