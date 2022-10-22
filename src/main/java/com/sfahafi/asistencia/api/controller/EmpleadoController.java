package com.sfahafi.asistencia.api.controller;

import com.sfahafi.asistencia.api.entity.Empleado;
import com.sfahafi.asistencia.api.service.impl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceImpl es;

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> findAll(){
        return es.buscarTodos();
    }

    @PostMapping("/empleados")
    public ResponseEntity<Object> save(@RequestBody Empleado empleado){
        return es.guardar(empleado);
    }

}
