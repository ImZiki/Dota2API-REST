package com.es.dota2api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name="heroe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Heroe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    private Long id;

    @Column(name="nombre_heroe", unique = true, nullable = false)
    private String nombre;

    @Column(name= "danio_fisico", nullable = false, length = 5)
    private Long danioFisico;

    @Column(name="danio_magico", length = 5)
    private Long danioMagico;
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

    public Heroe(String nombre, Long danioFisico, Long danioMagico, Long inteligencia, Long fuerza, Long agilidad, Long vida, Long mana, String historia, List<HeroeObjeto> objetos) {
        this.nombre = nombre;
        this.danioFisico = danioFisico;
        this.danioMagico = danioMagico;
        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.vida = vida;
        this.mana = mana;
        this.historia = historia;
        this.objetos = objetos;
    }

    @OneToMany(mappedBy = "heroe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HeroeObjeto> objetos;



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
