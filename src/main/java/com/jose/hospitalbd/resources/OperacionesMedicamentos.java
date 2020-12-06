/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.hospitalbd.resources;


import com.jose.hospitalbd.ejb.MedicamentoFacade;
import com.jose.hospitalbd.entity.Medicamentos;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose Luis
 */
//@RolesAllowed("admin")
@Path("medicamentos")
public class OperacionesMedicamentos {
    
    @Inject
    MedicamentoFacade medicamentoFacade;
    
    
    //crear medicamento
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crearmedicamento")
    public Response crearcomputadora(Medicamentos medicamento)
    {
        medicamentoFacade.create(medicamento);
        return Response
                .ok()
                .build();
    }
    //obtener medicamentos todos
    //@RolesAllowed("admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenermedicamentos")
    public List<Medicamentos> buscarmedicamentos()
    {   
       //List<Medicamentos> cp=medicamentoFacade.findAll();
        List<Medicamentos> cp=medicamentoFacade.medicamentos();
       return cp;
    }
    //obtener un solo medicamento
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenermedicamento/{id}")
    public Medicamentos buscarmedicamento(@PathParam(value="id") String id)
    {   
       Medicamentos cp=medicamentoFacade.un_medicamento(id);
       return cp;
    }*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenermedicamento/{id}")
    public Medicamentos buscarmedicamento(@PathParam(value="id")String id)
    {  
        //String i="2";
       Medicamentos cp=medicamentoFacade.un_medicamento(id);
       return cp;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actualizarmedicamento")
    public Response actualizarmedicamento(Medicamentos medicamentos)
    {   
      medicamentoFacade.actualizar(medicamentos);
       return Response
                .ok()
                .build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarrmedicamento")
    public Response eliminarmedicamento(@QueryParam(value="id")String id)
    {  
       medicamentoFacade.elimina(id);
       return Response
                .ok()
                .build();
    }
}

