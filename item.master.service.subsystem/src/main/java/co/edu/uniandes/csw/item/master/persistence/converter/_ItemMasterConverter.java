package co.edu.uniandes.csw.item.master.persistence.converter;
import co.edu.uniandes.csw.item.master.persistence.entity.ItemDocumentoEntity;
import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.documento.persistence.converter.DocumentoConverter;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.item.persistence.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _ItemMasterConverter {

    public static ItemMasterDTO entity2PersistenceDTO(ItemEntity itemEntity 
    ,List<ItemDocumentoEntity> itemDocumentoEntity 
    ) {
        ItemDTO itemDTO = ItemConverter.entity2PersistenceDTO(itemEntity);
        ArrayList<DocumentoDTO> documentoEntities = new ArrayList<DocumentoDTO>(itemDocumentoEntity.size());
        for (ItemDocumentoEntity itemDocumento : itemDocumentoEntity) {
            documentoEntities.add(DocumentoConverter.entity2PersistenceDTO(itemDocumento.getDocumentoEntity()));
        }
        ItemMasterDTO respDTO  = new ItemMasterDTO();
        respDTO.setItemEntity(itemDTO);
        respDTO.setListDocumento(documentoEntities);
        return respDTO;
    }

}