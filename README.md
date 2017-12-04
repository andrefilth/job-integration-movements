Versão final do job, porém, a leitura do arquivo inicial está Mockada, será necessário, assim que uma versão do arquivo estiver disponível, realizar a alteração do código fonte. Também é necessário verificar o diretório que será lido o arquivo, no código esta informação está em application.properties




Control-M activará un proceso batch, escrito en Java Spring Batch que se conectará a la base de DB2 (RIS) y SQL Server (WMS_RMS) del sistema para validar las transacciones reportadas por Oracle RWMS en el archivo texto. Esto archivo texto serán generados por Oracle ORWMS todos los días por proceso que será agendado como sucesora y deberá correr antes de los demás procesos del RMS para que los datos sean capturados en el día corriente.

El batch deberá leer todas las líneas del archivo, pero, para optimizar la forma de operación, serán creadas 4 (cuatro) threads, una para cada tipo de movimiento de stock, a fin de optimizar la tratativa e operaciones de acceso a la base de datos.

Cada línea del archivo generado por Oracle ORWMS representa un movimiento para un determinado artículo, siendo que deben ser utilizados el ITEM_ID, TRAN_DATE (fecha del movimiento), TRAN_CODE (tipo de movimiento), UNITS (cantidades), REF_NO_1 (id del movimiento) para validar si el movimiento de stock fue correctamente integrado. 

Las tablas que deberán verificadas, siempre utilizando fecha, id de transacción, articulo e cantidad:

•	Expedición (ASNOut): RFXXX_EXPEDICIONES_ARTICULO
•	Recibimiento (Receiving): RFXXX_RECIBIMIENTO_CITAS_ARTICULO
•	Ajustes de Inventario (InvAdjust): RF047T_AJUSTES_INVENTARIO_ARTICULO
•	Devoluciones a Proveedor (RTV): RF044T_ITEM_DEVOLUCIONES
