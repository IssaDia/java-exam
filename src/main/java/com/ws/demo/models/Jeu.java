package com.ws.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="jeu")
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name="nom")
    @NotNull(message="Le champ nom ne peut pas être null")
    @NotBlank(message="Le champ nom ne peut pas être vide")
    private String nom;

    @Column(name="description")
    @NotNull(message="Le champ nom ne peut pas être null")
    @NotBlank(message="Le champ nom ne peut pas être vide")
    private String description;

    @Column(name="dateSortie")
    @javax.validation.constraints.NotNull(message="Le champ date de sortie ne peuut pas être null")
    @DateTimeFormat(pattern="dd-mm-yyyy")
    @JsonFormat(pattern="yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date dateSortie;

    @OneToMany(mappedBy="jeu", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Avis> avis;

    public Jeu() {
        avis = new ArrayList<>();
    }

    public Jeu(String nom, String description, Date dateSortie, List<Avis> avis) {
        this.nom = nom;
        this.description = description;
        this.dateSortie = dateSortie;
        this.avis = avis;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }
}
