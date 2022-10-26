package com.sfahafi.asistencia.api.controller;

import com.sfahafi.asistencia.api.entity.Jornada;
import com.sfahafi.asistencia.api.service.impl.JornadaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class JornadaController {

    @Autowired
    private JornadaServiceImpl js;

    @GetMapping("/jornadas")
    public ResponseEntity<List<Jornada>> findAll(){
        return js.buscarTodas();
    }

    @PostMapping("/jornadas")
    public ResponseEntity<Object> save(@RequestBody Jornada jornada){
        return js.guardar(jornada);
    }


}
