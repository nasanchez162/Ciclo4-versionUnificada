package co.edu.uniandes.csw.item.master.logic.ejb;

import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.item.master.logic.api.IItemMasterLogicService;
import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class ItemMasterLogicService extends _ItemMasterLogicService implements IItemMasterLogicService {

    public void aniadirDocumentoVenta (Long idItem, int idCantidad)
    {
        ItemMasterDTO itemac = super.getMasterItem(idItem);
        DocumentoDTO documento = new DocumentoDTO();
        documento.setAutor("Admin Invetario");
        Date ac = new Date();
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy hh:mm");
        documento.setDescripcion("Se descontaron "+idCantidad+" items en una compra el "+format.format(ac));
        documento.setEstado("Completo");
        documento.setName("Venta de progducto");
        documento.setTipo("Despacho");
        List<DocumentoDTO> documentos = new ArrayList<DocumentoDTO>();
        itemac.setCreateDocumento(documentos);
        super.updateMasterItem(itemac);
                
    }
}