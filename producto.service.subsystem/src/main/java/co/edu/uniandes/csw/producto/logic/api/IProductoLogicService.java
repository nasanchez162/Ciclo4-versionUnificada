
package co.edu.uniandes.csw.producto.logic.api;

public interface IProductoLogicService extends _IProductoLogicService {
    
    public int getCantidadItems(Long idProducto);

    public String listarProductos();

}