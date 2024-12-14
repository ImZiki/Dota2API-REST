package com.es.dota2api.service;

import com.es.dota2api.dto.UsuarioRegisterDTO;
import com.es.dota2api.error.exception.ResourceAlreadyExistsException;
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

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol().name())
                .build();
    }

    public UsuarioRegisterDTO registerUser(UsuarioRegisterDTO usuarioRegisterDTO) {
        // Verificar si el nombre de usuario ya existe
        if (usuarioRepository.findByUsername(usuarioRegisterDTO.getUsername()).isPresent()) {
            throw new ResourceAlreadyExistsException("El nombre de usuario ya existe");
        }

        // Crear el nuevo usuario mapeado
        Usuario nuevoUsuario = usuarioMapper.toEntity(usuarioRegisterDTO); // Mapear DTO a entidad
        nuevoUsuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword())); // Hashear la contraseña

        // Guardar el nuevo usuario
        usuarioRepository.save(nuevoUsuario);

        // Devolver el DTO del nuevo usuario
        return usuarioMapper.toRegisterDTO(nuevoUsuario); // Mapear entidad a DTO
    }

    public UsuarioRegisterDTO findByNombre(String nombre) {
        Usuario usuario = usuarioRepository
                .findByUsername(nombre)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con nombre " + nombre + " no encontrado"));

        return usuarioMapper.toRegisterDTO(usuario); // Mapear entidad a DTO
    }
}
