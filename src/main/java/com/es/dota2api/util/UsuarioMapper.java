package com.es.dota2api.util;

import com.es.dota2api.dto.UsuarioRegisterDTO;
import com.es.dota2api.dto.UsuarioLoginDTO;
import com.es.dota2api.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
 public class UsuarioMapper {

     // Método para mapear de UsuarioRegisterDTO a Usuario
     public Usuario toEntity(UsuarioRegisterDTO dto) {
         if (dto == null) throw new NullPointerException("Usuario nulo");

         Usuario usuario = new Usuario();
         usuario.setUsername(dto.getUsername());
         usuario.setPassword(dto.getPassword());
         usuario.setRol(dto.getRol());

         return usuario;
     }


     // Método para mapear de Usuario a UsuarioLoginDTO
     public UsuarioLoginDTO toLoginDTO(Usuario usuario) {
         if (usuario == null) throw new NullPointerException("Usuario nulo");

         UsuarioLoginDTO dto = new UsuarioLoginDTO();
         dto.setUsername(usuario.getUsername());
         dto.setPassword(usuario.getPassword());

         return dto;
     }
     // Método para mapear de Usuario a UsuarioLoginDTO
     public UsuarioRegisterDTO toRegisterDTO(Usuario usuario) {
         if (usuario == null) throw new NullPointerException("Usuario nulo");

         UsuarioRegisterDTO dto = new UsuarioRegisterDTO();
         dto.setUsername(usuario.getUsername());
         dto.setPassword(usuario.getPassword());

         return dto;
     }
 }