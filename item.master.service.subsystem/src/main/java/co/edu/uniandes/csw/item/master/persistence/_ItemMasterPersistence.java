package co.edu.uniandes.csw.item.master.persistence;
import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.item.master.persistence.entity.ItemDocumentoEntity;
import co.edu.uniandes.csw.documento.persistence.converter.DocumentoConverter;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;
import co.edu.uniandes.csw.item.master.persistence.api._IItemMasterPersistence;
import co.edu.uniandes.csw.item.persistence.api.IItemPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _ItemMasterPersistence implements _IItemMasterPersistence {

    @PersistenceContext(unitName = "ItemMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected IItemPersistence itemPersistence;  

    public ItemMasterDTO getItem(Long itemId) {
        ItemMasterDTO itemMasterDTO = new ItemMasterDTO();
        ItemDTO item = itemPersistence.getItem(itemId);
        itemMasterDTO.setItemEntity(item);
        itemMasterDTO.setListDocumento(getDocumentoListForItem(itemId));
        return itemMasterDTO;
    }

    public ItemDocumentoEntity createItemDocumento(ItemDocumentoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteItemDocumento(Long itemId, Long documentoId) {
        Query q = entityManager.createNamedQuery("ItemDocumentoEntity.deleteItemDocumento");
        q.setParameter("itemId", itemId);
        q.setParameter("documentoId", documentoId);
        q.executeUpdate();
    }

    public List<DocumentoDTO> getDocumentoListForItem(Long itemId) {
        ArrayList<DocumentoDTO> resp = new ArrayList<DocumentoDTO>();
        Query q = entityManager.createNamedQuery("ItemDocumentoEntity.getDocumentoListForItem");
        q.setParameter("itemId", itemId);
        List<ItemDocumentoEntity> qResult =  q.getResultList();
        for (ItemDocumentoEntity itemDocumentoEntity : qResult) { 
            if(itemDocumentoEntity.getDocumentoEntity()==null){
                entityManager.refresh(itemDocumentoEntity);
            }
            resp.add(DocumentoConverter.entity2PersistenceDTO(itemDocumentoEntity.getDocumentoEntity()));
        }
        return resp;
    }

}
