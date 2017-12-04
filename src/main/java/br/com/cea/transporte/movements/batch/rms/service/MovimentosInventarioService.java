package br.com.cea.transporte.movements.batch.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.movements.batch.arquivo.util.DatasUteis;
import br.com.cea.transporte.movements.batch.rms.repository.MovimentosInventarioRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MovimentosInventarioService {

	@Autowired
	private MovimentosInventarioRepository movimento;

	public void executarProcedure(String item, String tipo, Integer quantidade, Integer codigo, String status) {
		this.movimento.validarMovimentos(item, tipo,DatasUteis.mostrarDataAtualSql(), quantidade, codigo, status);
		log.info("Procedure executada com sucesso");
	}
}
