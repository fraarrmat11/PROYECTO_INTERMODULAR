package com.example.nexspringboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String nombre;
    private Integer objetivo;
    private Integer progresoActual = 0;
    private Integer experienciaXCompletar = 0;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private Boolean activo = true;

    @OneToMany(mappedBy = "habito")
    private List<RegistroHabito> registros;

    // Getters y setters


    public Integer getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getObjetivo() {
        return objetivo;
    }

    public Integer getProgresoActual() {
        return progresoActual;
    }

    public Integer getExperienciaXCompletar() {
        return experienciaXCompletar;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public List<RegistroHabito> getRegistros() {
        return registros;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetivo(Integer objetivo) {
        this.objetivo = objetivo;
    }

    public void setProgresoActual(Integer progresoActual) {
        this.progresoActual = progresoActual;
    }

    public void setExperienciaXCompletar(Integer experienciaXCompletar) {
        this.experienciaXCompletar = experienciaXCompletar;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setRegistros(List<RegistroHabito> registros) {
        this.registros = registros;
    }
}