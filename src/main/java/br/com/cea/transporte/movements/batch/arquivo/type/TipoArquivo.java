package br.com.cea.transporte.movements.batch.arquivo.type;

public interface TipoArquivo {

	String nome(String caminho);

	CodeType type(Integer codigo);
	
}
