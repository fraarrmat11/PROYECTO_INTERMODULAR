package com.example.nexspringboot.model;

import jakarta.persistence.*;

@Entity
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Integer experienciaNecesaria;
    private Integer recompensaMonedas = 0;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getExperienciaNecesaria() { return experienciaNecesaria; }
    public void setExperienciaNecesaria(Integer experienciaNecesaria) { this.experienciaNecesaria = experienciaNecesaria; }

    public Integer getRecompensaMonedas() { return recompensaMonedas; }
    public void setRecompensaMonedas(Integer recompensaMonedas) { this.recompensaMonedas = recompensaMonedas; }
}