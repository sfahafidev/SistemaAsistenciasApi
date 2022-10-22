package com.sfahafi.asistencia.api.service;

import com.sfahafi.asistencia.api.entity.Turno;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TurnoService {

    ResponseEntity<List<Turno>> buscarTodas();
    ResponseEntity<Object> buscarPorId(Integer idTurno);
    ResponseEntity<Object> guardar(Turno turno);
    ResponseEntity<Object> actualizar(Turno turno, Integer idTurno);
    ResponseEntity<Object> eliminar(Integer idTurno);

}
