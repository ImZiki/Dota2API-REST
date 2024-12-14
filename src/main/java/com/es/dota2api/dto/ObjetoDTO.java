package com.es.dota2api.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ObjetoDTO {
    private String nombre;
    private String danioFisico;
    private String danioMagico;
    private String vida;
    private String mana;
    private String  regenMana;
    private String  regenVida;
    private String descripcion;

    public ObjetoDTO() {
    }
}
