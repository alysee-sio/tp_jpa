package org.alysee.api.rest;

import org.alysee.Medecin;
import org.alysee.dao.MedecinDAO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Classe Web Service Rest pour les medecins
 *
 * Created by Alysee
 */

// Chemin URL pour avoir accès au médecin
@Path("/medecin")
public class MedecinRestService {

    // Serveur d'application qui l'instancie cette variable
    @EJB
    MedecinDAO medecinDAO;


    /**
     *  Récupération d'un médecin par son id
     *  Path :  .../tp_jpa/rest/medecin/id
     * @param id du médecin
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public  Response getMedecinById (@PathParam("id") Long id) {

        Medecin medecin;
        medecin = this.medecinDAO.trouverMedecinParID(id);

        return Response.status(Response.Status.OK).entity(medecin).build();
    }

    /**
     * Récupération de tous les médecins
     *  Path : .../tp_jpa/rest/medecin/allMedecins
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("/allMedecins")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response allMedecins () {

        List<Medecin> medecins = this.medecinDAO.listeDesMedecins();

        return Response.status(Response.Status.OK).entity(medecins).build();
    }

    /**
     * Suppression d'un médecin
     * Path :  .../tp_jpa/rest/medecin/id
     * @param id
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteMedecin (@PathParam("id") Long id) {

        Medecin medecin;
        medecin = this.medecinDAO.trouverMedecinParID(id);
        this.medecinDAO.supprimerMedecin(medecin);

        return Response.status(Response.Status.OK).build();
    }

    /**
     * Création d'un médecin : on passe en Json un médecin
     * Path :  .../tp_jpa/rest/medecin
     * @param medecin
     * @return une Response "OK" si tout c'est bien passé
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response createMedecin (Medecin medecin) {

        medecinDAO.insererMedecin(medecin);

        return Response.status(Response.Status.OK).entity(medecin).build();
    }

    /**
     * Modification d'un médecin
     * Path :  .../tp_jpa/rest/medecin/id
     * @param id
     * @param medecin
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateMedecin(@PathParam("id") Long id, Medecin medecin) {

        Medecin medecin1;
        medecin1 = this.medecinDAO.trouverMedecinParID(id);
        medecin1.setVersion(medecin.getVersion());
        medecin1.setNom(medecin.getNom());
        medecin1.setPrenom(medecin.getPrenom());
        medecin1.setTitre(medecin.getTitre());

        medecinDAO.majMedecin(medecin1);

        return Response.status(Response.Status.OK).entity(medecin1).build();

    }
}
