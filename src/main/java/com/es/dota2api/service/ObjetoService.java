package com.es.dota2api.service;

import com.es.dota2api.dto.ObjetoDTO;
import com.es.dota2api.error.exception.ObjectNotFoundException;
import com.es.dota2api.model.Objeto;
import com.es.dota2api.repository.ObjetoRepository;
import com.es.dota2api.util.ObjetoMapper;
import com.es.dota2api.util.ObjetoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjetoService {

    @Autowired
    private ObjetoRepository objetoRepository;

    @Autowired
    private ObjetoValidator objetoValidator;

    public List<ObjetoDTO> getAllObjects() {
        List<Objeto> objetos = objetoRepository.findAll();
        return objetos.stream()
                .map(ObjetoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ObjetoDTO getObjectById(String id) {
        Long idL = Long.parseLong(id);
        Optional<Objeto> objeto = objetoRepository.findById(idL);
        return objeto.map(ObjetoMapper::toDTO)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado"));
    }

    public ObjetoDTO createObject(ObjetoDTO objetoDTO) {
        Objeto objeto = ObjetoMapper.toEntity(objetoDTO);
        objetoValidator.validateObjeto(objeto);
        objetoRepository.save(objeto);
        return ObjetoMapper.toDTO(objeto);
    }

    public void deleteObject(String id) {
        Long idL = Long.parseLong(id);
        if (objetoRepository.existsById(idL)) {
            objetoRepository.deleteById(idL);
        } else {
            throw new ObjectNotFoundException("Objeto no encontrado");
        }
    }

    public ObjetoDTO updateObject(String id, ObjetoDTO objetoDTO) {
        Long idL = Long.parseLong(id);
        Objeto objetoActualizado = ObjetoMapper.toEntity(objetoDTO);
        objetoRepository.findById(idL).orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado"));
        objetoValidator.validateObjeto(objetoActualizado);
        objetoRepository.saveAndFlush(objetoActualizado);

        return ObjetoMapper.toDTO(objetoActualizado);
    }
}
