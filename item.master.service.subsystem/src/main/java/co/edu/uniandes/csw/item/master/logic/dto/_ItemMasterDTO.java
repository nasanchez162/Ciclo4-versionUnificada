package co.edu.uniandes.csw.item.master.logic.dto;

import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _ItemMasterDTO {

 
    @XmlAttribute(name = "itemEntity")
    protected ItemDTO itemEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public ItemDTO getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemDTO itemEntity) {
        this.itemEntity = itemEntity;
    }
    
    public List<DocumentoDTO> createDocumento;
    public List<DocumentoDTO> updateDocumento;
    public List<DocumentoDTO> deleteDocumento;
    public List<DocumentoDTO> listDocumento;	
	
	
	
    public List<DocumentoDTO> getCreateDocumento(){ return createDocumento; };
    public void setCreateDocumento(List<DocumentoDTO> createDocumento){ this.createDocumento=createDocumento; };
    public List<DocumentoDTO> getUpdateDocumento(){ return updateDocumento; };
    public void setUpdateDocumento(List<DocumentoDTO> updateDocumento){ this.updateDocumento=updateDocumento; };
    public List<DocumentoDTO> getDeleteDocumento(){ return deleteDocumento; };
    public void setDeleteDocumento(List<DocumentoDTO> deleteDocumento){ this.deleteDocumento=deleteDocumento; };
    public List<DocumentoDTO> getListDocumento(){ return listDocumento; };
    public void setListDocumento(List<DocumentoDTO> listDocumento){ this.listDocumento=listDocumento; };	
	
	
}

