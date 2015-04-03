package org.alysee.api.rest;

import org.alysee.Client;
import org.alysee.Creneau;
import org.alysee.RV;
import org.alysee.dao.ClientDAO;
import org.alysee.dao.CreneauDAO;
import org.alysee.dao.RVDAO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Classe Web Service Rest pour les rv
 *
 * Created by Alysee
 */


// Chemin URL pour avoir accès au rv
@Path("/rv")
public class RVRestService {

    // Serveur d'application qui l'instancie ces variables
    @EJB
    RVDAO rvDAO;
    @EJB
    ClientDAO clientDAO;
    @EJB
    CreneauDAO creneauDAO;


    /**
     *  Récupération d'un rv par son id
     *  Path :  .../tp_jpa/rest/rv/id
     * @param id du rv
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public  Response getRVById (@PathParam("id") Long id) {

        RV rv;
        rv = this.rvDAO.trouverRVParID(id);

        return Response.status(Response.Status.OK).entity(rv).build();
    }


    /**
     * Récupération de tous les rv
     *  Path : .../tp_jpa/rest/rv/allRVs
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("/allRVs")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response allRVs () {

        List<RV> rvs = this.rvDAO.listeDesRV();

        return Response.status(Response.Status.OK).entity(rvs).build();
    }


    /**
     * Suppression d'un rv
     * Path :  .../tp_jpa/rest/rv/id
     * @param id
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteRV (@PathParam("id") Long id) {

        RV rv;
        rv = this.rvDAO.trouverRVParID(id);
        this.rvDAO.supprimerRV(rv);

        return Response.status(Response.Status.OK).build();
    }


    /**
     * Création d'un rv : on passe en Json un rv
     * Path :  .../tp_jpa/rest/rv/client_creneau/idDuclient/idDucreneau
     * @param rv
     * @param id_client
     * @param id_creneau
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("/client_creneau/{id_client}/{id_creneau}")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response createRV (RV rv,@PathParam("id_client")long id_client,@PathParam("id_creneau")long id_creneau) {

        Client client;
        client = clientDAO.trouverClientParID(id_client);

        Creneau creneau;
        creneau = creneauDAO.trouverCreneauParID(id_creneau);

        rv.setCreneaux(creneau);
        rv.setClient(client);

        rvDAO.insererRV(rv);

        return Response.status(Response.Status.OK).entity(rv).build();
    }

    /**
     * Modification d'un rv
     * Path :  .../tp_jpa/rest/rv/id
     * @param id
     * @param rv
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateRV(@PathParam("id") Long id, RV rv) {

        RV rv1;
        rv1 = this.rvDAO.trouverRVParID(id);
        rv1.setJour(rv.getJour());

        rvDAO.majRV(rv1);

        return Response.status(Response.Status.OK).entity(rv1).build();

    }



}
