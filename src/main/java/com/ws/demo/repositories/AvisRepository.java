package com.ws.demo.repositories;

import com.ws.demo.models.Avis;
import com.ws.demo.models.Jeu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends CrudRepository<Avis, Long> {
    List<Avis> findAllByJeu(Jeu jeu);
    List<Avis> findTopByJeuOrderByDateEnvoiDesc(Jeu jeu);
}
