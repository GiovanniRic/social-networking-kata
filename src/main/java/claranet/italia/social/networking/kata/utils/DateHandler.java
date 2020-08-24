package claranet.italia.social.networking.kata.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHandler {
	
	private static final String formatDate = "yyyy-MM-dd HH:mm:ss";
	
	public static String getDateFormated(LocalDateTime dataTime) {
		
		return DateTimeFormatter.ofPattern(formatDate).format(dataTime);
	}
	
	public static LocalDateTime getDateParsed(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
		return LocalDateTime.parse(date.trim(), formatter);
		
	}

}
