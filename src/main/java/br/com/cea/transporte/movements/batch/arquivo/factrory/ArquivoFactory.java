package br.com.cea.transporte.movements.batch.arquivo.factrory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.cea.transporte.movements.batch.arquivo.data.Registro;
import br.com.cea.transporte.movements.batch.arquivo.type.CodeType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArquivoFactory {

	private String caminhoArquivoRotas;
	private List<Registro> registros;

	public void contruirArquivo() throws IOException {
		for (Registro registro : registros) {
			CodeType type = registro.getType();
			String arquivos = type.nome(caminhoArquivoRotas);
			File file = new File(arquivos);
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(registro.getRegistroArquivo());
			bw.newLine();
			bw.close();
		}
	}

}
