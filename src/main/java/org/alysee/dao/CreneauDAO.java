package org.alysee.dao;

import org.alysee.Creneau;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe qui permet de Creer, Recuperer(Lire), Mettre à jour et Supprimer les Creneaux
 *
 * Created by Alysee
 */

// Classe qui va être instanciée part le serveur d'application
@Stateless
public class CreneauDAO {
    // Donne accès à un entityManager connecté à la base
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    // .persist() Pour créer un creneau
    public Creneau insererCreneau(Creneau creneau) {
        this.entityManager.persist(creneau);
        return creneau;
    }

    // .merge() Pour mettre à jour un creneau
    public Creneau majCreneau(Creneau creneau) {
        creneau = this.entityManager.merge(creneau);
        return creneau;
    }

    //.remove() Pour supprimer un creneau
    public void supprimerCreneau(Creneau creneau) {
        creneau = entityManager.merge(creneau);
        this.entityManager.remove(creneau);
    }

    //.find() Pour récuperer un creneau par son ID
    public Creneau trouverCreneauParID(long id) {
        Creneau creneau = this.entityManager.find(Creneau.class, id);
        return creneau;
    }

    //.createQuery() Pour avoir la liste de tous les creneaux
    public List<Creneau> listeDesCreneaux(){
        Query query = this.entityManager.createQuery("SELECT e FROM Creneau e");
        return (List<Creneau>)query.getResultList();
    }
}
