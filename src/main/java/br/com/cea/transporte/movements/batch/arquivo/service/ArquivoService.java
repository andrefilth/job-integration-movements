package br.com.cea.transporte.movements.batch.arquivo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.movements.batch.arquivo.data.Registro;
import br.com.cea.transporte.movements.batch.arquivo.factrory.ArquivoFactory;
import br.com.cea.transporte.movements.batch.arquivo.thread.AsnOutThread;
import br.com.cea.transporte.movements.batch.arquivo.thread.InvAdjustThread;
import br.com.cea.transporte.movements.batch.arquivo.thread.ReceivingThread;
import br.com.cea.transporte.movements.batch.arquivo.thread.RtvThread;
import br.com.cea.transporte.movements.batch.arquivo.type.CodeType;
import br.com.cea.transporte.movements.batch.arquivo.util.DatasUteis;
import br.com.cea.transporte.movements.batch.ris.service.AjusteInventarioService;
import br.com.cea.transporte.movements.batch.ris.service.ArtigosExpedicaoService;
import br.com.cea.transporte.movements.batch.ris.service.ItemDevolucaoService;
import br.com.cea.transporte.movements.batch.ris.service.RecebimentosService;
import br.com.cea.transporte.movements.batch.rms.service.MovimentosInventarioService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ArquivoService {

	@Value("${cea.batch.router.patch.file}")
	private String caminho;

	@Autowired
	private ArtigosExpedicaoService expedicaoService;

	@Autowired
	private RecebimentosService recebimentosService;

	@Autowired
	private AjusteInventarioService inventarioService;

	@Autowired
	private ItemDevolucaoService devolucaoService;

	@Autowired
	private MovimentosInventarioService movimentosService;

	public boolean construirArquivos() {
		boolean status = false;
		List<Registro> registros = this.popularRegistro();
		// List<Registro> lerArquivo = this.extrairDadosArquivo();
		if (registros.size() == 0) {
			log.info("O aquivos está vazio, favor verificar se o mesmo está no diretório correto.");
			return false;
		}
		ArquivoFactory factory = new ArquivoFactory(caminho, registros);
		try {
			factory.contruirArquivo();
			status = true;
		} catch (IOException e) {
			log.error("Falha ao construir/ inserir registros no arquivos " + e);
			throw new RuntimeException("Falha ao construir/ inserir registros no arquivos, favor verificar o log ");
		}

		log.info("O arquivo foi divido com sucesso !");
		return status;
	}

	private List<Registro> extrairDadosArquivo() {
		List<Registro> list = new ArrayList<>();
		CodeType type = CodeType.INVENTORY;
		String nomeArquivo = type.nome(caminho);
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
			while (br.ready()) {
				String linha = br.readLine();
				String item = StringUtils.substring(linha.trim(), 1, 25);
				String packInd = StringUtils.substring(linha.trim(), 1, 25);
				Integer dept = Integer.valueOf(StringUtils.substring(linha.trim(), 1, 25));
				Date tranDate = DatasUteis.data(StringUtils.substring(linha.trim(), 1, 25));
				Integer tranCode = Integer.valueOf(StringUtils.substring(linha.trim(), 1, 25));
				String adjCode = StringUtils.substring(linha.trim(), 1, 25);
				Integer units = Integer.valueOf(StringUtils.substring(linha.trim(), 1, 25));
				Integer refNo1 = Integer.valueOf(StringUtils.substring(linha.trim(), 1, 25));
				Integer refNo2 = Integer.valueOf(StringUtils.substring(linha.trim(), 1, 25));
				String glRefNo = StringUtils.substring(linha.trim(), 1, 25);
				String refPackNo = StringUtils.substring(linha.trim(), 1, 25);
				Registro registro = new Registro(item, packInd, dept, tranDate, tranCode, adjCode, units, refNo1,
						refNo2, glRefNo, refPackNo);
				list.add(registro);
			}
			br.close();
		} catch (IOException e) {
			log.info("Não foi possível ver o arquivo, favor verificar se o mesmo existe no diretório.");
		}
		return list;
	}

	public void processarArquivos() {
		log.info("Início da validação dos arquivos via Thread");
		new AsnOutThread(caminho, expedicaoService,movimentosService).run();
		new ReceivingThread(caminho, recebimentosService,movimentosService).run();
		new InvAdjustThread(caminho, inventarioService,movimentosService).run();
		new RtvThread(caminho, devolucaoService,movimentosService).run();

		log.info("Arquivos lidos ");

	}

	private List<Registro> popularRegistro() {
		// List<Registro> registroAsn = new ArrayList<>();
		String packInd = "";
		Integer dept = 123;
		Date tranDate = new Date();
		Integer tranCode = 1;
		String adjCode = "";
		Integer units = 10;
		Integer refNo1 = 1;
		Integer refNo2 = 1;
		String glRefNo = "";
		String refPackNo = "";
		Registro registro = new Registro("1", packInd, dept, tranDate, tranCode, adjCode, 10, refNo1, refNo2, glRefNo,
				refPackNo);
		Registro registro2 = new Registro("2", packInd, dept, tranDate, tranCode, adjCode, 12, refNo1, refNo2, glRefNo,
				refPackNo);
		Registro registro3 = new Registro("3", packInd, dept, tranDate, tranCode, adjCode, 11, refNo1, refNo2, glRefNo,
				refPackNo);
		Registro registro33 = new Registro("4", packInd, dept, tranDate, tranCode, adjCode, 11, refNo1, refNo2, glRefNo,
				refPackNo);

		Integer tranCode2 = 2;
		Registro registro4 = new Registro("1", packInd, dept, tranDate, tranCode2, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro5 = new Registro("2", packInd, dept, tranDate, tranCode2, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro6 = new Registro("3", packInd, dept, tranDate, tranCode2, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		Integer tranCode3 = 3;
		Registro registro7 = new Registro("1", packInd, dept, tranDate, tranCode3, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro8 = new Registro("2", packInd, dept, tranDate, tranCode3, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro9 = new Registro("3", packInd, dept, tranDate, tranCode3, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		Integer tranCode4 = 4;
		Registro registro10 = new Registro("1", packInd, dept, tranDate, tranCode4, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro11 = new Registro("2", packInd, dept, tranDate, tranCode4, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);
		Registro registro12 = new Registro("3", packInd, dept, tranDate, tranCode4, adjCode, units, refNo1, refNo2,
				glRefNo, refPackNo);

		List<Registro> registroAsn = Arrays.asList(registro, registro2, registro3, registro33, registro4, registro5,
				registro6, registro7, registro8, registro9, registro10, registro11, registro12);
		return registroAsn;
	}

}
