package org.alysee.api.rest;


import org.alysee.Client;
import org.alysee.dao.ClientDAO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Classe Web Service Rest pour les clients
 *
 * Created by Alysee
 */

// Chemin URL pour avoir accès au client
@Path("/client")
public class ClientRestService {

    // Serveur d'application qui l'instancie cette variable
    @EJB
    ClientDAO clientDAO;


    /**
     *  Récupération d'un client par son id
     *  Path :  .../tp_jpa/rest/client/id
     * @param id du client
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public  Response getClientById (@PathParam("id") Long id) {

        Client client;
        client = this.clientDAO.trouverClientParID(id);

        return Response.status(Response.Status.OK).entity(client).build();
    }


    /**
     * Récupération de tous les clients
     *  Path : .../tp_jpa/rest/client/allClients
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("/allClients")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response allClients () {

        List<Client> clients = this.clientDAO.listeDesClients();

        return Response.status(Response.Status.OK).entity(clients).build();
    }


    /**
     * Suppression d'un client
     * Path :  .../tp_jpa/rest/client/id
     * @param id
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteClient (@PathParam("id") Long id) {

        Client client;
        client = this.clientDAO.trouverClientParID(id);
        this.clientDAO.supprimerClient(client);

        return Response.status(Response.Status.OK).build();
    }


    /**
     * Création d'un client : on passe en Json un client
     * Path :  .../tp_jpa/rest/client
     * @param client
     * @return une Response "OK" si tout c'est bien passé
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response createClient (Client client) {

        clientDAO.insererClient(client);

        return Response.status(Response.Status.OK).entity(client).build();
    }

    /**
     * Modification d'un client
     * Path :  .../tp_jpa/rest/client/id
     * @param id
     * @param client
     * @return une Response "OK" si tout c'est bien passé
     */
    @Path("{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateClient(@PathParam("id") Long id, Client client) {

        Client client1;
        client1 = this.clientDAO.trouverClientParID(id);
        client1.setVersion(client.getVersion());
        client1.setNom(client.getNom());
        client1.setPrenom(client.getPrenom());
        client1.setTitre(client.getTitre());

        clientDAO.majClient(client1);

        return Response.status(Response.Status.OK).entity(client1).build();

    }



}
