//package br.com.cea.transporte.movements.batch.rms.model;
//
//import java.util.Date;
//
//import javax.persistence.NamedStoredProcedureQuery;
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureParameter;
//
//import lombok.Data;
//
//@NamedStoredProcedureQuery(name = "Procedure.validarMovimentos", procedureName = "SP_INSERT_ VALIDATION_INVENTORY_MOVEMENTS", parameters = {
//		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "item", type = String.class)
//		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "tipo_movimiento", type = String.class)
//		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "fecha", type = Date.class) 
//		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "cantidad", type = Double.class) 
//		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "transaccion", type = Integer.class) 
//		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "status", type = String.class) 
//		}
////, resultClasses = Procedure.class
//)
//
//@Data
//
//public class Procedure {
//
//}
