
package co.edu.uniandes.csw.documento.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.documento.logic.api._IDocumentoLogicService;

public abstract class _DocumentoMockLogicService implements _IDocumentoLogicService {

	private Long id= new Long(1);
	protected List<DocumentoDTO> data=new ArrayList<DocumentoDTO>();

	public DocumentoDTO createDocumento(DocumentoDTO documento){
		id++;
		documento.setId(id);
		return documento;
    }

	public List<DocumentoDTO> getDocumentos(){
		return data; 
	}

	public DocumentoDTO getDocumento(Long id){
		for(DocumentoDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteDocumento(Long id){
	    DocumentoDTO delete=null;
		for(DocumentoDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateDocumento(DocumentoDTO documento){
	    DocumentoDTO delete=null;
		for(DocumentoDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(documento);
		} 
	}	
}