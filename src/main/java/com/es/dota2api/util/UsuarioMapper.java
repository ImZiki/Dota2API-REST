 package com.es.dota2api.util;

import com.es.dota2api.dto.UsuarioDTO;
import com.es.dota2api.dto.UsuarioRegisterDTO;
import com.es.dota2api.dto.UsuarioLoginDTO;
import com.es.dota2api.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // Instancia del mapper
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    // Mapeo de la entidad Usuario a UsuarioDTO
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    // Mapeo de UsuarioDTO a la entidad Usuario
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
    // Mapea Usuario a UsuarioRegisterDTO
    @Mapping(target = "password", source = "password") // Mapea directamente el campo de la entidad a DTO
    UsuarioRegisterDTO usuarioToUsuarioRegisterDTO(Usuario usuario);

    // Mapea Usuario a UsuarioLoginDTO
    @Mapping(target = "password", source = "password")
    UsuarioLoginDTO usuarioToUsuarioLoginDTO(Usuario usuario);

    // Mapea UsuarioRegisterDTO a Usuario (para registro)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "rol", source = "rol")
    Usuario usuarioRegisterDTOToUsuario(UsuarioRegisterDTO usuarioRegisterDTO);

    // Mapea UsuarioLoginDTO a Usuario (para login)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    Usuario usuarioLoginDTOToUsuario(UsuarioLoginDTO usuarioLoginDTO);
}
