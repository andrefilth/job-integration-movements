package br.com.cea.transporte.movements.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cea.transporte.movements.batch.arquivo.service.ArquivoService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IntegrationProcessor implements ItemProcessor<Object, Object> {

	@Autowired
	private ArquivoService service;

	@Override
	public Object process(Object item) throws Exception {
		log.info("Processando em THREADS");
		this.service.processarArquivos();

		return null;
	}

}
