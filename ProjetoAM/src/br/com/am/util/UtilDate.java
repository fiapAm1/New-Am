package br.com.am.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
	
	/**
	 * M�todo para converter uma String para um java.util.Date. (Obs.: Formato da data parametro: dd/MM/yyyy).
	 * @author JDGR�
	 * @param data
	 * @return Date
	 */
	public static Date convertStringToDate(String data){
		try {
			if(!"".equals(data)){
				return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * M�todo para converter um java.util.Date para um String.
	 * @author JDGR�
	 * @param data
	 * @return String
	 */
	public static String convertDateToString(Date data){
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}
	
	/**
	 * M�todo para converter um java.sql.Date para um String.
	 * @author JDGR�
	 * @param data
	 * @return String
	 */
	public static String convertDateToString(java.sql.Date data){
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}
}
