package co.edu.uniandes.csw.producto.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Producto")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoService extends _ProductoService {


    @GET
    @Path("{id}/getCantidadItems")
    public int getCantidadItems(@PathParam("id") Long id){
        return productoLogicService.getCantidadItems(id);
    }
}