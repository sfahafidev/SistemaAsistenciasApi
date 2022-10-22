package com.sfahafi.asistencia.api.service.impl;

import com.sfahafi.asistencia.api.entity.Empleado;
import com.sfahafi.asistencia.api.repository.EmpleadoRepository;
import com.sfahafi.asistencia.api.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository er;

    @Override
    public ResponseEntity<List<Empleado>> buscarTodos() {
        return ResponseEntity.ok(er.findAll());
    }

    @Override
    public ResponseEntity<Object> buscarPorId(Integer idEmpleado) {
        Optional<Empleado> optEmpleado = er.findById(idEmpleado);
        if(!optEmpleado.isPresent()){
            return ResponseEntity.badRequest().body("El ID indicado no existe!");
        }
        return ResponseEntity.ok(optEmpleado.get());
    }

    @Override
    public ResponseEntity<Object> guardar(Empleado empleado) {
        er.save(empleado);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(empleado.getId()).toUri();

        return ResponseEntity.created(uri).body(empleado);
    }

    @Override
    public ResponseEntity<Object> actualizar(Empleado empleado, Integer idEmpleado) {
        Optional<Empleado> optEmpleado = er.findById(idEmpleado);
        if(!optEmpleado.isPresent()){
            return ResponseEntity.badRequest().body("El ID indicado no existe!");
        }
        empleado.setId(optEmpleado.get().getId());
        er.save(empleado);

        return ResponseEntity.ok(empleado);
    }

    @Override
    public ResponseEntity<Object> eliminar(Integer idEmpleado) {
        Optional<Empleado> optEmpleado = er.findById(idEmpleado);
        if(!optEmpleado.isPresent()){
            return ResponseEntity.badRequest().body("El ID indicado no existe!");
        }
        er.deleteById(optEmpleado.get().getId());

        return ResponseEntity.noContent().build();
    }
}
