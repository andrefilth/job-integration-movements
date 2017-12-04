package br.com.cea.transporte.movements.batch.arquivo.data;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import br.com.cea.transporte.movements.batch.arquivo.type.CodeType;
import br.com.cea.transporte.movements.batch.arquivo.util.DatasUteis;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Registro {

	private String item;

	private String packInd;

	private Integer dept;

	private Date tranDate;

	private Integer tranCode;

	private String adjCode;

	private Integer units;

	private Integer refNo1;

	private Integer refNo2;

	private String glRefNo;

	private String refPackNo;

	private CodeType type;

	public Registro(String item, String packInd, Integer dept, Date tranDate, Integer tranCode, String adjCode,
			Integer units, Integer refNo1, Integer refNo2, String glRefNo, String refPackNo) {
		this.item = item;
		this.packInd = packInd;
		this.dept = dept;
		this.tranDate = tranDate;
		this.tranCode = tranCode;
		this.adjCode = adjCode;
		this.units = units;
		this.refNo1 = refNo1;
		this.refNo2 = refNo2;
		this.glRefNo = glRefNo;
		this.refPackNo = refPackNo;
		this.type = CodeType.getType(tranCode);
	}

	public String getRegistroArquivo() {
		StringBuffer sb = new StringBuffer();
		sb.append(StringUtils.leftPad(item.trim(), 25, "0"));
		sb.append(" ");
		sb.append(StringUtils.leftPad(packInd.trim(), 2, "0"));
		sb.append(StringUtils.leftPad(String.valueOf(dept), 2, "0"));
		sb.append(DatasUteis.data(tranDate));
		sb.append(StringUtils.leftPad(String.valueOf(tranCode), 2, "0"));
		sb.append(StringUtils.leftPad(adjCode.trim(), 2, "0"));
		sb.append(" ");
		sb.append(StringUtils.leftPad(String.valueOf(units), 6, "0"));
		sb.append(" ");
		sb.append(StringUtils.leftPad(String.valueOf(refNo1), 6, "0"));
		sb.append(StringUtils.leftPad(String.valueOf(refNo2), 6, "0"));
		sb.append(StringUtils.leftPad(glRefNo.trim(), 10, "0"));
		sb.append(StringUtils.leftPad(refPackNo.trim(), 10, "0"));
		return sb.toString();
	}

}
