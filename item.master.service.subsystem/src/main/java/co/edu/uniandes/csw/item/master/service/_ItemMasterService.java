package co.edu.uniandes.csw.item.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.item.master.logic.api.IItemMasterLogicService;
import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;

public abstract class _ItemMasterService {

    @Inject
    protected IItemMasterLogicService itemLogicService;

    @POST
    public ItemMasterDTO createItem(ItemMasterDTO item) {
        return itemLogicService.createMasterItem(item);
    }

    @DELETE
    @Path("{id}")
    public void deleteItem(@PathParam("id") Long id) {
        itemLogicService.deleteMasterItem(id);
    }
    
    @GET
    @Path("{id}")
    public ItemMasterDTO getItem(@PathParam("id") Long id) {
        return itemLogicService.getMasterItem(id);
    }

    @PUT
    @Path("{id}")
    public void updateItem(@PathParam("id") Long id, ItemMasterDTO item) {
        itemLogicService.updateMasterItem(item);
    }

}
