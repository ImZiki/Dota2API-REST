package com.es.dota2api.service;


import com.es.dota2api.repository.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

}
