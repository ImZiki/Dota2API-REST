package com.es.dota2api.controller;

import com.es.dota2api.dto.ObjetoDTO;
import com.es.dota2api.error.exception.ObjectNotFoundException;
import com.es.dota2api.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetos")
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    // Endpoint GET para obtener todos los objetos
    @GetMapping("/")
    public ResponseEntity<?> getAllObjects() {
        List<ObjetoDTO> objetos = objetoService.getAllObjects();
        return new ResponseEntity<>(objetos, HttpStatus.OK);
    }

    // Endpoint GET para obtener un objeto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getObjectById(@PathVariable String id) {
        ObjetoDTO objeto = objetoService.getObjectById(id);
        if (objeto == null) throw new ObjectNotFoundException("Heroe no encontrado");
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    // Endpoint POST para crear un nuevo objeto
    @PostMapping("/")
    public ResponseEntity<?> createObject(@RequestBody ObjetoDTO objetoDTO) {
        return new ResponseEntity<>(objetoService.createObject(objetoDTO), HttpStatus.CREATED);
    }

    // Endpoint PUT para actualizar un objeto existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateObject(@PathVariable String id, @RequestBody ObjetoDTO objetoDTO) {
        if (objetoDTO == null) throw new IllegalArgumentException("Objeto nulo");
        return new ResponseEntity<>(objetoService.updateObject(id, objetoDTO), HttpStatus.OK);
    }

    // Endpoint DELETE para eliminar un objeto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObject(@PathVariable String id) {
        if(id == null || id.isEmpty()) throw new IllegalArgumentException("ID nulo");
        objetoService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
