
package co.edu.uniandes.csw.item.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.item.logic.api.IItemLogicService;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import java.util.ArrayList;
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
    public List<ItemDTO> getListaItemPorIdProducto(Long idProducto)
    {
        List<ItemDTO> lista = super.getItems();
        
        List<ItemDTO> rta = new ArrayList<ItemDTO>();
        
        for(int i=0; i<lista.size(); i++)
        {
            ItemDTO temp = lista.get(i);
            if(temp.getProductoaId().equals(idProducto))
                rta.add(temp);
        }
        
        return rta;
    }
    
     public Boolean deleteItemProductsByNumber(Long id, Integer num){
        
        List<ItemDTO> lista =getListaItemPorIdProducto(id);
        
        Integer inter = 0;
        /*for(int i=0;i<lista.size();i++)
        {
            inter = inter + lista.get(i).getCantidadItem();
        }*/
        inter = num;
        
        //Integer inter = Integer.parseInt(getAmmountProduct(id))-num;
        System.out.println("inter es : "+inter);
        if(inter<0)
            return false;
        else
        {
            //List<ItemDTO> lista = super.productoMasterPersistance.getItemListForProducto(id);
            for(int i=0;i<lista.size();i++)
            {
                for(int j=i+1;j<lista.size();j++)
                {
                    if(lista.get(j).getFechaExpiracion().compareTo(lista.get(i).getFechaExpiracion())<0)
                    {
                        ItemDTO temp = lista.get(i);
                        lista.set(i, lista.get(j));
                        lista.set(j, temp);
                    }
                }
            }
            
            boolean rta = false;
            for(int i=0;i<lista.size()&&!rta;i++)
            {
                if(inter==0)
                    rta=true;
                else
                {
                    //System.out.println(i+"..............."+lista.get(i).getCantidadItem());
                    if(inter>=lista.get(i).getCantidadItem())
                    {
                        /*inter = inter - lista.get(i).getCantidadItem();
                        //super.productoMasterPersistance.deleteProductoItem(id, lista.get(i).getId());
                        
                        itemPersistance.deleteItem(lista.get(i).getId());*/
                        
                        inter = inter - lista.get(i).getCantidadItem();
                        lista.get(i).setCantidadItem(0);
                       // super.persistance.updateItem(lista.get(i));
                        
                    }
                    else
                    {
                        lista.get(i).setCantidadItem(lista.get(i).getCantidadItem()-inter);
                        inter = 0;
                      //  super.persistance.deleteItem(lista.get(i).getId());
                    }
                    
                }
            }
            return rta;
        }
    }
}