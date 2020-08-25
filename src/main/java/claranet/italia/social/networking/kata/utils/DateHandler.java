package claranet.italia.social.networking.kata.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class DateHandler {
	
	private static final String formatDate = "yyyy-MM-dd HH:mm:ss";
	
	public static String getDateFormated(LocalDateTime dataTime) {
		
		return DateTimeFormatter.ofPattern(formatDate).format(dataTime);
	}
	
	public static LocalDateTime getDateParsed(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);	
		return LocalDateTime.parse(date.trim(), formatter);
		
	}
	
	public  static String getTimeFrom(String dataTime) {
		
		LocalDateTime datePast = getDateParsed(dataTime);
		LocalDateTime dateNow = getDateParsed(getDateFormated(LocalDateTime.now()));
		
		if(datePast.until(dateNow, ChronoUnit.YEARS) > 0) {
			//return 
		}
		
		
		
		System.out.println(datePast.until(dateNow, ChronoUnit.DAYS));
		System.out.println(datePast.until(dateNow, ChronoUnit.HOURS));
		System.out.println(datePast.until(dateNow, ChronoUnit.SECONDS));
		System.out.println(datePast.until(dateNow, ChronoUnit.YEARS));
		
		

		return null;	
	}

}
