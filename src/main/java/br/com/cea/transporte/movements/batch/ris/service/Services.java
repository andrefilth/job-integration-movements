package br.com.cea.transporte.movements.batch.ris.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;

@Service
public interface Services {

	List<MovimentosDTO> buscarInformacoesItem(Integer numero);


}
