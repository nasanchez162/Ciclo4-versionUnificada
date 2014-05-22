
package co.edu.uniandes.csw.documento.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.documento.logic.dto.DocumentoDTO;
import co.edu.uniandes.csw.documento.persistence.entity.DocumentoEntity;

public abstract class _DocumentoConverter {


	public static DocumentoDTO entity2PersistenceDTO(DocumentoEntity entity){
		if (entity != null) {
			DocumentoDTO dto = new DocumentoDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setTipo(entity.getTipo());
				dto.setDescripcion(entity.getDescripcion());
                                dto.setEstado(entity.getEstado());
				dto.setAutor(entity.getAutor());
			return dto;
		}else{
			return null;
		}
	}
	
	public static DocumentoEntity persistenceDTO2Entity(DocumentoDTO dto){
		if(dto!=null){
			DocumentoEntity entity=new DocumentoEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setTipo(dto.getTipo());
			entity.setDescripcion(dto.getDescripcion());
                        entity.setEstado(dto.getEstado());
			entity.setAutor(dto.getAutor());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<DocumentoDTO> entity2PersistenceDTOList(List<DocumentoEntity> entities){
		List<DocumentoDTO> dtos=new ArrayList<DocumentoDTO>();
		for(DocumentoEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<DocumentoEntity> persistenceDTO2EntityList(List<DocumentoDTO> dtos){
		List<DocumentoEntity> entities=new ArrayList<DocumentoEntity>();
		for(DocumentoDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}