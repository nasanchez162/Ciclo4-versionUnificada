package co.edu.uniandes.csw.item.master.persistence.entity;

import co.edu.uniandes.csw.documento.persistence.entity.DocumentoEntity;
import co.edu.uniandes.csw.item.persistence.entity.ItemEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(ItemDocumentoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "ItemDocumentoEntity.getDocumentoListForItem", query = "SELECT  u FROM ItemDocumentoEntity u WHERE u.itemId=:itemId"),
    @NamedQuery(name = "ItemDocumentoEntity.deleteItemDocumento", query = "DELETE FROM ItemDocumentoEntity u WHERE u.documentoId=:documentoId and  u.itemId=:itemId")
})
public class ItemDocumentoEntity implements Serializable {

    @Id
    @Column(name = "itemId")
    private Long itemId;
    @Id
    @Column(name = "documentoId")
    private Long documentoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "documentoId", referencedColumnName = "id")
    @JoinFetch
    private DocumentoEntity documentoEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "itemId", referencedColumnName = "id")
    @JoinFetch
    private ItemEntity itemEntity;

    public ItemDocumentoEntity() {
    }

    public ItemDocumentoEntity(Long itemId, Long documentoId) {
        this.itemId = itemId;
        this.documentoId = documentoId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Long documentoId) {
        this.documentoId = documentoId;
    }

    public DocumentoEntity getDocumentoEntity() {
        return documentoEntity;
    }

    public void setDocumentoEntity(DocumentoEntity documentoEntity) {
        this.documentoEntity = documentoEntity;
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

}
