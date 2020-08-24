package claranet.italia.social.networking.kata.model;

import java.time.LocalDateTime;

public class Post {
	
	private String message;
	private LocalDateTime timestampPost;
	
	public Post(String message, LocalDateTime timestampPost) {
		this.message = message;
		this.timestampPost = timestampPost;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestampPost() {
		return timestampPost;
	}
	
	

}
