package com.es.dota2api.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class HeroeDTO {
    private String nombre;
    private String inteligencia;
    private String fuerza;
    private String agilidad;
    private String vida;
    private String mana;
    private String historia;

    public HeroeDTO() {
    }
}
