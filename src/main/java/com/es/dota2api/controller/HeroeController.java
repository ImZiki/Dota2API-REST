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

    @GetMapping
    public ResponseEntity<?> getAllHeroes() {
        List<HeroeDTO> heroes = heroeService.getAllHeroes();
        return ResponseEntity.ok(heroes);
    }

   // Obtener un héroe por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getHeroById(@PathVariable String id) {
        HeroeDTO heroe = heroeService.getHeroById(id);
        if (heroe == null) throw new HeroNotFoundException("Heroe no encontrado");
        return ResponseEntity.ok(heroe);
    }

    // Crear un nuevo héroe
    @PostMapping("/")
    public ResponseEntity<?> createHero(@RequestBody HeroeDTO heroeDTO) {
        Heroe nuevoHeroe = mapper.;
        return ResponseEntity.status(HttpStatus.CREATED).body(heroeDTO);
    }

    // Actualizar un héroe existente
    @PutMapping("/{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        Hero updatedHero = heroService.updateHero(id, hero);
        if (updatedHero == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedHero);
    }

    // Eliminar un héroe por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHero(@PathVariable Long id) {
        boolean isDeleted = heroService.deleteHero(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }*/

}
