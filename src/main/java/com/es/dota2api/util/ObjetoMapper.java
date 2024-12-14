package com.es.dota2api.util;

import com.es.dota2api.dto.ObjetoDTO;
import com.es.dota2api.model.Objeto;



public class ObjetoMapper {

    // Método para mapear de ObjetoDTO a Objeto
    public static Objeto toEntity(ObjetoDTO dto) {
        if (dto == null) {
            return null;
        }

        Objeto objeto = new Objeto();
        objeto.setNombre(dto.getNombre());
        objeto.setDanioFisico(dto.getDanioFisico());
        objeto.setDanioMagico(dto.getDanioMagico());
        objeto.setVida(dto.getVida());
        objeto.setMana(dto.getMana());
        objeto.setRegenMana(dto.getRegenMana());
        objeto.setRegenVida(dto.getRegenVida());
        objeto.setDescripcion(dto.getDescripcion());

        return objeto;
    }

    // Método para mapear de Objeto a ObjetoDTO
    public static ObjetoDTO toDTO(Objeto objeto) {
        if (objeto == null) {
            return null;
        }

        ObjetoDTO dto = new ObjetoDTO();
        dto.setNombre(objeto.getNombre());
        dto.setDanioFisico(objeto.getDanioFisico());
        dto.setDanioMagico(objeto.getDanioMagico());
        dto.setVida(objeto.getVida());
        dto.setMana(objeto.getMana());
        dto.setRegenMana(objeto.getRegenMana());
        dto.setRegenVida(objeto.getRegenVida());
        dto.setDescripcion(objeto.getDescripcion());

        return dto;
    }
}
