package com.sfahafi.asistencia.api.service.impl;

import com.sfahafi.asistencia.api.entity.Turno;
import com.sfahafi.asistencia.api.repository.TurnoRepository;
import com.sfahafi.asistencia.api.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private TurnoRepository tr;

    @Override
    public ResponseEntity<List<Turno>> buscarTodas() {
        return ResponseEntity.ok(tr.findAll());
    }

    @Override
    public ResponseEntity<Object> buscarPorId(Integer idTurno) {
        return null;
    }

    @Override
    public ResponseEntity<Object> guardar(Turno turno) {
        return null;
    }

    @Override
    public ResponseEntity<Object> actualizar(Turno turno, Integer idTurno) {
        return null;
    }

    @Override
    public ResponseEntity<Object> eliminar(Integer idTurno) {
        return null;
    }
}
