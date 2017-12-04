package br.com.cea.transporte.movements.batch.ris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;
import br.com.cea.transporte.movements.batch.ris.repository.AjusteInventarioRepository;

@Service
public class AjusteInventarioService implements Services{

	@Autowired
	private AjusteInventarioRepository repository;
	
	@Override
	public List<MovimentosDTO> buscarInformacoesItem(Integer numero) {
		return  this.repository.consultarQuantidade(numero);
	}


}
