package com.es.dota2api.dto;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class UsuarioRegisterDTO {
    private String username;
    private String password;
    private String rol;
}
