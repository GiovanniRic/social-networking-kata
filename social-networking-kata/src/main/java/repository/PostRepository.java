package repository;

import model.User;

public interface PostRepository {
	
	public void savePost(String username, String post);
	
	public User readPostOf(String username);

}
