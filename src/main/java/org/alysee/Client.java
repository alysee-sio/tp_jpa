/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee;

import javax.persistence.*;

/**
 * Classe métier Client : contenant les attributs : id, version, titre, nom et prénom pour un client
 *
 * Utilisation d'entitées JPA : @Entity, @Table, @Id et @GeneratedValue
 *
 * @author Alysee
 */

//@Entity : Classe qui a une table correspondante en base de données
@Entity
//@Table : Pour dire avec quelle table de ma base on va lier cette classe
@Table(name="clients")
public class Client {
    
    @Id // Id est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valeur non défini par nous, c'est la base de données qui l'a génère
    private long id;
    private int version;
    private String titre;
    private String nom;
    private String prenom;


    /*
        Ascesseurs
    */
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    // Constructeur vide
    public Client() {
    }

    /*
        Constructeur sans l'id
    */
    public Client(int version, String titre, String nom, String prenom) {
        this.version = version;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
    }

}
