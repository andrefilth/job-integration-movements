package br.com.cea.transporte.movements.batch.ris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;
import br.com.cea.transporte.movements.batch.ris.repository.ItemDevolucaoRepository;

@Service
public class ItemDevolucaoService implements Services{

	@Autowired
	private ItemDevolucaoRepository repository;
	
	@Override
	public List<MovimentosDTO> buscarInformacoesItem(Integer numero) {
		return  this.repository.consultarQuantidade(numero);
	}


}
