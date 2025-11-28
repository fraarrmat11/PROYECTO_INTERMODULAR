package com.example.nexspringboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class UsuarioSkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "skin_id")
    private SkinTienda skin;

    private LocalDate fechaCompra;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SkinTienda getSkin() {
        return skin;
    }

    public void setSkin(SkinTienda skin) {
        this.skin = skin;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}