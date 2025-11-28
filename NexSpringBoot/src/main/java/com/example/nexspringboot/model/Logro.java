package com.example.nexspringboot.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Logro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Integer requisito;
    private Integer experienciaXDesbloquear = 0;

    @OneToMany(mappedBy = "logro")
    private List<UsuarioLogro> usuarios;

    // Getters y setters


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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRequisito() {
        return requisito;
    }

    public void setRequisito(Integer requisito) {
        this.requisito = requisito;
    }

    public Integer getExperienciaXDesbloquear() {
        return experienciaXDesbloquear;
    }

    public void setExperienciaXDesbloquear(Integer experienciaXDesbloquear) {
        this.experienciaXDesbloquear = experienciaXDesbloquear;
    }

    public List<UsuarioLogro> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioLogro> usuarios) {
        this.usuarios = usuarios;
    }
}