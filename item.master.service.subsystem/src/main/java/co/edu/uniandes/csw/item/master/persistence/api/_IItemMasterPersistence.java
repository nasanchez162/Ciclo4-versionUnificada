package co.edu.uniandes.csw.item.master.persistence.api;

import co.edu.uniandes.csw.item.master.persistence.entity.ItemDocumentoEntity;
import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;
import java.util.List;

public interface _IItemMasterPersistence {

    public ItemDocumentoEntity createItemDocumento(ItemDocumentoEntity entity);

    public void deleteItemDocumento(Long itemId, Long documentoId);
    
    public List<DocumentoDTO> getDocumentoListForItem(Long itemId);
    
    public ItemMasterDTO getItem(Long itemId);

}
