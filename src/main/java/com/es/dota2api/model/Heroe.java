package com.es.dota2api.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name="heroe")

@Getter
@Setter
@NoArgsConstructor
public class Heroe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    private Long id;

    @Column(name="nombre", unique = true, nullable = false)
    private String nombre;
    @Column(name="inteligencia", nullable = false)
    private Long inteligencia;
    @Column(name="fuerza", nullable = false)
    private Long fuerza;
    @Column(name="agilidad", nullable = false)
    private Long agilidad;
    @Column(name="vida", nullable = false)
    private Long vida;
    @Column(name="mana")
    private Long mana;
    @Column(name="historia", length = 65535)
    private String historia;

    public Heroe(String nombre, Long inteligencia, Long fuerza, Long agilidad, Long vida, Long mana, String historia) {
        this.nombre = nombre;

        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.vida = vida;
        this.mana = mana;
        this.historia = historia;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heroe heroe)) return false;
        return Objects.equals(nombre, heroe.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
