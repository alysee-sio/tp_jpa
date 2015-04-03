package org.alysee.dao;

import org.alysee.RV;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe qui permet de Creer, Recuperer(Lire), Mettre à jour et Supprimer les RV
 *
 * Created by Alysee
 */

// Classe qui va être instanciée part le serveur d'application
@Stateless
public class RVDAO {
    // Donne accès à un entityManager connecté à la base
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    // .persist() Pour créer un rv
    public RV insererRV(RV rv){
        this.entityManager.persist(rv);
        return rv;
    }

    // .merge() Pour mettre à jour un rv
    public RV majRV(RV rv){
        rv = this.entityManager.merge(rv);
        return rv;
    }

    //.remove() Pour supprimer un rv
    public void supprimerRV(RV rv){
        rv = entityManager.merge(rv);
        this.entityManager.remove(rv);
    }

    //.find() Pour récuperer un rv par son ID
    public RV trouverRVParID(long id){
        RV rv = this.entityManager.find(RV.class, id);
        return rv;
    }

    //.createQuery() Pour avoir la liste de tous les rv
    public List<RV> listeDesRV(){
        Query query = this.entityManager.createQuery("SELECT e FROM RV e");
        return (List<RV>)query.getResultList();
    }
}
