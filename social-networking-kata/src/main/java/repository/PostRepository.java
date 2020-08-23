package repository;

import model.Post;
import model.User;

public interface PostRepository {
	
	public void savePost(String username, Post post);
	
	public User readUser(String username);

}
