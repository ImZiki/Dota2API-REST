package com.es.dota2api.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name= "roles")
    private Roles rol;

    public Usuario(String username, String password, Roles rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
