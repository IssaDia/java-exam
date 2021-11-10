package com.ws.demo.controllers;

import com.ws.demo.models.Avis;
import com.ws.demo.models.Jeu;
import com.ws.demo.repositories.AvisRepository;
import com.ws.demo.repositories.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/jeux")
public class JeuController {
    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private AvisRepository avisRepository;


    @GetMapping(value="/")
    List<Jeu> all(){
        return jeuRepository.findAll();
    }

    @GetMapping(value="/{jeu}")
    Jeu getOne(@PathVariable(name="jeu",required = false) Jeu jeu){
        if(jeu == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Serie introuvable"
            );
        }
        else{
            return jeu;
        }
    }

    @PostMapping(value="/")
    public ResponseEntity<Jeu> saveJeu(@Valid @RequestBody Jeu jeu, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else {
            jeuRepository.save(jeu);
            return new ResponseEntity<Jeu>(jeu, HttpStatus.CREATED);
        }
    }

    @PutMapping(value="/{jeu}")
    public ResponseEntity<Jeu> update(@PathVariable(name="jeu",required = false) Jeu jeu,
                                        @Valid @RequestBody Jeu jeuUpdate, BindingResult bindingResult){
        if (jeu == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Jeu introuvable"
            );
        }
        else{
            jeuUpdate.setId(jeu.getId());
            jeuRepository.save(jeuUpdate);
            return new ResponseEntity<>(jeuUpdate, HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/{jeu}")
    public void deleteOne(@PathVariable(name="jeu", required = false) Jeu jeu){
        if(jeu == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Jeu introuvable"
            );
        }
        else{
            jeuRepository.delete(jeu);
        }
    }

    @GetMapping(value="/{jeu}/avis")
    public List<Avis> allAvis(@PathVariable(name="jeu",required = false) Jeu jeu) {
        if(jeu== null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie introuvable");

        }
        return avisRepository.findAllByJeu(jeu);

    }

    @PostMapping(value="/{jeu}/avis")
    public ResponseEntity<Jeu> saveAvis(@Valid @RequestBody Avis avis, Jeu jeu, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else {
            avis.setJeu(jeu);
            avisRepository.save(avis);
            return new ResponseEntity<Jeu>(jeu, HttpStatus.CREATED);
        }
    }

    @GetMapping(value="/{jeu}/dernierAvis")
    public List<Avis> lastAvis(@PathVariable(name="jeu",required = false) Jeu jeu) {
        if(jeu== null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie introuvable");

        }
        return avisRepository.findAllByJeu(jeu);

    }



}
