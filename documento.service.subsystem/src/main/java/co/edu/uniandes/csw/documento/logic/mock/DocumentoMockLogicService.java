
package co.edu.uniandes.csw.documento.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.documento.logic.api.IDocumentoLogicService;
import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;

@Alternative
@Singleton
public class DocumentoMockLogicService extends _DocumentoMockLogicService implements IDocumentoLogicService {

    public void crearOrdenDespacho(DocumentoDTO detail, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void crearOrdenFabricacion(DocumentoDTO detail, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String consultarEstadoOrden(DocumentoDTO detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}