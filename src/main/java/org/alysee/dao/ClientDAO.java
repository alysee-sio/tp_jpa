package org.alysee.dao;

import org.alysee.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe qui permet de Creer, Recuperer(Lire), Mettre à jour et Supprimer les Clients
 *
 * Created by Alysee
 */

// Classe qui va être instanciée part le serveur d'application
@Stateless
public class ClientDAO {
    // Donne accès à un entityManager connecté à la base
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;


    // .persist() Pour créer un client
    public Client insererClient(Client client) {
        this.entityManager.persist(client);
        return client;
    }

    //.merge() Pour mettre à jour un client
    public Client majClient(Client client) {
        client = this.entityManager.merge(client);
        return client;
    }

    //.remove() Pour supprimer un client
    public void supprimerClient(Client client) {
        client = this.entityManager.merge(client);
        this.entityManager.remove(client);
    }

    //.find() Pour récuperer un client par son ID
    public Client trouverClientParID(long id) {
        Client client = this.entityManager.find(Client.class, id);
        return client;
    }

    //.createQuery() Pour avoir la liste de tous les clients
    public List<Client> listeDesClients(){
        Query query = this.entityManager.createQuery("SELECT e FROM Client e");
        return (List<Client>)query.getResultList();
    }
}