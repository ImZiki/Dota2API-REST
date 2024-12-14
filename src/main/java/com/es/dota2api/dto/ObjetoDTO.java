package com.es.dota2api.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ObjetoDTO {
    private String nombre;
    private Long danioFisico;
    private Long danioMagico;
    private Long vida;
    private Long mana;
    private Float regenMana;
    private Float regenVida;
    private String descripcion;

    public ObjetoDTO() {
    }
}
