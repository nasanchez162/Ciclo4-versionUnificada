
package co.edu.uniandes.csw.producto.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.producto.logic.api.IProductoLogicService;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import java.util.List;

@Alternative
@Singleton
public class ProductoMockLogicService extends _ProductoMockLogicService implements IProductoLogicService {
	public int getCantidadItems(Long idProducto)
        {
            return 0;
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