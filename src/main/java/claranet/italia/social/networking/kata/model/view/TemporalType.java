package claranet.italia.social.networking.kata.model.view;

public enum TemporalType {

	SECOND("second"),
	MINUTE("minute"),
	HOUR("hour"),
	WEEK("week"),
	DAY("day"),
	MONTH("month"),
	YEAR("year");

	private String value;

	TemporalType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
