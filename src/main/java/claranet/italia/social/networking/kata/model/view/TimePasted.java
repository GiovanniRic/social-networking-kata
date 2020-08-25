package claranet.italia.social.networking.kata.model.view;

public class TimePasted {
	
	private TimeType timeType;
	private int value;
	
	public TimePasted(TimeType type, int value) {
		this.timeType = type;
		this.value = value;
	}

	@Override
	public String toString() {
	 return String.valueOf(value) + timeType.getValue();
	
	}

}
