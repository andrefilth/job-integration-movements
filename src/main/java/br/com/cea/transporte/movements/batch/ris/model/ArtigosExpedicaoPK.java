package br.com.cea.transporte.movements.batch.ris.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class ArtigosExpedicaoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "NR_ASN", referencedColumnName = "NR_ASN")
	@ManyToOne(optional = false)
	private Expedicao armazem;

	@Column(name = "NR_DISTRO")
	private String nrDistro;

	@Column(name = "ITEM_ID")
	private String itemId;
}
