package claranet.italia.social.networking.kata.model.view;

import claranet.italia.social.networking.kata.utils.DateTimeHandler;

public class PostView {
	
	private String username;
	private String message;
	private String dateTime;
	private TimePasted timpePasted;
	
	public PostView(String username, String message, String dateTime) {
		this.username = username;
		this.message = message;
		this.dateTime = dateTime;
		
	}
	
	public String getPostView() {
		return username + "-> " + message + " "
				+ "("+DateTimeHandler.getTimeFrom(dateTime) +" ago)";
		
	}

}
