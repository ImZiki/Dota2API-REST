package com.es.dota2api.dto;

import com.es.dota2api.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDetailsDTO {
    private String username;
    private String password;
    private Roles rol;
    private String token;
}
