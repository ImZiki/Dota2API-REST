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
        objeto.setDanioFisico(Long.valueOf(dto.getDanioFisico()));
        objeto.setDanioMagico(Long.valueOf(dto.getDanioMagico()));
        objeto.setVida(Long.valueOf(dto.getVida()));
        objeto.setMana(Long.valueOf(dto.getMana()));
        objeto.setRegenMana(Float.valueOf(dto.getRegenMana()));
        objeto.setRegenVida(Float.valueOf(dto.getRegenVida()));
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
        dto.setDanioFisico(String.valueOf(objeto.getDanioFisico()));
        dto.setDanioMagico(String.valueOf(objeto.getDanioMagico()));
        dto.setVida(String.valueOf(objeto.getVida()));
        dto.setMana(String.valueOf(objeto.getMana()));
        dto.setRegenMana(String.valueOf(objeto.getRegenMana()));
        dto.setRegenVida(String.valueOf(objeto.getRegenVida()));
        dto.setDescripcion(objeto.getDescripcion());

        return dto;
    }
}
