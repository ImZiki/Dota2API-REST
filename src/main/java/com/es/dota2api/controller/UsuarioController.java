package com.es.dota2api.controller;


import com.es.dota2api.dto.UsuarioLoginDTO;
import com.es.dota2api.dto.UsuarioRegisterDTO;
import com.es.dota2api.error.exception.InternalServerErrorException;

import com.es.dota2api.service.UsuarioService;
import com.es.dota2api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(
            @RequestBody UsuarioLoginDTO usuarioLoginDTO
    ) {


        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getUsername(), usuarioLoginDTO.getPassword())// modo de autenticación
            );
        } catch (Exception e) {
            throw new UsernameNotFoundException("Credenciales del usuario incorrectas");
        }
        String token = "";
        try {
            token = tokenService.generateToken(authentication);
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al generar el token de autenticación");
        }

        return token;

    }
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody UsuarioRegisterDTO usuarioRegisterDTO) {

        System.out.println(
                usuarioRegisterDTO.getPassword()
        );

        usuarioService.registerUser(usuarioRegisterDTO);

        return new ResponseEntity<>(usuarioRegisterDTO, HttpStatus.CREATED);

    }
}
