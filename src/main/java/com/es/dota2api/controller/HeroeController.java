package com.es.dota2api.controller;


import com.es.dota2api.dto.HeroeDTO;
import com.es.dota2api.error.exception.HeroNotFoundException;
import com.es.dota2api.model.Heroe;
import com.es.dota2api.service.HeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/heroes")
public class HeroeController {
    @Autowired
    private HeroeService heroeService;

    @GetMapping("/")
    public ResponseEntity<?> getAllHeroes() {
        List<HeroeDTO> heroes = heroeService.getAllHeroes();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

   // Obtener un héroe por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getHeroById(@PathVariable String id) {
        HeroeDTO heroe = heroeService.getHeroById(id);
        if (heroe == null) throw new HeroNotFoundException("Heroe no encontrado");
        return new ResponseEntity<>(heroe, HttpStatus.OK);
    }

    // Crear un nuevo héroe
    @PostMapping("/")
    public ResponseEntity<?> createHero(@RequestBody HeroeDTO heroeDTO) {
        return new ResponseEntity<>(heroeService.createHero(heroeDTO), HttpStatus.CREATED);
    }

    // Actualizar un héroe existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateHero(@PathVariable String id, @RequestBody HeroeDTO heroeDTO) {
        if (heroeDTO == null) throw new IllegalArgumentException("Heroe nulo");

        return new ResponseEntity<>(heroeService.updateHero(id , heroeDTO), HttpStatus.OK);
    }

    // Eliminar un héroe por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHero(@PathVariable String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("ID nulo");
        heroeService.deleteHero(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
