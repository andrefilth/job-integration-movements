package br.com.cea.transporte.movements.batch.ris.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PROD.RF065T_EXPEDICION")
public class Expedicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NR_ASN")
	private String nrAsn;

	@Column(name = "NR_DISTRO")
	private String nrDistro;

	@Column(name = "CD_DESTINACION")
	private String cdDestinacion;

}
