package com.sfahafi.asistencia.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull @NotBlank
    private String nombre;

    @NotNull @NotBlank
    private String apellido;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Set<Jornada> jornadas = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(Set<Jornada> jornadas) {
        this.jornadas = jornadas;
        for(Jornada jornada: jornadas){
            jornada.setEmpleado(this);
        }
    }
}
