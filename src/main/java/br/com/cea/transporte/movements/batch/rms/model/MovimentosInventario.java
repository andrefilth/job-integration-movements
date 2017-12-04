package br.com.cea.transporte.movements.batch.rms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedStoredProcedureQuery(name = "Procedure.validarMovimentos", procedureName = "SP_INSERT_VALIDATION_INVENTORY_MOVEMENTS", parameters = {
		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "item", type = String.class)
		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "tipo_movimiento", type = String.class)
		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "fecha", type = Date.class) 
		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "cantidad", type = Double.class) 
		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "transaccion", type = Integer.class) 
		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "status", type = String.class) 
		})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Validation_Inventory_Movements")
public class MovimentosInventario {

	
	@Id
	@GeneratedValue
	@Column(name = "id_vim", nullable=false)
	private Long id;

	@Column(name = "item", nullable=false)
	private String item;

	@Column(name = "tipo_movimiento", nullable=false)
	private String tipo;

	@Column(name = "fecha", nullable=false)
	private Date data;

	@Column(name = "cantidad", nullable=false)
	private Double cantidad;

	@Column(name = "condigo_transaccion", nullable=false)
	private Double codigo;

	@Column(name = "status_movimiento", nullable=false)
	private String status;


}
