package com.conectaidea.recurso.infraestructura.adaptador.mysql;

import com.conectaidea.recurso.infraestructura.entidad.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<RecursoEntity,Long> {
}
