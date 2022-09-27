package social.networking.kata.model.view;

public class TimePasted {

	private TemporalType timeType;
	private int value;

	public TimePasted(TemporalType type, int value) {
		this.timeType = type;
		this.value = value;
	}

	@Override
	public String toString() {
		if (value > 1) {
			return String.valueOf(value) + " " + timeType.getValue() + "s";
		} else {
			return String.valueOf(value) + " " + timeType.getValue();
		}
	}

}
