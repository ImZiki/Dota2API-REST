package com.es.dota2api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "objeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    private Long id;
    @Column(name="nombre_objeto", unique = true, nullable = false)
    private String nombre;
    @Column(name= "danio_fisico", nullable = false)
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


    @OneToMany(mappedBy = "objeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HeroeObjeto> heroes;

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

    public Objeto(String nombre, Long danioFisico, Long danioMagico, Long vida, Long mana, Float regenMana, Float regenVida, List<HeroeObjeto> heroes) {
        this.nombre = nombre;
        this.danioFisico = danioFisico;
        this.danioMagico = danioMagico;
        this.vida = vida;
        this.mana = mana;
        this.regenMana = regenMana;
        this.regenVida = regenVida;
        this.heroes = heroes;
    }
}
