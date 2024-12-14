package com.es.dota2api.service;


import com.es.dota2api.dto.HeroeDTO;
import com.es.dota2api.error.exception.HeroNotFoundException;
import com.es.dota2api.model.Heroe;
import com.es.dota2api.repository.HeroeRepository;
import com.es.dota2api.util.HeroeMapper;
import com.es.dota2api.util.HeroeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    @Autowired
    private HeroeMapper heroeMapper;

    @Autowired
    private HeroeValidator heroeValidator;

    public List<HeroeDTO> getAllHeroes() {
        List<Heroe> heroes = heroeRepository.findAll();
        return heroes.stream()
                .map(HeroeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HeroeDTO getHeroById(String id) {
        Long idL = Long.parseLong(id);
        Optional<Heroe> heroe = heroeRepository.findById(idL);
        return heroe.map(HeroeMapper::toDTO)
                .orElseThrow(() -> new HeroNotFoundException("Heroe no encontrado"));
    }

    public HeroeDTO createHero(HeroeDTO heroeDTO) {
        Heroe heroe = HeroeMapper.toEntity(heroeDTO);
        heroeValidator.validateHeroe(heroe);
        heroeRepository.save(heroe);
        return HeroeMapper.toDTO(heroe);
    }

    public void deleteHero(String id) {
        Long idL = Long.parseLong(id);
        if (heroeRepository.existsById(idL)) {
            heroeRepository.deleteById(idL);
        } else {
            throw new HeroNotFoundException("Heroe no encontrado");
        }
    }

    public HeroeDTO updateHero(String id, HeroeDTO heroeDTO) {
        Long idL = Long.parseLong(id);
        Heroe heroeActualizado = heroeRepository.findById(idL)
                .map(existingHeroe -> {
                    Heroe updatedHeroe = HeroeMapper.toEntity(heroeDTO);
                    updatedHeroe.setId(existingHeroe.getId()); // Mantener el ID del héroe existente
                    return updatedHeroe;
                })
                .orElseThrow(() -> new HeroNotFoundException("Heroe no encontrado"));

        heroeValidator.validateHeroe(heroeActualizado);
        Heroe savedHeroe = heroeRepository.saveAndFlush(heroeActualizado);

        return HeroeMapper.toDTO(savedHeroe);
    }
}
