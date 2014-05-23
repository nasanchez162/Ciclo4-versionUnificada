package co.edu.uniandes.csw.item.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Item")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemService extends _ItemService {

    @GET
    @Path("{id}/getCantidadItems")
    public int getCantidadItems(@PathParam("id") Long id){
        return itemLogicService.cantidadItemProducto(id);
    }
    
    @GET
    @Path("{id}/{num}/deleteItemProductsByNumber")
    public Boolean deleteItemProductsByNumber(@PathParam("id") Long id, @PathParam("num") Integer num){
        return itemLogicService.deleteItemProductsByNumber(id,num);
    }
    
    
}