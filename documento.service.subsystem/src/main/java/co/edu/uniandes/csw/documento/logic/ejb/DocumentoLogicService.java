
package co.edu.uniandes.csw.documento.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.documento.logic.api.IDocumentoLogicService;
import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Default
@Stateless
@LocalBean
public class DocumentoLogicService extends _DocumentoLogicService implements IDocumentoLogicService

{

    /**
     * 
     * @param detail
     * @param descripcion 
     */
    public void crearOrdenDespacho(DocumentoDTO detail, String descripcion)
    {
        detail.setTipo("Despacho");
        detail.setDescripcion(descripcion);
        this.createDocumento(detail);
    }

    /**
     *
     * @param detail
     * @param descripcion
     */
    public void crearOrdenFabricacion(DocumentoDTO detail, String descripcion) {
        detail.setTipo("Fabricación");
        detail.setDescripcion(descripcion);
        this.createDocumento(detail);
    }

    /**
     * 
     * @param detail
     * @return 
     */
    public String consultarEstadoOrden(DocumentoDTO detail) {
        
        List<DocumentoDTO> documentos = this.getDocumentos();
        
        Iterator<DocumentoDTO> it = documentos.iterator();
        
        while (it.hasNext())
        {
            DocumentoDTO doc = it.next();
            if (doc.equals(detail))
            {
                return doc.getEstado();
            }
        }
        return "no hay documentos a qué averiguarles el estado";
    }

}