package com.es.dota2api.service;

import com.es.dota2api.dto.UsuarioDTO;
import com.es.dota2api.dto.UsuarioRegisterDTO;
import com.es.dota2api.error.exception.ResourceAlreadyExistsException;
import com.es.dota2api.model.Roles;
import com.es.dota2api.model.Usuario;
import com.es.dota2api.repository.UsuarioRepository;
import com.es.dota2api.util.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper usuarioMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario No encontrado"));


        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name());
        List<GrantedAuthority> authorities = Collections.singletonList(authority);


        UserDetails userDetails = User // User pertenece a SpringSecurity
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol().name())
                .build();

        return userDetails;
    }

    /**
     * Método para registrar un nuevo Usuario en la BDD
     *
     * @param usuarioRegisterDTO
     * @return
     */
    public UsuarioRegisterDTO registerUser(UsuarioRegisterDTO usuarioRegisterDTO) {

        if (usuarioRepository.findByUsername(usuarioRegisterDTO.getUsername()).isPresent()) {
            throw new ResourceAlreadyExistsException("El nombre de usuario ya existe");
        }


        Usuario nuevoUsuario = new Usuario();


        nuevoUsuario.setPassword(passwordEncoder.encode(usuarioRegisterDTO.getPassword())); // Hashear la contraseña
        nuevoUsuario.setUsername(usuarioRegisterDTO.getUsername());
        nuevoUsuario.setRol(Roles.valueOf(usuarioRegisterDTO.getRol()));


        usuarioRepository.save(nuevoUsuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioRegisterDTO(nuevoUsuario);
    }

    public UsuarioDTO findByNombre(String nombre) {

        Usuario u = usuarioRepository
                .findByUsername(nombre)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con nombre " + nombre + " no encontrado"));

        return usuarioMapper.usuarioToUsuarioDTO(u);

    }
}