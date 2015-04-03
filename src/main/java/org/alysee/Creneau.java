/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee;

import javax.persistence.*;

/**
 * Classe métier Creneau : contenant les attributs : id, version, heure de debut et de fin, minutes de debue et de fin et l'id d'un médecin
 *
 * Utilisation d'entitées JPA : @Entity, @Table, @Id, @GeneratedValue, @Column, @ManyToOne et @JoinColumn
 *
 * @author Alysee
 */

//@Entity : Classe qui a une table correspondante en base de données
@Entity
//@Table : Pour dire avec quelle table de ma base on va lier cette classe
@Table(name="creneaux")
public class Creneau {

    @Id // Id est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Valeur non défini par nous, c'est la base de données qui l'a génère
    private long id;
    private int version;
    //@Column : pour dire que la colonne dans la table se nomme 'HDEBUT', car dans mes attributs je ne l'ai pas nommée pareille
    @Column(name="HDEBUT")
    private int heuredeb;
    @Column(name="HFIN")
    private int heurefin;
    @Column(name="MDEBUT")
    private int minutedeb;
    @Column(name="MFIN")
    private int minutefin;
    //@ManyToOne  : Pour dire qu'une clé étrangère sera remplacée par un objet du type de la table
    @ManyToOne
    @JoinColumn(name="ID_MEDECIN") // Pour dire dans quelle colonne se trouve la clé étrangère
    private Medecin medecin;


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

    public int getHeuredeb() {
        return heuredeb;
    }

    public void setHeuredeb(int heuredeb) {
        this.heuredeb = heuredeb;
    }

    public int getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(int heurefin) {
        this.heurefin = heurefin;
    }

    public int getMinutedeb() {
        return minutedeb;
    }

    public void setMinutedeb(int minutedeb) {
        this.minutedeb = minutedeb;
    }

    public int getMinutefin() {
        return minutefin;
    }

    public void setMinutefin(int minutefin) {
        this.minutefin = minutefin;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }


    //Constructeur vide
    public Creneau() {
    }


    /*
        Constructeur sans l'id
    */
    public Creneau(int version, int heuredeb, int minutedeb, int heurefin, int minutefin, Medecin medecin) {
        this.version = version;
        this.heuredeb = heuredeb;
        this.heurefin = heurefin;
        this.minutedeb = minutedeb;
        this.minutefin = minutefin;
        this.medecin = medecin;
    }
    

    
}
