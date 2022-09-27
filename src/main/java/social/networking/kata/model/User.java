package social.networking.kata.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String username;
	private List<Post> post;
	
	public User(String username) {
		this.username = username;
		post = new ArrayList<Post>(); 
		
	}
	
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
	
	
	
	

}
