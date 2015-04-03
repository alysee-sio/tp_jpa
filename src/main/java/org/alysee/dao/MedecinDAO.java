package org.alysee.dao;

import org.alysee.Medecin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe qui permet de Creer, Recuperer(Lire), Mettre à jour et Supprimer les Medecins
 *
 * Created by Alysee
 */

// Classe qui va être instanciée part le serveur d'application
@Stateless
public class MedecinDAO {
    // Donne accès à un entityManager connecté à la base
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    // .persist() Pour créer un médecin
    public Medecin insererMedecin(Medecin medecin){
        this.entityManager.persist(medecin);
        return medecin;
    }

    // .merge() Pour mettre à jour un medecin
    public Medecin majMedecin(Medecin medecin){
        medecin = this.entityManager.merge(medecin);
        return medecin;
    }

    //.remove() Pour supprimer un medecin
    public void supprimerMedecin(Medecin medecin){
        medecin = entityManager.merge(medecin);
        this.entityManager.remove(medecin);
    }

    //.find() Pour récuperer un medecin par son ID
    public Medecin trouverMedecinParID(long id){
        Medecin medecin = this.entityManager.find(Medecin.class, id);
        return medecin;
    }

    //.createQuery() Pour avoir la liste de tous les medecins
    public List<Medecin> listeDesMedecins(){
        Query query = this.entityManager.createQuery("SELECT e FROM Medecin e");
        return (List<Medecin>)query.getResultList();
    }



}
