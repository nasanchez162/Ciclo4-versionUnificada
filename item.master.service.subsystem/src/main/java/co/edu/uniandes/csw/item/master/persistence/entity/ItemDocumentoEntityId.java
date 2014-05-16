package co.edu.uniandes.csw.item.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class ItemDocumentoEntityId implements Serializable{

    private Long itemId;
    private Long documentoId;

    @Override
    public int hashCode() {
        return (int) (itemId + documentoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ItemDocumentoEntityId) {
            ItemDocumentoEntityId otherId = (ItemDocumentoEntityId) object;
            return (otherId.itemId == this.itemId) && (otherId.documentoId == this.documentoId);
        }
        return false;
    }

}
