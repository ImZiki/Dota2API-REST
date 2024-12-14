package com.es.dota2api.dto;

import com.es.dota2api.model.Roles;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {
    private String username;
    private String password;
    private Roles rol;
    private String token;

    public UsuarioDTO(String username, String password, Roles rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
