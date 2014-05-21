
package co.edu.uniandes.csw.item.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.item.logic.api.IItemLogicService;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import java.util.List;

@Alternative
@Singleton
public class ItemMockLogicService extends _ItemMockLogicService implements IItemLogicService {
	
    
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