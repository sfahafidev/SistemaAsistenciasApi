package com.sfahafi.asistencia.api.repository;

import com.sfahafi.asistencia.api.entity.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {

}
