package com.es.dota2api.util;

import com.es.dota2api.dto.ObjetoDTO;
import com.es.dota2api.model.Objeto;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ObjetoMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // Mapeo de la entidad Objeto a ObjetoDTO
    ObjetoDTO objetoToObjetoDTO(Objeto objeto);

    // Mapeo de ObjetoDTO a la entidad Objeto
    Objeto objetoDTOToObjeto(ObjetoDTO objetoDTO);
}
