
package co.edu.uniandes.csw.item.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.item.logic.api.IItemLogicService;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import java.util.List;

@Default
@Stateless
@LocalBean
public class ItemLogicService extends _ItemLogicService implements IItemLogicService {

    public int cantidadItemProducto(Long idProducto)
    {
        List<ItemDTO> lista = super.getItems();
        
        int rta = 0;
        
        for(int i=0; i<lista.size(); i++)
        {
            ItemDTO temp = lista.get(i);
            if(temp.getProductoaId().equals(idProducto))
                rta += temp.getCantidadItem();
        }
        
        return rta;
    }
}