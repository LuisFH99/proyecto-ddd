package com.conectaidea.tema.infraestructura.repositorio.mysql;

import com.conectaidea.tema.infraestructura.entidad.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TemaRepository extends JpaRepository<TemaEntity,Long> {
}
