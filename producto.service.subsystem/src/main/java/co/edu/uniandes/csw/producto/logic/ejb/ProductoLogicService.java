
package co.edu.uniandes.csw.producto.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.producto.logic.api.IProductoLogicService;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import java.util.List;

@Default
@Stateless
@LocalBean
public class ProductoLogicService extends _ProductoLogicService implements IProductoLogicService {

    public int getCantidadItems(Long idProducto)
    {
        return persistance.getCantidadItems(idProducto);
    }

    public String listarProductos() {
        List<ProductoDTO> productos = super.getProductos();
        String resp="";
        for(int i=0;i<productos.size();i++)
        {
            resp+=productos.get(i).getName();
            if(i<productos.size()-1)
                resp+=",";
        }
        return resp;
    }
}