/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoFazenda;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Fabiano
 */
@Path("fundoagricola")
public class FundoAgricolaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public FundoAgricolaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        DaoFazenda daoFazenda = new DaoFazenda();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(daoFazenda.listar());
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}