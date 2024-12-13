package com.es.dota2api.service;

import com.es.dota2api.repository.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoService {
    @Autowired
    private ObjetoRepository objetoRepository;
}
