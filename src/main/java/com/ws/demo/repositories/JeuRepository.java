package com.ws.demo.repositories;

import com.ws.demo.models.Jeu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JeuRepository extends CrudRepository<Jeu, Long> {
    @Override
    List<Jeu> findAll();
}
