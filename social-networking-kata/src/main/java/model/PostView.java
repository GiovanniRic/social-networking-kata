package model;

public class PostView {
	
	String username;
	String message;
	String time;
	
	public PostView(String username, String message) {
		this.username = username;
		this.message = message;
		
	}
	
	public String getPostView() {
		return username + "->" + message;
		
	}

}
