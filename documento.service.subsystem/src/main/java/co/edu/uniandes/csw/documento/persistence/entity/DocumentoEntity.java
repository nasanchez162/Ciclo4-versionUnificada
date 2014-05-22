
package co.edu.uniandes.csw.documento.persistence.entity;

import javax.persistence.Entity;

@Entity
public class DocumentoEntity extends _DocumentoEntity {
 	
    private String estado;
        
        public String getEstado(){
		return estado;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}
}