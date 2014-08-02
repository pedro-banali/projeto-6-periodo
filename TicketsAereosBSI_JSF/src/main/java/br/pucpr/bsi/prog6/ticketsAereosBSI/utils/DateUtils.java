package br.pucpr.bsi.prog6.ticketsAereosBSI.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe Utilitaria para tratamento de datas
 * @author Mauda
 *
 */

public class DateUtils {
	
	public static Date minimizeDate(Date _date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_date);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static Date maxmizeDate(Date _date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_date);

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		// o milesecundos é 998, porque o banco de dados faz confusão quando passa 999 e passa para o dia seguinte.
		// não é um erro de implementação, mas um erro do java e do banco de dados.
		calendar.set(Calendar.MILLISECOND, 998);

		return calendar.getTime();
	}
	
	public static Date converterDate(String date){
		int primeiraBarra = date.indexOf("/");
		int segundaBarra = date.lastIndexOf("/");
		
		int dia = Integer.parseInt(date.substring(0, primeiraBarra));
		int mes = Integer.parseInt(date.substring(primeiraBarra+1, segundaBarra));
		int ano = Integer.parseInt(date.substring(segundaBarra+1));
				
		GregorianCalendar gc = new GregorianCalendar(ano, mes, dia);
		return gc.getTime();
	}
}
