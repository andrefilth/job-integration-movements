package br.com.cea.transporte.movements.batch.ris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentosDTO {

	private String numero;
	
	private Integer quantidade;
	
	public String getNumero() {
		return numero.trim();
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
}
