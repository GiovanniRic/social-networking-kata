package repository;

import java.util.List;

import model.Post;
import model.User;

public class PostKataRepository implements PostRepository {

	private Storage<Post> persistence;

	public PostKataRepository() {
		persistence = new StorageKataPost();
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
