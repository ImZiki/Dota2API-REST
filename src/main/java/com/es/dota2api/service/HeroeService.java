package com.es.dota2api.service;


import com.es.dota2api.dto.HeroeDTO;
import com.es.dota2api.model.Heroe;
import com.es.dota2api.repository.HeroeRepository;
import com.es.dota2api.util.HeroeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    @Autowired
    private HeroeMapper heroeMapper;

    public List<HeroeDTO> getAllHeroes() {
        List<Heroe> heroes = new ArrayList<>(heroeRepository.findAll());
        return heroeMapper.heroesToHeroeDTOs(heroes);
    }

    public HeroeDTO getHeroById(String id) {
        Long idL = Long.parseLong(id);
        Optional<Heroe> heroe = heroeRepository.findById(idL);
        return heroeMapper.heroeToHeroeDTO(heroe);
    }

    public HeroeDTO createHero(HeroeDTO heroeDTO) {

    }
}
