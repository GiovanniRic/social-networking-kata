package social.networking.kata.repository;

import social.networking.kata.model.Post;
import social.networking.kata.model.User;

public interface PostRepository {
	
	public void savePost(String username, Post post);
	
	public User readUser(String username);

}
