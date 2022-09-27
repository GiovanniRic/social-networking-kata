package social.networking.kata.repository;

import java.util.List;

import social.networking.kata.model.Post;
import social.networking.kata.model.User;

public class PostKataRepository implements PostRepository {

	private final Storage<Post> persistence;

	public PostKataRepository(Storage<Post> storage) {
		persistence = storage;
	}

	@Override
	public void savePost(String username, Post post) {
		persistence.save(username, post);

	}

	@Override
	public User readUser(String username) {

		List<Post> post = persistence.read(username);
		User user = new User(username);
		user.setPost(post);

		return user;

	}

}
