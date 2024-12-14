package com.es.dota2api.util;



import com.es.dota2api.dto.HeroeDTO;
import com.es.dota2api.model.Heroe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface HeroeMapper {

    HeroeMapper INSTANCE = Mappers.getMapper(HeroeMapper.class);

    // Mapeo de la entidad Heroe a HeroeDTO
    HeroeDTO heroeToHeroeDTO(Optional<Heroe> heroe);

    // Mapeo de HeroeDTO a la entidad Heroe
    Heroe heroeDTOToHeroe(HeroeDTO heroeDTO);

    List<HeroeDTO> heroesToHeroeDTOs(List<Heroe> heroes);
}
