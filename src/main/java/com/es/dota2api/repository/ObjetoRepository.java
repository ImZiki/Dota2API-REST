package com.es.dota2api.repository;

import com.es.dota2api.model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Long> {
}
