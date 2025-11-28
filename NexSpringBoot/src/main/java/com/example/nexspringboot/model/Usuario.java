package com.example.nexspringboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Integer experienciaActual = 0;
    private Integer monedas = 0;

    @ManyToOne
    @JoinColumn(name = "nivel_id")
    private Nivel nivel;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getExperienciaActual() { return experienciaActual; }
    public void setExperienciaActual(Integer experienciaActual) { this.experienciaActual = experienciaActual; }

    public Integer getMonedas() { return monedas; }
    public void setMonedas(Integer monedas) { this.monedas = monedas; }

    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) { this.nivel = nivel; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
