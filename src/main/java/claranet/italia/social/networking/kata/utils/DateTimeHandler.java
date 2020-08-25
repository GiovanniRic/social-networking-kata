package claranet.italia.social.networking.kata.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import claranet.italia.social.networking.kata.model.view.TemporalType;
import claranet.italia.social.networking.kata.model.view.TimePasted;

public class DateTimeHandler {

	private static final String formatDate = "yyyy-MM-dd HH:mm:ss";

	public static String getDateFormated(LocalDateTime dataTime) {

		return DateTimeFormatter.ofPattern(formatDate).format(dataTime);
	}

	public static LocalDateTime getDateParsed(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
		return LocalDateTime.parse(date.trim(), formatter);

	}

	public static TimePasted getTimeFrom(String dateTime) {

		LocalDateTime datePast = getDateParsed(dateTime);
		LocalDateTime dateNow = getDateParsed(getDateFormated(LocalDateTime.now()));

		
		return retrieveTimePasted(datePast, dateNow);
		
	}
	
	private static TimePasted retrieveTimePasted(LocalDateTime datePast,LocalDateTime dateNow ) {
		
		long value = datePast.until(dateNow, ChronoUnit.YEARS);
		if (value > 0) {
			return new TimePasted(TemporalType.YEAR, (int) value);
		}

		value = datePast.until(dateNow, ChronoUnit.MONTHS);
		if (value > 0) {
			return new TimePasted(TemporalType.MONTH, (int) value);
		}

		value = datePast.until(dateNow, ChronoUnit.WEEKS);
		if (value > 0) {
			return new TimePasted(TemporalType.WEEK, (int) value);
		}

		value = datePast.until(dateNow, ChronoUnit.DAYS);
		if (value > 0) {
			return new TimePasted(TemporalType.DAY, (int) value);
		}

		value = datePast.until(dateNow, ChronoUnit.HOURS);
		if (value > 0) {
			return new TimePasted(TemporalType.HOUR, (int) value);
		}

		value = datePast.until(dateNow, ChronoUnit.MINUTES);
		if (value > 0) {
			return new TimePasted(TemporalType.MINUTE, (int) value);
		}

		value = datePast.until(dateNow, ChronoUnit.SECONDS);
		return new TimePasted(TemporalType.SECOND, (int) value);	
		
	}

}
