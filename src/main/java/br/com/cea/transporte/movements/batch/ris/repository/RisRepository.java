package br.com.cea.transporte.movements.batch.ris.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;

@Component
public interface RisRepository {

	public List<MovimentosDTO> consultarQuantidade(Integer item);

}
