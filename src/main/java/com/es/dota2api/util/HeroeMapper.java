package com.es.dota2api.util
        ;

import com.es.dota2api.dto.HeroeDTO;
import com.es.dota2api.model.Heroe;
import org.springframework.stereotype.Component;


@Component
public class HeroeMapper {

    // Método para mapear de HeroeDTO a Heroe
    public static Heroe toEntity(HeroeDTO dto) {
        if (dto == null) {
            return null;
        }

        Heroe heroe = new Heroe();
        heroe.setNombre(dto.getNombre());
        heroe.setInteligencia(Long.valueOf(dto.getInteligencia()));
        heroe.setFuerza(Long.valueOf(dto.getFuerza()));
        heroe.setAgilidad(Long.valueOf(dto.getAgilidad()));
        heroe.setVida(Long.valueOf(dto.getVida()));
        heroe.setMana(Long.valueOf(dto.getMana()));
        heroe.setHistoria(dto.getHistoria());

        return heroe;
    }

    // Método para mapear de Heroe a HeroeDTO
    public static HeroeDTO toDTO(Heroe heroe) {
        if (heroe == null) {
            return null;
        }

        HeroeDTO dto = new HeroeDTO();
        dto.setNombre(heroe.getNombre());
        dto.setInteligencia(String.valueOf(heroe.getInteligencia()));
        dto.setFuerza(String.valueOf(heroe.getFuerza()));
        dto.setAgilidad(String.valueOf(heroe.getAgilidad()));
        dto.setVida(String.valueOf(heroe.getVida()));
        dto.setMana(String.valueOf(heroe.getMana()));
        dto.setHistoria(heroe.getHistoria());

        return dto;
    }
}