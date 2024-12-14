package com.es.dota2api.dto;



import com.es.dota2api.model.Roles;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class UsuarioRegisterDTO {
    private String username;
    private String password;
    private Roles rol;

    public UsuarioRegisterDTO() {

    }
}
