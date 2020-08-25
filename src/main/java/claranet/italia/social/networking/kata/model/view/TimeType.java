package claranet.italia.social.networking.kata.model.view;

public enum TimeType {
	
	DAY("day"),
	DAYS("days"),
	MONTH("month"),
	MONTHS("months"),
	YEAR("year"),
	YEARS("years");
	
	private String value;

	TimeType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
