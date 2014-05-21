
package co.edu.uniandes.csw.documento.logic.api;

import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;

public interface IDocumentoLogicService extends _IDocumentoLogicService

{
    
    public void crearOrdenDespacho (DocumentoDTO detail, String descripcion);
    
    public void crearOrdenFabricacion (DocumentoDTO detail, String descripcion);
    
    public String consultarEstadoOrden (DocumentoDTO detail);

}