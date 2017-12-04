package br.com.cea.transporte.movements.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cea.transporte.movements.batch.arquivo.service.ArquivoService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IntegrationReader implements ItemReader<Object> {

	private boolean batchJobState;

	@Autowired
	private ArquivoService service;

	@Override
	public Object read() throws Exception {

		log.info("Processando...");
		if (!batchJobState) {
			batchJobState = true;
			boolean arquivosConstruidos = this.service.construirArquivos();
			if (!arquivosConstruidos) {
				log.info("Não existem lotes para serem processados");
				return null;
			}
			this.service.processarArquivos();
		}
		return null;

	}

}
