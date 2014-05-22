
package co.edu.uniandes.csw.item.logic.api;

public interface IItemLogicService extends _IItemLogicService {

    public int cantidadItemProducto(Long idProducto);
     public Boolean deleteItemProductsByNumber(Long id, Integer num);
}