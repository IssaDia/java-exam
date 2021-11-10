package com.ws.demo.controllers;

import com.ws.demo.models.Avis;
import com.ws.demo.models.Jeu;
import com.ws.demo.repositories.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/avis")
public class AvisController {
    @Autowired
    private AvisRepository avisRepository;

    @DeleteMapping(value="/{avis}")
    public void deleteOne(@PathVariable(name="avis", required = false) Avis avis){
        if(avis == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Jeu introuvable"
            );
        }
        else{
            avisRepository.delete(avis);
        }
    }

}
