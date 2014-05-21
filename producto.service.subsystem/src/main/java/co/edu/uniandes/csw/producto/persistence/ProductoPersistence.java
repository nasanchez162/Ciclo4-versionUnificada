
package co.edu.uniandes.csw.producto.persistence;

import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.producto.persistence.api.IProductoPersistence;
import co.edu.uniandes.csw.producto.persistence.converter.ProductoConverter;
import java.util.List;
import javax.ejb.LocalBean;
import javax.persistence.Query;

@Default
@Stateless 
@LocalBean
public class ProductoPersistence extends _ProductoPersistence  implements IProductoPersistence {

    public int getCantidadItems(Long idProducto) {
        Query q = entityManager.createQuery("select sum(CANTIDADITEM) as C from ITEMENTITY i where i.PRODUCTOAID = " + idProducto);
        int i = q.executeUpdate();
        System.out.println("CHISME: " + i);
        return i;
                
    }

}