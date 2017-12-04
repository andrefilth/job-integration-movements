package br.com.cea.transporte.movements.batch.ris.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;
import br.com.cea.transporte.movements.batch.ris.repository.ItemDevolucaoRepository;
import br.com.cea.transporte.movements.batch.ris.repository.QueryRepository;

@Component
public class ItemDevolucaoRepositoryImpl implements ItemDevolucaoRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<MovimentosDTO> consultarQuantidade(Integer item) {
		List<MovimentosDTO> query = this.template.query(QueryRepository.CONSULTAR_DEVOLUCAO_ID,
				new BeanPropertyRowMapper<>(MovimentosDTO.class), item);
		return query;
	}

}
