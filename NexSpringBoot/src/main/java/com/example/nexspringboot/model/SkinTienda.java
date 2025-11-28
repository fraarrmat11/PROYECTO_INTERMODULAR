package com.example.nexspringboot.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class SkinTienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Integer precio;
    private String colorPrincipal;
    private String descripcion;

    @OneToMany(mappedBy = "skin")
    private List<UsuarioSkin> usuarios;

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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UsuarioSkin> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioSkin> usuarios) {
        this.usuarios = usuarios;
    }
}
