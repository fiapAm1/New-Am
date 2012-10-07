package br.com.am.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
	
	/**
	 * Método para converter uma String para um java.util.Date. (Obs.: Formato da data parametro: dd/MM/yyyy).
	 * @author JDGR²
	 * @param data
	 * @return Date
	 */
	public static Date convertStringToDate(String data){
		try {
			return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
