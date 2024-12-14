package com.es.dota2api.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "heroe_objeto")
@NoArgsConstructor
public class HeroeObjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_heroe", nullable = false)
    private Heroe heroe;

    @ManyToOne
    @JoinColumn(name="id_objeto", nullable = false)
    private Objeto objeto;

    @Column(name = "cantidad", nullable = false)
    private Long cantidad;

    public HeroeObjeto(Heroe heroe, Objeto objeto, Long cantidad) {
        this.heroe = heroe;
        this.objeto = objeto;
        this.cantidad = cantidad;
    }
}
