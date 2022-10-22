package com.sfahafi.asistencia.api.service;

import com.sfahafi.asistencia.api.entity.Jornada;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JornadaService {

    ResponseEntity<List<Jornada>> buscarTodas();
    ResponseEntity<Object> buscarPorId(Integer idJornada);
    ResponseEntity<Object> guardar(Jornada jornada);
    ResponseEntity<Object> actualizar(Jornada jornada, Integer idJornada);
    ResponseEntity<Object> eliminar(Integer idJornada);


}
