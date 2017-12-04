package br.com.cea.transporte.movements.batch.arquivo.data;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.cea.transporte.movements.batch.arquivo.type.MovimentoType;
import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;
import br.com.cea.transporte.movements.batch.ris.service.Services;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class ValidandoMovimentos {

	private String item;

	private String units;

	private MovimentoType statusRotina;

	private Services service;

	public ValidandoMovimentos(String linha, Services service) {
		this.item = StringUtils.substring(linha.trim(), 1, 25);
		this.units = StringUtils.substring(linha.trim(), 49, 55);
		this.service = service;
	}

	public List<MovimentosDTO> verificarDadosItem() {
		Integer numero = Integer.valueOf(this.item.trim());
		Integer quantidade = Integer.valueOf(this.units.trim());
		List<MovimentosDTO> dto = service.buscarInformacoesItem(numero);
		this.comparaDadosMovimento(quantidade, dto);
		return dto;

	}

	public void comparaDadosMovimento(Integer quantidade, List<MovimentosDTO> dto) {
		if (dto.size() == 0) {
			this.statusRotina = MovimentoType.NO_INTEGRADO;
		} else {
			for (MovimentosDTO list : dto) {
				if (list.getQuantidade() == quantidade) {
					this.statusRotina = MovimentoType.INTEGRADO;
				} else {
					this.statusRotina = MovimentoType.CONDIVERGENCIA;
				}
			}
		}
		log.info("Dados do DTO: " + dto + "  Quantidade do arquivo: " + quantidade + "  Situação do Status: "
				+ this.statusRotina);
	}
}
