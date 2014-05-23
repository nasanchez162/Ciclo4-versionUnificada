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
import org.apache.derby.catalog.SystemProcedures;

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
        document.setDescripcion("Ingres� el item: "+item.getItemEntity().getName()+" en el inventario");
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
        System.out.println("updateMasterItem -------------------");
        //Aqu� comparo con el actual y decido qu� hacer
        ItemMasterDTO actual = getMasterItem(item.getId());
        
        int valorViejo = actual.getItemEntity().getCantidadItem();
        int valorNuevo = item.getItemEntity().getCantidadItem();
        System.out.println("A");
        itemPersistance.updateItem(item.getItemEntity());
        System.out.println("B");
           // Aqu� a�ado los documentos
        
        if (valorNuevo > valorViejo)
        {
            System.out.println("Entra a agregar");
            int cambio = valorNuevo - valorViejo;
            //Orden de reaprovisionamiento
            DocumentoDTO document= new DocumentoDTO();
            document.setAutor("Administrador Inventario");
            document.setDescripcion("Se ingresaron " + cambio + " unidades de " +item.getItemEntity().getName()+" en el inventario");
            document.setEstado("Completado");
            document.setName("Documento reaprovisionamiento "+item.getItemEntity().getName());
            document.setTipo("Reaprovisionamiento");
            DocumentoDTO persistedDocumentoDTO = documentoPersistance.createDocumento(document);
            ItemDocumentoEntity itemDocumentoEntity = new ItemDocumentoEntity(item.getId(), persistedDocumentoDTO.getId());
            itemMasterPersistance.createItemDocumento(itemDocumentoEntity);
            
        }
        else if (valorNuevo < valorViejo)
        {
            System.out.println("Entra a retirar");
            //Orden de despacho
            
            int cambio = valorViejo - valorNuevo;
            
            DocumentoDTO document= new DocumentoDTO();
            document.setAutor("Administrador Inventario");
            document.setDescripcion("Se retiraron " + cambio + " unidades de " + item.getItemEntity().getName()+" del inventario");
            document.setEstado("Completado");
            document.setName("Documento despacho "+item.getItemEntity().getName());
            document.setTipo("Despacho");
            DocumentoDTO persistedDocumentoDTO = documentoPersistance.createDocumento(document);
            ItemDocumentoEntity itemDocumentoEntity = new ItemDocumentoEntity(item.getId(), persistedDocumentoDTO.getId());
            itemMasterPersistance.createItemDocumento(itemDocumentoEntity);
        }
        
        
        
        //---- FOR RELATIONSHIP
        // persist new documento
        if (item.getCreateDocumento() != null) {
            System.out.println("Persist new documento");
            for (DocumentoDTO documentoDTO : item.getCreateDocumento()) {
                DocumentoDTO persistedDocumentoDTO = documentoPersistance.createDocumento(documentoDTO);
                ItemDocumentoEntity itemDocumentoEntity = new ItemDocumentoEntity(item.getItemEntity().getId(), persistedDocumentoDTO.getId());
                itemMasterPersistance.createItemDocumento(itemDocumentoEntity);
            }
        }
        // update documento
        if (item.getUpdateDocumento() != null) {
            System.out.println("update documento");
            for (DocumentoDTO documentoDTO : item.getUpdateDocumento()) {
                documentoPersistance.updateDocumento(documentoDTO);
            }
        }
        // delete documento
        if (item.getDeleteDocumento() != null) {
            System.out.println("delete documento");
            for (DocumentoDTO documentoDTO : item.getDeleteDocumento()) {
                itemMasterPersistance.deleteItemDocumento(item.getItemEntity().getId(), documentoDTO.getId());
                documentoPersistance.deleteDocumento(documentoDTO.getId());
            }
        }
    }
}
