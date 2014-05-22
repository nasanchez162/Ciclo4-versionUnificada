package co.edu.uniandes.csw.item.master.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ItemMaster")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemMasterService extends _ItemMasterService {

    @GET
    @Path("{id}/{num}/aniadirDocumentoVenta")
    public void aniadirDocumentoVenta (@PathParam("id") Long idItem, @PathParam("num") int idCantidad)
    {
        System.out.println("Pasé por aquí");
        super.itemLogicService.aniadirDocumentoVenta(idItem, idCantidad);
    }

}
