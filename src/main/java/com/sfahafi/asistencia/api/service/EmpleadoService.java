package com.sfahafi.asistencia.api.service;

import com.sfahafi.asistencia.api.entity.Empleado;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpleadoService {

    ResponseEntity<List<Empleado>> buscarTodos();
    ResponseEntity<Object> buscarPorId(Integer idEmpleado);
    ResponseEntity<Object> guardar(Empleado empleado);
    ResponseEntity<Object> actualizar(Empleado empleado, Integer idEmpleado);
    ResponseEntity<Object> eliminar(Integer idEmpleado);

}
