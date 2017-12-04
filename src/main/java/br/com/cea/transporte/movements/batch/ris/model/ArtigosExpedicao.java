package br.com.cea.transporte.movements.batch.ris.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PROD.RF066T_EXPEDICION_ARTICULOS")
public class ArtigosExpedicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArtigosExpedicaoPK pk;
	
	@Column(name="CANTIDAD")
	private Integer cantidad;
	
	@Column(name="ITEM_DESC")
	private Integer itemDesc;

}
