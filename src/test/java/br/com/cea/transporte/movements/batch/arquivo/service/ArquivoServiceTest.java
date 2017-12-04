package br.com.cea.transporte.movements.batch.arquivo.service;

import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cea.transporte.movements.batch.arquivo.data.Arquivo;
import br.com.cea.transporte.movements.batch.arquivo.data.Registro;
import br.com.cea.transporte.movements.batch.arquivo.type.CodeType;

@SpringBootTest
public class ArquivoServiceTest {

	private static final String INVENTORY_MOVEMENTS = "inventory_movements_";

	private String caminho = "/datos/rwms/app/upload_dir/";

	private List<Registro> registroAsn;

	@Before
	public void init() {
		String item = "";
		String packInd = "";
		Integer dept = 123;
		Date tranDate = new Date();
		Integer tranCode = 1;
		String adjCode = "";
		Integer units =10;
		Integer refNo1 = 1;
		Integer refNo2 = 1;
		String glRefNo = "";
		String refPackNo = "";
		CodeType type = CodeType.RECEIVING;
		Registro registro = new Registro(item, packInd, dept, tranDate, tranCode, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro2 = new Registro(item, packInd, dept, tranDate, tranCode, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro3 = new Registro(item, packInd, dept, tranDate, tranCode, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		Integer tranCode2 = 2;
		Registro registro4 = new Registro(item, packInd, dept, tranDate, tranCode2, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro5 = new Registro(item, packInd, dept, tranDate, tranCode2, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro6 = new Registro(item, packInd, dept, tranDate, tranCode2, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		Integer tranCode3 = 3;
		Registro registro7 = new Registro(item, packInd, dept, tranDate, tranCode3, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro8 = new Registro(item, packInd, dept, tranDate, tranCode3, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro9 = new Registro(item, packInd, dept, tranDate, tranCode3, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		Integer tranCode4 = 4;
		Registro registro10 = new Registro(item, packInd, dept, tranDate, tranCode4, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro11 = new Registro(item, packInd, dept, tranDate, tranCode4, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro12 = new Registro(item, packInd, dept, tranDate, tranCode4, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		this.registroAsn = Arrays.asList(registro, registro2, registro3, registro4, registro5, registro6, registro7,
				registro8, registro9, registro10, registro11, registro12);
		System.out.println(registroAsn);

	}

	@Test
	@Ignore
	public void testaArquivoNaoExisteECriaArquivo() throws IOException {
		Arquivo arquivo = new Arquivo(INVENTORY_MOVEMENTS, caminho);
		String nomeArquivo = arquivo.getNomeArquivo();
		File file = new File(nomeArquivo);
		if (!file.exists()) {
			file.createNewFile();
		}
		assertTrue(file.exists());// ;(true, file.exists());
	}

	@Test
	public void testaCriacaoArquivoAsnt() {
		// pega a lista e percorre toda ela.
		// List<Registro> registros = new LinkedList<>();
		System.out.println("Lista: " + registroAsn);
		registroAsn.forEach(listaRegistro -> {
			CodeType type = listaRegistro.getType();
			String arquivos = type.nome(caminho);
			File file = new File(arquivos);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Falha ao criar arquivo");
				}
			}
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(file, true));
				bw.write(listaRegistro.getRegistroArquivo());
				bw.newLine();
				bw.close();
			} catch (IOException e) {
				System.out.println("Falha ao criar arquivo");
			}
		});

	}
}