package br.com.cea.transporte.movements.batch.arquivo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DatasUteis {


	private static final String DATA_ARQUIVO = "YYYYMMddHHmm";

	private static final String DATA_SEM_HORA = "YYYYMMdd";

	private static Locale LOCALE = new Locale("pt", "BR");

	public static String data() {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_ARQUIVO, LOCALE);
		return formatador.format(calendar.getTime());
	}
	
	public static long mostrarDataAtualTime() {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}



	public static java.sql.Date mostrarDataAtualSql(){
		return new java.sql.Date(mostrarDataAtualTime());
		
	}


	public static String data(Date dataRota) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dataRota);
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_ARQUIVO, LOCALE);
		return formatador.format(calendar.getTime());

	}
	
	public static Date data(String dataRota) {
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_ARQUIVO, LOCALE);
			Date parse = null;
			try {
				parse = formatador.parse(dataRota);
			} catch (ParseException e) {
				log.info("Falha ao converter a data " + dataRota);
				throw new RuntimeException("Falha ao converter a data ");
			}
		return parse;

	}
	public static String dataSemHora() {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_SEM_HORA, LOCALE);
		return formatador.format(calendar.getTime());
	}
	
	public static String dataSemHora(Date dataRota) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dataRota);
		SimpleDateFormat formatador = new SimpleDateFormat(DATA_SEM_HORA, LOCALE);
		return formatador.format(calendar.getTime());
	}
}
