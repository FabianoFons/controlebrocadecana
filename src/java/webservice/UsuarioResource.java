/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import com.google.gson.reflect.*;
import dao.DaoUsuario;
import java.lang.reflect.Type;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Fabiano
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        DaoUsuario daoUsuario = new DaoUsuario();
        Gson gson = new Gson();
        return gson.toJson(daoUsuario.listar());
    }
    
    @POST
    @Path("/logar/{usuario}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarById(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
        DaoUsuario daoUsuario = new DaoUsuario();
        Gson gson = new Gson();
        if (daoUsuario.logar(usuario, senha) != null)
            return gson.toJson("sucesso");
        else
            return gson.toJson("falha");
    }    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}