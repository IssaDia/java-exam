package com.ws.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="avis")
public class Avis {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name="dateEnvoi")
        @javax.validation.constraints.NotNull(message="Le champ date d'envoi ne peut pas être null")
        @DateTimeFormat(pattern="dd-mm-yyyy")
        @JsonFormat(pattern="yyyy-mm-dd")
        @Temporal(TemporalType.DATE)
        private Date dateEnvoi;

        @Basic
        @NotNull(message="Le champ ne peut pas être null")
        private String description;

        @Basic
        @NotNull(message="Le champ ne peut pas être null")
        private int note;

        @ManyToOne
        @JsonBackReference
        private Jeu jeu;

        public Avis () {

        }

    public Avis(Date dateEnvoi, String description, int note, Jeu jeu) {
        this.dateEnvoi = dateEnvoi;
        this.description = description;
        this.note = note;
        this.jeu = jeu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }
}
