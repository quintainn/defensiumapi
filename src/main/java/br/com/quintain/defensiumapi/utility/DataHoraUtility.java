package br.com.quintain.defensiumapi.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHoraUtility {
	
	private final static String FORMATO_DATA_1 = "yyyyMMdd";
	private final static String FORMATO_DATA_2 = "dd/MM/yyyy";
	private final static String FORMATO_HORA_1 = "HHmmss";
	private final static String FORMATO_HORA_2 = "HH:mm:ss";
	
	public static String obterDataHoraAtualFormatada() {
		return String.format("%s às %s", 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_2)),
				LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_HORA_2)));
	}
	
	public static String obterNumeroInstancia() {
		return String.format("DEFENSIUM%s%sAPI", 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_1)),
				LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_HORA_1)));
	}

}
