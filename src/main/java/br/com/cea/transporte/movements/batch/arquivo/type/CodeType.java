package br.com.cea.transporte.movements.batch.arquivo.type;

import br.com.cea.transporte.movements.batch.arquivo.data.Arquivo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodeType implements TipoArquivo {

	ASNOUT(1, "asnout") {

		@Override
		public String nome(String caminho) {
			Arquivo arquivo = new Arquivo(ASNOUT.getDescricao(), caminho);
			return arquivo.getNomeArquivo();
		}

		@Override
		public CodeType type(Integer codigo) {
			return getType(codigo);
		}

	},
	RECEIVING(2, "receiving") {

		@Override
		public String nome(String caminho) {
			Arquivo arquivo = new Arquivo(RECEIVING.getDescricao(), caminho);
			return arquivo.getNomeArquivo();
		}

		@Override
		public CodeType type(Integer codigo) {
			return getType(codigo);
		}

	},
	INVADJUST(3, "invadjust") {

		@Override
		public String nome(String caminho) {
			Arquivo arquivo = new Arquivo(INVADJUST.getDescricao(), caminho);
			return arquivo.getNomeArquivo();
		}

		@Override
		public CodeType type(Integer codigo) {
			return getType(codigo);
		}

	},
	RTV(4, "rtv") {

		@Override
		public String nome(String caminho) {
			Arquivo arquivo = new Arquivo(RTV.getDescricao(), caminho);
			return arquivo.getNomeArquivo();
		}

		@Override
		public CodeType type(Integer codigo) {
			return getType(codigo);
		}

	},
	INVENTORY(5, "InventoryMovements") {

		@Override
		public String nome(String caminho) {
			Arquivo arquivo = new Arquivo(INVENTORY.getDescricao(), caminho);
			return arquivo.getNomeArquivo();
		}

		@Override
		public CodeType type(Integer codigo) {
			return getType(codigo);
		}

	};

	private Integer codigo;
	private String descricao;

	public static String getDescricao(Integer codigo) {
		if (!(codigo == null)) {
			for (CodeType type : CodeType.values()) {
				if (type.codigo.equals(codigo)) {
					return type.getDescricao();
				}
			}
		}
		throw new NullPointerException("O código do CodeTypes não pode ser nulo");
	}

	public static CodeType getType(Integer codigo) {
		if (!(codigo == null)) {
			for (CodeType type : CodeType.values()) {
				if (type.codigo.equals(codigo)) {
					return type;
				}
			}
		}
		throw new NullPointerException("O código do CodeTypes não pode ser nulo");
	}
}
