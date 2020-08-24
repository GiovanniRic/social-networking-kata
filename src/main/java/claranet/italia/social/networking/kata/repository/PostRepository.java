package claranet.italia.social.networking.kata.repository;

import claranet.italia.social.networking.kata.model.Post;
import claranet.italia.social.networking.kata.model.User;

public interface PostRepository {
	
	public void savePost(String username, Post post);
	
	public User readUser(String username);

}
