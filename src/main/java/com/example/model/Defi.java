package com.example.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "defi")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Defi { 

    @Id
    @Column(name = "id", nullable = false,updatable = true)
    private String id;

    @Column(name = "titre",nullable = false, updatable = true, insertable = true)
    private String titre;

    @Column(name = "description",nullable = true, updatable = true,insertable = true)
    private String description;

    @Column(name = "datedecreation",nullable = true, updatable = true,insertable = true)
    private Date dateDeCreation;

    @Column(name = "moyennevaluation",nullable = true, updatable = true,insertable = true)
    private Double moyenneEvaluation ;

    @ManyToOne()
    private Arret arret;

    @OneToMany(mappedBy = "defi",cascade = CascadeType.ALL)
    private List<Etape> EtapeDunDefi;
    
    @ManyToOne()
    private Chami auteur;
 
    @OneToMany(mappedBy = "defiVisite",cascade = CascadeType.ALL)
    private List<Visite> visite;

    public List<Etape> getEtapeDunDefi() {
        return EtapeDunDefi;
    }


    public void setEtapeDunDefi(List<Etape> etapeDunDefi) {
        EtapeDunDefi = etapeDunDefi;
    }


    public Arret getArret() {
        return arret;
    }


    public void setArret(Arret arret) {
        this.arret = arret;
    }


    public Defi(){}


    public Double getMoyenneEvaluation() {
        return moyenneEvaluation;
    }

    public void setMoyenneEvaluation(Double moyenneEvaluation) {
        this.moyenneEvaluation = moyenneEvaluation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Chami getAuteur() {
        return auteur;
    }

    public void setAuteur(Chami auteur) {
        this.auteur = auteur;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }


    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Visite> getVisite() {
        return visite;
    }


    public void setVisite(List<Visite> visite) {
        this.visite = visite;
    }






}