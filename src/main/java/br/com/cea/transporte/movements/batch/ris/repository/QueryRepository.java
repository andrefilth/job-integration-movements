package br.com.cea.transporte.movements.batch.ris.repository;

public class QueryRepository {

	public static final String CONSULTAR_EXPEDICAO_ID = "SELECT "
													+ "  RF066T.NR_ASN   as numero "
													+ ", RF066T.CANTIDAD as quantidade "
													+ "FROM PROD.RF066T_EXPEDICION_ARTICULOS RF066T "
													+ "WHERE NR_ASN=?";
	
	public static final String CONSULTAR_RECEBIMENTO_ID = "SELECT									        "
												    + "   RF068T.CD_CITA                as numero           "
													+ " , RF068T.CANTIDAD_CONTENEDORES  as quantidade       "
													+ " FROM                                                "
													+ "    PROD.RF068T_RECIBIMIENTO_CITAS_ARTICULOS RF068T  "
													+ " WHERE RF068T.CD_CITA=?								";

	public static final String CONSULTAR_AJUSTE_ID = " SELECT												"  
													+"       RF047T.ITEM_ID  AS numero                      "  
													+"     , RF047T.cantidad as quantidade                  "  
													+"FROM                                                  "  
													+"    PROD.RF047T_AJUSTES_INVENTARIO_ARTICULOS RF047T   "  
													+"WHERE RF047T.ITEM_ID = ?                              ";

	public static final String CONSULTAR_DEVOLUCAO_ID = " SELECT												"  
													+"       RF047T.ITEM_ID  AS numero                      "  
													+"     , RF047T.cantidad as quantidade                  "  
													+"FROM                                                  "  
													+"    PROD.RF047T_AJUSTES_INVENTARIO_ARTICULOS RF047T   "  
													+"WHERE RF047T.ITEM_ID = ?                              ";

}
