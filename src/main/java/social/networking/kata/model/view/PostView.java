package social.networking.kata.model.view;

import social.networking.kata.utils.DateTimeHandler;

public class PostView {
	
	private String username;
	private String message;
	private String dateTime;
	
	public PostView(String username, String message, String dateTime) {
		this.username = username;
		this.message = message;
		this.dateTime = dateTime;
		
	}
	
	public String getPostView() {
		return username + "-> " + message + " "
				+ "("+DateTimeHandler.getTimeFrom(dateTime) +" ago)";
		
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	

}
