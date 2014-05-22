
package co.edu.uniandes.csw.item.logic.api;

import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import java.util.List;

public interface IItemLogicService extends _IItemLogicService {

    public int cantidadItemProducto(Long idProducto);
    public Boolean deleteItemProductsByNumber(Long id, Integer num);
    public List<ItemDTO> getListaItemPorIdProducto(Long idProducto);
}