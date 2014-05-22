package co.edu.uniandes.csw.item.master.logic.ejb;

import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.documento.persistence.api.IDocumentoPersistence;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.master.logic.api._IItemMasterLogicService;
import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;
import co.edu.uniandes.csw.item.master.persistence.api.IItemMasterPersistence;
import co.edu.uniandes.csw.item.master.persistence.entity.ItemDocumentoEntity;
import co.edu.uniandes.csw.item.persistence.api.IItemPersistence;
import javax.inject.Inject;

public abstract class _ItemMasterLogicService implements _IItemMasterLogicService {

    @Inject
    protected IItemPersistence itemPersistance;
    @Inject
    protected IItemMasterPersistence itemMasterPersistance;
    @Inject
    protected IDocumentoPersistence documentoPersistance;

    public ItemMasterDTO createMasterItem(ItemMasterDTO item) {
        ItemDTO persistedItemDTO = itemPersistance.createItem(item.getItemEntity());
        
        DocumentoDTO document= new DocumentoDTO();
        document.setAutor("Administrador Inventario");
        document.setDescripcion("Ingresó el item: "+item.getItemEntity().getName()+" en el inventario");
        document.setEstado("Completado");
        document.setName("Documento ingreso "+item.getItemEntity().getName());
        document.setTipo("Reaprovisionamiento");
        DocumentoDTO persistedDocumentoDTO = documentoPersistance.createDocumento(document);
        ItemDocumentoEntity itemDocumentoEntity = new ItemDocumentoEntity(persistedItemDTO.getId(), persistedDocumentoDTO.getId());
        itemMasterPersistance.createItemDocumento(itemDocumentoEntity);
        
        if (item.getCreateDocumento() != null) {
            for (DocumentoDTO documentoDTO : item.getCreateDocumento()) {
                persistedDocumentoDTO = documentoPersistance.createDocumento(documentoDTO);
                itemDocumentoEntity = new ItemDocumentoEntity(persistedItemDTO.getId(), persistedDocumentoDTO.getId());
                itemMasterPersistance.createItemDocumento(itemDocumentoEntity);
            }
        }
        return item;
    }

    public ItemMasterDTO getMasterItem(Long id) {
        return itemMasterPersistance.getItem(id);
    }

    public void deleteMasterItem(Long id) {
        itemPersistance.deleteItem(id);
    }

    public void updateMasterItem(ItemMasterDTO item) {
        itemPersistance.updateItem(item.getItemEntity());

        //---- FOR RELATIONSHIP
        // persist new documento
        if (item.getCreateDocumento() != null) {
            for (DocumentoDTO documentoDTO : item.getCreateDocumento()) {
                DocumentoDTO persistedDocumentoDTO = documentoPersistance.createDocumento(documentoDTO);
                ItemDocumentoEntity itemDocumentoEntity = new ItemDocumentoEntity(item.getItemEntity().getId(), persistedDocumentoDTO.getId());
                itemMasterPersistance.createItemDocumento(itemDocumentoEntity);
            }
        }
        // update documento
        if (item.getUpdateDocumento() != null) {
            for (DocumentoDTO documentoDTO : item.getUpdateDocumento()) {
                documentoPersistance.updateDocumento(documentoDTO);
            }
        }
        // delete documento
        if (item.getDeleteDocumento() != null) {
            for (DocumentoDTO documentoDTO : item.getDeleteDocumento()) {
                itemMasterPersistance.deleteItemDocumento(item.getItemEntity().getId(), documentoDTO.getId());
                documentoPersistance.deleteDocumento(documentoDTO.getId());
            }
        }
    }
}
