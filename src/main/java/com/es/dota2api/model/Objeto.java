package com.es.dota2api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "objeto")
@Getter
@Setter
@NoArgsConstructor
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    private Long id;
    @Column(name="nombre", unique = true, nullable = false)
    private String nombre;
    @Column(name= "danio_fisico")
    private Long danioFisico;
    @Column(name="danio_magico")
    private Long danioMagico;
    @Column(name="vida_adicional")
    private Long vida;
    @Column(name="mana_adicional")
    private Long mana;
    @Column(name="mana_regen")
    private Float regenMana;
    @Column(name="vida_regen")
    private Float regenVida;
    @Column(nullable = false)
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Objeto objeto)) return false;
        return Objects.equals(nombre, objeto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public Objeto(String nombre, Long danioFisico, Long danioMagico, Long vida, Long mana, Float regenMana, Float regenVida, String descripcion) {
        this.nombre = nombre;
        this.danioFisico = danioFisico;
        this.danioMagico = danioMagico;
        this.vida = vida;
        this.mana = mana;
        this.regenMana = regenMana;
        this.regenVida = regenVida;
        this.descripcion = descripcion;
    }
}
