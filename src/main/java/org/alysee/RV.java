/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe métier RV(Rendez-vous) : contenant les attributs : id, jour, client, id_Creneau pour un rv
 *
 * Utilisation d'entitées JPA : @Entity, @Table, @Id, @GeneratedValue, @Column, @ManyToOne et @JoinColumn
 *
 * @author Alysee
 */

//@Entity : Classe qui a une table correspondante en base de données
@Entity
////@Table : Pour dire avec quelle table de ma base on va lier cette classe
@Table(name="rv")
public class RV {

    @Id // Id est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Valeur non défini par nous, c'est la base de données qui l'a génère
    private long id;
    private Date jour;
    //@ManyToOne  : Pour dire qu'une clé étrangère sera remplacée par un objet du type de la table
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")// Pour dire dans quelle colonne se trouve la clé étrangère
    private Client client;
    @ManyToOne
    @JoinColumn(name = "ID_CRENEAU")
    private Creneau creneau;


    /*
        Ascesseurs des attributs
     */
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client id_Client) {
        this.client = id_Client;
    }

    public Creneau getCreneaux() {
        return creneau;
    }

    public void setCreneaux(Creneau id_Creneaux) {
        this.creneau = id_Creneaux;
    }


    //Constructeur vide
    public RV() {
    }

    /*
        Constructeur sans l'id
    */
    public RV(Date jour, Client client, Creneau creneau) {
        this.jour = jour;
        this.client = client;
        this.creneau = creneau;
    }

}
