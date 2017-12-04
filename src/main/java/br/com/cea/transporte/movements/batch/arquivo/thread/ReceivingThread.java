package br.com.cea.transporte.movements.batch.arquivo.thread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import br.com.cea.transporte.movements.batch.arquivo.data.ValidandoMovimentos;
import br.com.cea.transporte.movements.batch.arquivo.type.CodeType;
import br.com.cea.transporte.movements.batch.arquivo.type.MovimentoType;
import br.com.cea.transporte.movements.batch.ris.model.MovimentosDTO;
import br.com.cea.transporte.movements.batch.ris.service.Services;
import br.com.cea.transporte.movements.batch.rms.service.MovimentosInventarioService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
public class ReceivingThread implements Runnable {

	private String caminho;
	
	private Services recebimentosService;
	
	private MovimentosInventarioService movimentosService;
	
	@Override
	public void run() {

		CodeType type = CodeType.RECEIVING;
		String nomeArquivo = type.nome(caminho);
		new Thread(() -> {
			try {
				BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
				while (br.ready()) {
					String linha = br.readLine();
					ValidandoMovimentos movimentos = new ValidandoMovimentos(linha, recebimentosService);
					List<MovimentosDTO> dadosItem = movimentos.verificarDadosItem();
					MovimentoType movimentoType = movimentos.getStatusRotina();
					// execucao da procedure
					for (MovimentosDTO dto : dadosItem) {
						this.movimentosService.executarProcedure(String.valueOf(dto.getNumero()), String.valueOf(1),
								dto.getQuantidade(), type.getCodigo(), movimentoType.name());
					}
				}
				br.close();
			} catch (IOException e) {
				log.info("Não foi possível ler os dados do arquivo");
			}
		}).start();
	}

	
}
