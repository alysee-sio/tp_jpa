package org.alysee.api.rest;

import org.alysee.Creneau;
import org.alysee.Medecin;
import org.alysee.dao.CreneauDAO;
import org.alysee.dao.MedecinDAO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Classe Web Service Rest pour les creneaux
 *
 * Created by Alysee
 */

// Chemin URL pour avoir accès au creneau
@Path("/creneau")
public class CreneauRestService {

    // Serveur d'application qui l'instancie ces variables
    @EJB
    CreneauDAO creneauDAO;
    @EJB
    MedecinDAO medecinDAO;


    /**
     *  Récupération d'un creneau par son id
     *  Path :  .../tp_jpa/rest/creneau/id
     * @param id du creneau
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public  Response getCreneauById (@PathParam("id") Long id) {

        Creneau creneau;
        creneau = this.creneauDAO.trouverCreneauParID(id);

        return Response.status(Response.Status.OK).entity(creneau).build();
    }


    /**
     * Récupération de tous les creneaux
     *  Path : .../tp_jpa/rest/creneau/allCreneaux
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("/allCreneaux")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response allCreneaux () {

        List<Creneau> creneaux = this.creneauDAO.listeDesCreneaux();

        return Response.status(Response.Status.OK).entity(creneaux).build();
    }



    /**
     * Suppression d'un creneau
     * Path :  .../tp_jpa/rest/creneau/id
     * @param id
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCreneau (@PathParam("id") Long id) {

        Creneau creneau;
        creneau = this.creneauDAO.trouverCreneauParID(id);
        this.creneauDAO.supprimerCreneau(creneau);

        return Response.status(Response.Status.OK).build();
    }


    /**
     * Création d'un creneau : on passe en Json un creneau
     * Path :  .../tp_jpa/rest/creneau
     * @param creneau
     * @param idMedecin
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("/medecin/{id}")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response createCreneau (Creneau creneau, @PathParam("id")long idMedecin) {

        Medecin medecin;
        medecin = medecinDAO.trouverMedecinParID(idMedecin);

        creneau.setMedecin(medecin);
        creneauDAO.insererCreneau(creneau);

        return Response.status(Response.Status.OK).entity(creneau).build();
    }



    /**
     * Modification d'un creneau
     * Path :  .../tp_jpa/rest/creneau/id
     * @param id
     * @param creneau
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateCreneau(@PathParam("id") Long id, Creneau creneau) {

        Creneau creneau1;
        creneau1 = this.creneauDAO.trouverCreneauParID(id);
        creneau1.setHeuredeb(creneau.getHeuredeb());
        creneau1.setHeurefin(creneau.getHeurefin());
        creneau1.setMinutedeb(creneau.getMinutedeb());
        creneau1.setMinutefin(creneau.getMinutefin());

        creneauDAO.majCreneau(creneau1);

        return Response.status(Response.Status.OK).entity(creneau1).build();

    }


    
}
