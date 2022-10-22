package com.sfahafi.asistencia.api.service.impl;

import com.sfahafi.asistencia.api.entity.Jornada;
import com.sfahafi.asistencia.api.repository.JornadaRepository;
import com.sfahafi.asistencia.api.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class JornadaServiceImpl implements JornadaService {

    @Autowired
    private JornadaRepository jr;

    @Override
    public ResponseEntity<List<Jornada>> buscarTodas() {
        return ResponseEntity.ok(jr.findAll());
    }

    @Override
    public ResponseEntity<Object> buscarPorId(Integer idJornada) {
        Optional<Jornada> optJornada = jr.findById(idJornada);
        if(!optJornada.isPresent()){
            return ResponseEntity.badRequest().body("El ID indicado no existe!");
        }
        return ResponseEntity.ok(optJornada.get());
    }

    @Override
    public ResponseEntity<Object> guardar(Jornada jornada) {
        jr.save(jornada);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(jornada.getId()).toUri();

        return ResponseEntity.created(uri).body(jornada);
    }

    @Override
    public ResponseEntity<Object> actualizar(Jornada jornada, Integer idJornada) {
        return null;
    }

    @Override
    public ResponseEntity<Object> eliminar(Integer idJornada) {
        return null;
    }
}
